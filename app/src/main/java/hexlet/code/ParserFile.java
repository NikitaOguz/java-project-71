package hexlet.code;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
public class ParserFile {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Map<String, Object> parse(String content) throws Exception {
        return mapper.readValue(content, Map.class);
    }
}
