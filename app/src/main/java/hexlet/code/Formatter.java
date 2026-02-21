package hexlet.code;

import hexlet.code.formats.Stylish;

import java.util.List;

public class Formatter {

    public static String format(List<DiffNode> diff, String format) {
        return switch (format) {
            case "stylish" -> Stylish.format(diff);
            default -> throw new IllegalArgumentException("Unknown format: " + format);
        };
    }
}
