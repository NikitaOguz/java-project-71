package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Comparator {

    public static List<DiffNode> compare(Map<String, Object> map1,
                                         Map<String, Object> map2) {

        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        List<DiffNode> result = new ArrayList<>();

        for (String key : keys) {

            if (!map1.containsKey(key)) {
                result.add(new DiffNode(
                        key,
                        Status.ADDED,
                        null,
                        map2.get(key)
                ));

            } else if (!map2.containsKey(key)) {
                result.add(new DiffNode(
                        key,
                        Status.REMOVED,
                        map1.get(key),
                        null
                ));

            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                result.add(new DiffNode(
                        key,
                        Status.CHANGED,
                        map1.get(key),
                        map2.get(key)
                ));

            } else {
                result.add(new DiffNode(
                        key,
                        Status.UNCHANGED,
                        map1.get(key),
                        map2.get(key)
                ));
            }
        }
        return result;
    }
}
