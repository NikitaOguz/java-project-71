package hexlet.code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    void testFlatJsonDiff() throws Exception {

        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";

        String expected = """
{
  - follow: false
    host: hexlet.io
  - proxy: 123.234.53.22
  - timeout: 50
  + timeout: 20
  + verbose: true
}
""";

        String actual = Differ.generate(path1, path2);

        assertEquals(expected.trim(), actual.trim());
    }
}

