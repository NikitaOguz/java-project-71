package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class ParserFile {

    public static Map parse(String content, String fileType) throws Exception {
        ObjectMapper mapper;

        if (fileType.equals("json")) {
            mapper = new ObjectMapper();
        } else if (fileType.equals("yml") || fileType.equals("yaml")) {
            mapper = new ObjectMapper(new YAMLFactory());
        } else {
            throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }

        return mapper.readValue(content, Map.class);
    }
}
