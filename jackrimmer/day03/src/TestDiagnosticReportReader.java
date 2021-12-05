import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiagnosticReportReader {
    private DiagnosticReportReader testReader = new DiagnosticReportReader("src/example-input.txt");

    @Test
    public void testReadDiagnosticBits() {
        List<String> expectedValues = new ArrayList<>() {{
            add("00100");
            add("11110");
            add("10110");
            add("10111");
            add("10101");
            add("01111");
            add("00111");
            add("11100");
            add("10000");
            add("11001");
            add("00010");
            add("01010");
        }};

        List<String> actualValues = testReader.getDiagnosticReport();

        assertEquals(expectedValues, actualValues, "Returns a list of bytes in the correct format");
    }

//    @Test
//    public void testReadOxygenGeneratorRating() {
//        String expectedRating = "10111";
//        String actualRating = DiagnosticReportReader.readOxygenRating("src/example-input.txt");
//
//        assertEquals(expectedRating, actualRating, "Returns the correct oxygen rating");
//    }
}
