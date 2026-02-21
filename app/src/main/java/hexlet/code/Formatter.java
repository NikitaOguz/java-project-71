package hexlet.code;

import hexlet.code.formats.Json;
import hexlet.code.formats.Plain;
import hexlet.code.formats.Stylish;

import java.util.List;

public class Formatter {

    public static String format(List<DiffNode> diff, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.format(diff);
            case "plain" -> Plain.format(diff);
            case "json" -> Json.format(diff);
            default -> throw new IllegalArgumentException("Unknown format: " + format);
        };
    }
}
