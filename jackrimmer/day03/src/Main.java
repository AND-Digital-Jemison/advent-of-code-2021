import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> diagnosticReport = new DiagnosticReportReader("src/diagnostic-report.txt").getDiagnosticReport();

        var binaryAnalyzer = new BinaryAnalyzer();
        int powerConsumption = binaryAnalyzer.calculatePowerConsumed(diagnosticReport);
        int lifeSupportRating = binaryAnalyzer.calculateLifeSupportRating(diagnosticReport);

        System.out.println("Power Consumed: " + powerConsumption);
        System.out.println("Life Support Rating: " + lifeSupportRating);
    }
}
