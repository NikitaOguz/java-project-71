package hexlet.code;

import java.util.Objects;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

public class Comparator {

    public static List<DiffNode> compare(Map<String, Object> map1, Map<String, Object> map2) {
        List<DiffNode> diffList = new ArrayList<>();

        // Собираем все ключи и сортируем их
        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            boolean inFirst = map1.containsKey(key);
            boolean inSecond = map2.containsKey(key);
            Object val1 = map1.get(key);
            Object val2 = map2.get(key);

            Status status;
            Object oldValue = null;
            Object newValue = null;

            if (inFirst && !inSecond) {
                status = Status.REMOVED;
                oldValue = val1;
            } else if (!inFirst && inSecond) {
                status = Status.ADDED;
                newValue = val2;
            } else { // ключ есть в обеих
                if (Objects.equals(val1, val2)) {
                    status = Status.UNCHANGED;
                    oldValue = val1;
                    newValue = val2;
                } else {
                    status = Status.CHANGED;
                    oldValue = val1;
                    newValue = val2;
                }
            }

            diffList.add(new DiffNode(key, status, oldValue, newValue));
        }

        return diffList;
    }
}
