package hexlet.code.formats;

import hexlet.code.DiffNode;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String format(List<DiffNode> nodes) {
        StringBuilder sb = new StringBuilder();

        for (DiffNode node : nodes) {

            switch (node.status()) {

                case ADDED -> sb.append(
                        String.format(
                                "Property '%s' was added with value: %s\n",
                                node.key(),
                                formatValue(node.newValue())
                        )
                );

                case REMOVED -> sb.append(
                        String.format(
                                "Property '%s' was removed\n",
                                node.key()
                        )
                );

                case CHANGED -> sb.append(
                        String.format(
                                "Property '%s' was updated. From %s to %s\n",
                                node.key(),
                                formatValue(node.oldValue()),
                                formatValue(node.newValue())
                        )
                );

                case UNCHANGED -> {
                    // ничего не выводим
                }
            }
        }

        return sb.toString().trim();
    }

    private static String formatValue(Object value) {

        if (value == null) {
            return "null";
        }

        if (value instanceof String) {
            return "'" + value + "'";
        }

        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }

        return value.toString();
    }
}
