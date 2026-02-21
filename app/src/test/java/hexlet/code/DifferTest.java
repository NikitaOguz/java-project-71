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

        assertEquals(expected, actual);
    }

    @Test
    void testYamlStylish() throws Exception {
        var file1 = getPath("file1.yml").toString();
        var file2 = getPath("file2.yml").toString();
        var expected = readFile("expectedStylish.txt");

        var actual = Differ.generate(file1, file2, "stylish");

        assertEquals(expected, actual);
    }
}

