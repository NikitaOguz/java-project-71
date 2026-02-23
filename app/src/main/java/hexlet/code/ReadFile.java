package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {

    public static String read(String filepath) throws IOException {

        Path path = Paths.get(filepath);

        if (Files.exists(path)) {
            return Files.readString(path.toAbsolutePath().normalize());
        }

        Path testPath = Paths.get("src/test/resources", filepath);

        if (Files.exists(testPath)) {
            return Files.readString(testPath.toAbsolutePath().normalize());
        }

        throw new IOException("File not found: " + filepath);
    }
}