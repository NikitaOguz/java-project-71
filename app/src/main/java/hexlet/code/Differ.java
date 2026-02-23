package hexlet.code;

import hexlet.code.formats.Plain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        var content1 = ReadFile.read(filepath1);
        var content2 = ReadFile.read(filepath2);

        var fileType1 = getFileType(filepath1);
        var fileType2 = getFileType(filepath2);

        Map<String, Object> map1 = ParserFile.parse(content1, fileType1);
        Map<String, Object> map2 = ParserFile.parse(content2, fileType2);

        var diff = compare(map1, map2);

        return Formatter.format(diff, format);
    }

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


    public static String format(List<DiffNode> diff, String format)  {
        return Plain.format(diff);
    }
    private static String getFileType(String filepath) {
        return filepath.substring(filepath.lastIndexOf('.') + 1);
    }
}
