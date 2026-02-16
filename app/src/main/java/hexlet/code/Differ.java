package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {

        // Читаем файлы
        var content1 = ReadFile.read(filepath1);
        var content2 = ReadFile.read(filepath2);

        // Определяем тип файлов
        var fileType1 = getFileType(filepath1);
        var fileType2 = getFileType(filepath2);

        // Парсим JSON → Map
        Map<String, Object> map1 = ParserFile.parse(content1, fileType1);
        Map<String, Object> map2 = ParserFile.parse(content2, fileType2);

        // Сортируем ключи
        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (String key : keys) {

            boolean inFirst = map1.containsKey(key);
            boolean inSecond = map2.containsKey(key);

            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

            // Удалён
            if (inFirst && !inSecond) {
                sb.append(String.format("  - %s: %s\n", key, value1));

                // Добавлен
            } else if (!inFirst && inSecond) {
                sb.append(String.format("  + %s: %s\n", key, value2));

                // Изменён
            } else if (!value1.equals(value2)) {
                sb.append(String.format("  - %s: %s\n", key, value1));
                sb.append(String.format("  + %s: %s\n", key, value2));

                // Без изменений
            } else {
                sb.append(String.format("    %s: %s\n", key, value1));
            }
        }

        sb.append("}");

        return sb.toString();
    }

    private static String getFileType(String filepath) {
        return filepath.substring(filepath.lastIndexOf('.') + 1);
    }
}
