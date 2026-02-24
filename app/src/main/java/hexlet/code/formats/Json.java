package hexlet.code.formats;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffNode;

import java.util.List;

public class Json {

    public static String format(List<DiffNode> nodes) throws Exception {
        return new ObjectMapper().writeValueAsString(nodes);
    }
}
