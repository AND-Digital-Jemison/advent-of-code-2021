import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

//    public List<String> readDiagnosticPowerValues(String reportPath) {
//        try {
//            List<String> lines = Files.readAllLines(Paths.get(reportPath));
//            List<String> bitSet = new ArrayList<>();
//
//            for (int column = 0; column < lines.get(0).length(); column++) {
//                var bitSetBuilder = new StringBuilder();
//
//                for (int row = 0; row < lines.size(); row++) {
//                    bitSetBuilder.append(lines.get(row).charAt(column));
//                }
//
//                bitSet.add(bitSetBuilder.toString());
//            }
//
//            return bitSet;
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        throw new RuntimeException("Could not load file");
//    }
//
//    public String readOxygenRating(String reportPath) {
//        try {
//            List<String> lines = Files.readAllLines(Paths.get(reportPath));
//
//            while (lines.size() != 1) {
//
//            }
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        throw new RuntimeException("Could not load file");
//    }
}
