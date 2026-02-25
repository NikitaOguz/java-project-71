import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    jacoco
    id("checkstyle")
    id("io.freefair.lombok") version "8.6"
    id("com.github.ben-manes.versions") version "0.50.0"
    id("com.gradleup.shadow") version "9.2.2"
    // Плагин для публикации отчета о покрытии тестами на SonarQube
    id("org.sonarqube") version "6.0.1.5171"
}

group = "io.hexlet"

version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.App") }

repositories { mavenCentral() }

dependencies {
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.0")

    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher") // ← ВОТ ЭТО ДОБАВЬ
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }

// Конфигурация плагина org.sonarqube
sonarqube {
    properties {
        property("sonar.projectKey", "NikitaOguz_java-project-71")
        property("sonar.organization", "nikitoguzkov")
    }
}
tasks.named("installDist") {
    enabled = false
}

tasks.named("installShadowDist") {
    enabled = false
}

tasks.register("install") {
    dependsOn("installDist")
}

