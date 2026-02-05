package hexlet.code;

import java.util.Map;
public class CreateFile {

    public static void main(String[] args) throws Exception {

        String path1 = "file1.json";
        String path2 = "file2.json";

        // Читаем оба файла
        String content1 = ReadFile.read(path1);
        String content2 = ReadFile.read(path2);

        // Парсим оба файла
        Map<String, Object> data1 = ParserFile.parse(content1);
        Map<String, Object> data2 = ParserFile.parse(content2);

        System.out.println("File1: " + data1);
        System.out.println("File2: " + data2);
    }
}
