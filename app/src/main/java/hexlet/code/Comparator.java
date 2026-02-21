package hexlet.code;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;

public class Comparator {

    public static String compare(Map<String, Object> map1, Map<String, Object> map2) {

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

            // удалён
            if (inFirst && !inSecond) {
                sb.append(String.format("  - %s: %s\n", key, value1));

                // добавлен
            } else if (!inFirst && inSecond) {
                sb.append(String.format("  + %s: %s\n", key, value2));

                // изменён
            } else if (!value1.equals(value2)) {
                sb.append(String.format("  - %s: %s\n", key, value1));
                sb.append(String.format("  + %s: %s\n", key, value2));

                // без изменений
            } else {
                sb.append(String.format("    %s: %s\n", key, value1));
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
