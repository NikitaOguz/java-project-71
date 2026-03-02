package hexlet.code;

import java.util.Map;

public class Differ {

    public static String generate(String path1, String path2, String format) throws Exception {

        var content1 = Read.read(path1);
        var content2 = Read.read(path2);

        var format1 = getFormat(path1);
        var format2 = getFormat(path2);

        Map<String, Object> map1 = Parser.parse(content1, format1);
        Map<String, Object> map2 = Parser.parse(content2, format2);

        var diff = Comparator.compare(map1, map2);
        return Formatter.format(diff, format);
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }

    private static String getFormat(String path) {
        return path.substring(path.lastIndexOf('.') + 1);
    }
}
