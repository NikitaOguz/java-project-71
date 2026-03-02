package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static Path getPath(String file) {
        return Paths.get("src/test/resources", file)
                .toAbsolutePath()
                .normalize();
    }

    private static String readFile(String file) throws Exception {
        return Files.readString(getPath(file)).trim();
    }

    @Test
    void testJsonStylish() throws Exception {
        var file1 = getPath("file1.json").toString();
        var file2 = getPath("file2.json").toString();
        var expected = readFile("expectedStylish.txt");

        var actual = Differ.generate(file1, file2, "stylish");

        String expectedNormalized = expected.replace("\r\n", "\n").trim();
        String actualNormalized = actual.replace("\r\n", "\n").trim();

        assertEquals(expectedNormalized, actualNormalized);
    }

    @Test
    void testYamlStylish() throws Exception {
        var file1 = getPath("file1.yml").toString();
        var file2 = getPath("file2.yml").toString();
        var expected = readFile("expectedStylish.txt");

        var actual = Differ.generate(file1, file2, "stylish");

        // нормализуем переносы строк
        String expectedNormalized = expected.replace("\r\n", "\n").trim();
        String actualNormalized = actual.replace("\r\n", "\n").trim();

        assertEquals(expectedNormalized, actualNormalized);
    }
    @Test
    void testYamlJson() throws Exception {
        var file1 = getPath("file1.yml").toString();
        var file2 = getPath("file2.yml").toString();
        var expected = readFile("expectedJson.txt");

        var actual = Differ.generate(file1, file2, "json");
        String expectedNormalized = expected.replace("\r\n", "\n").trim();
        String actualNormalized = actual.replace("\r\n", "\n").trim();

        assertEquals(expectedNormalized, actualNormalized);
    }
    @Test
    void testJsonPlain() throws Exception {
        var file1 = getPath("file1.json").toString();
        var file2 = getPath("file2.json").toString();
        var expected = readFile("expectedPlain.txt");

        var actual = Differ.generate(file1, file2, "plain");

        String expectedNormalized = expected.replace("\r\n", "\n").trim();
        String actualNormalized = actual.replace("\r\n", "\n").trim();

        assertEquals(expectedNormalized, actualNormalized);
    }

    @Test
    void testYamlPlain() throws Exception {
        var file1 = getPath("file1.yml").toString();
        var file2 = getPath("file2.yml").toString();
        var expected = readFile("expectedPlain.txt");

        var actual = Differ.generate(file1, file2, "plain");

        String expectedNormalized = expected.replace("\r\n", "\n").trim();
        String actualNormalized = actual.replace("\r\n", "\n").trim();

        assertEquals(expectedNormalized, actualNormalized);
    }
    @Test
    void testJsonFormat() throws Exception {
        var file1 = getPath("file1.json").toString();
        var file2 = getPath("file2.json").toString();
        var expected = readFile("expectedJson.txt");

        var actual = Differ.generate(file1, file2, "json");

        String expectedNormalized = expected.replace("\r\n", "\n").trim();
        String actualNormalized = actual.replace("\r\n", "\n").trim();

        assertEquals(expectedNormalized, actualNormalized);
    }
    @Test
    void testJsonDefault() throws Exception {
        var file1 = getPath("file1.json").toString();
        var file2 = getPath("file2.json").toString();
        var expected = readFile("expectedStylish.txt");

        var actual = Differ.generate(file1, file2);

        String expectedNormalized = expected.replace("\r\n", "\n").trim();
        String actualNormalized = actual.replace("\r\n", "\n").trim();

        assertEquals(expectedNormalized, actualNormalized);
    }

    @Test
    void testYamlDefault() throws Exception {
        var file1 = getPath("file1.yml").toString();
        var file2 = getPath("file2.yml").toString();
        var expected = readFile("expectedStylish.txt");

        var actual = Differ.generate(file1, file2);

        String expectedNormalized = expected.replace("\r\n", "\n").trim();
        String actualNormalized = actual.replace("\r\n", "\n").trim();

        assertEquals(expectedNormalized, actualNormalized);
    }
}

