package hexlet.code.formats;

import hexlet.code.DiffNode;

import java.util.List;
import java.util.Map;

import java.util.StringJoiner;

import hexlet.code.Status;

public class Stylish {

    public static String format(List<DiffNode> diff) {
        StringJoiner sj = new StringJoiner("\n");

        for (DiffNode node : diff) {
            String key = node.key();

            String line = switch (node.status()) {
                case REMOVED -> String.format("  - %s: %s",
                        key, stringify(node.oldValue()));

                case ADDED -> String.format("  + %s: %s",
                        key, stringify(node.newValue()));

                case UNCHANGED -> String.format("    %s: %s",
                        key, stringify(node.oldValue()));

                case CHANGED -> String.format("  - %s: %s",
                        key, stringify(node.oldValue()))
                        + "\n"
                        + String.format("  + %s: %s",
                        key, stringify(node.newValue()));
            };

            sj.add(line);
        }

        return "{\n" + sj + "\n}";
    }

    private static String stringify(Object value) {
        if (value == null) return "null";

        // Строки оборачиваем в кавычки
        if (value instanceof String) return value.toString();

        // Map и List оставляем через toString(), чтобы Stylish показывал полное содержимое
        return value.toString();
    }
}

