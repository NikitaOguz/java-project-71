package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class ParserFile {
    public static Map<String, Object> parse(String content, String fileType) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        // поддержка JSON
        if (fileType.equals("json")) {
            return mapper.readValue(content, Map.class);
        }

        throw new IllegalArgumentException("Unsupported file type: " + fileType);
    }
}
