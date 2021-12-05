import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DiagnosticReportReader {
    private List<String> diagnosticReport;

    public DiagnosticReportReader(String reportPath) {
        readDiagnosticReport(reportPath);
    }

    public List<String> getDiagnosticReport() {
        return diagnosticReport;
    }

    private void readDiagnosticReport(String reportPath) {
        try {
            this.diagnosticReport = Files.readAllLines(Paths.get(reportPath));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
