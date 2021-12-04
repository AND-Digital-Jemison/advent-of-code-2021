import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinaryAnalyzer {
    private BinaryAnalyzer binaryAnalyzer = new BinaryAnalyzer();
    private List<String> diagnosticReport = new DiagnosticReportReader("src/example-input.txt").getDiagnosticReport();

    @Test
    public void testPowerConsumptionCalculation() {
        assertEquals(
                198,
                binaryAnalyzer.calculatePowerConsumed(diagnosticReport),
                "Should return the expected power consumed"
        );
    }

    @Test
    public void testCalculateLifeSupportRating() {
        assertEquals(230, binaryAnalyzer.calculateLifeSupportRating(diagnosticReport), "Should return the correct life support rating");
    }
}
