import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {

    application
    // jacoco
    alias(libs.plugins.spotless)
    alias(libs.plugins.lombok)
    alias(libs.plugins.shadow)
    alias(libs.plugins.sonarqube)
    `jvm-test-suite`
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.App") }

repositories { mavenCentral() }

dependencies {
    implementation(libs.commons.lang3)
    implementation(libs.commons.collections4)
    implementation("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.5")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter(libs.versions.junit.get())
        }
    }
}

tasks.test {
    testLogging {
        showStandardStreams = true

        // какие события показывать
        events(
            TestLogEvent.FAILED,
            TestLogEvent.PASSED,
            TestLogEvent.SKIPPED,
            TestLogEvent.STANDARD_OUT,
            TestLogEvent.STANDARD_ERROR,
        )

        // формат исключений
        exceptionFormat = TestExceptionFormat.FULL

        // детали
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }
}

spotless {
    java {
        // don't need to set target, it is inferred from java

        // apply a specific flavor of google-java-format
        // googleJavaFormat('1.8').aosp().reflowLongStrings().skipJavadocFormatting()
        // fix formatting of type annotations
        importOrder()
        googleJavaFormat().aosp()
        formatAnnotations()
        removeUnusedImports()
        leadingTabsToSpaces(4)
        endWithNewline()
        // make sure every file has the following copyright header.
        // optionally, Spotless can set copyright years by digging
        // through git history (see "license" section below)
        // licenseHeader '/* (C)$YEAR */'
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
sonarqube {
    properties {
        property("sonar.projectKey", "NikitaOguz_java-project-71")
        property("sonar.organization", "nikitoguzkov")
    }
}
