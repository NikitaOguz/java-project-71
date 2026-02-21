package hexlet.code.formats;

import hexlet.code.DiffNode;

import java.util.List;

public class Stylish {

    public static String format(List<DiffNode> diff) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (var node : diff) {
            switch (node.status()) {
                case UNCHANGED -> sb.append("    ")
                        .append(node.key())
                        .append(": ")
                        .append(node.oldValue())
                        .append("\n");

                case REMOVED -> sb.append("  - ")
                        .append(node.key())
                        .append(": ")
                        .append(node.oldValue())
                        .append("\n");

                case ADDED -> sb.append("  + ")
                        .append(node.key())
                        .append(": ")
                        .append(node.newValue())
                        .append("\n");

                case CHANGED -> {
                    sb.append("  - ")
                            .append(node.key())
                            .append(": ")
                            .append(node.oldValue())
                            .append("\n");

                    sb.append("  + ")
                            .append(node.key())
                            .append(": ")
                            .append(node.newValue())
                            .append("\n");
                }
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
