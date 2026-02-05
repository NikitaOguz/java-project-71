package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
public class ReadFile {
    public static String read(String path) throws Exception {
        return Files.readString(Path.of(path));
    }
}
