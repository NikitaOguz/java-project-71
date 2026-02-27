package hexlet.code;
import java.util.Map;
public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        var content1 = ReadFile.read(filepath1);
        var content2 = ReadFile.read(filepath2);

        var fileType1 = getFileType(filepath1);
        var fileType2 = getFileType(filepath2);

        Map<String, Object> map1 = ParserFile.parse(content1, fileType1);
        Map<String, Object> map2 = ParserFile.parse(content2, fileType2);

        var diff = Comparator.compare(map1, map2);
        return Formatter.format(diff, format);
    }
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
    private static String getFileType(String filepath) {
        return filepath.substring(filepath.lastIndexOf('.') + 1);
    }
}

