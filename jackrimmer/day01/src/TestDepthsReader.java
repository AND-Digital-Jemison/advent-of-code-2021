import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDepthsReader {
    @Test
    public void testAllLinesAreRead() throws IOException {
        assertTrue(DepthsReader.readDepths().size() == 2000);
    }
}
