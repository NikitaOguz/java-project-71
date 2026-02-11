package hexlet.code;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    public static String read(String filepath) throws IOException {

        // Преобразуем строку пути в Path
        Path path = Paths.get(filepath).toAbsolutePath().normalize();

        // Проверка существования файла
        if (!Files.exists(path)) {
            throw new IOException("File not found: " + path);
        }

        // Читаем содержимое файла в строку
        return Files.readString(path);
    }
}
