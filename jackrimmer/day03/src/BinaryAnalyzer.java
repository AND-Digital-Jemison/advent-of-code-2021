import java.util.ArrayList;
import java.util.List;

public class BinaryAnalyzer {
    public int calculateLifeSupportRating(List<String> diagnosticReport) {
        int oxygenGeneratorRating = calculateLifeSupportMetrics(Metric.OXYGEN_GENERATOR_RATING, diagnosticReport);
        int co2ScrubberRating = calculateLifeSupportMetrics(Metric.CO2_SCRUBBER_RATING, diagnosticReport);

        return oxygenGeneratorRating * co2ScrubberRating;
    }

    public int calculatePowerConsumed(List<String> diagnosticReport) {
        int gammaRate = calculatePowerRating(FrequencyType.HIGHEST, diagnosticReport);
        int epsilonRate = calculatePowerRating(FrequencyType.LOWEST, diagnosticReport);

        return gammaRate * epsilonRate;
    }

    private int calculateLifeSupportMetrics(Metric metric, List<String> diagnosticReport) {
        List<String> bitColumns = getBitColumns(diagnosticReport);
        List<String> tempReport = new ArrayList<>(diagnosticReport);
        List<String> tempReportCopy = new ArrayList<>(diagnosticReport);

        for (int i = 0; i < bitColumns.size(); i++) {
            FrequencyType frequencyType = metric == metric.OXYGEN_GENERATOR_RATING ? FrequencyType.HIGHEST : FrequencyType.LOWEST;
            int highestFrequencyBit = frequency(frequencyType, bitColumns.get(i));

            for (String bits: tempReport) {
                if (Character.getNumericValue(bits.charAt(i)) != highestFrequencyBit) {
                    tempReportCopy.remove(bits);
                }
            }

            tempReport.clear();
            tempReport.addAll(tempReportCopy);
            bitColumns = getBitColumns(tempReport);

            if (tempReportCopy.size() == 1) {
                return Integer.parseInt(tempReportCopy.get(0), 2);
            }
        }

        throw new IllegalArgumentException("Must have a single remaining report value");
    }

    private int calculatePowerRating(FrequencyType frequencyType, List<String> diagnosticReport) {
        List<String> bitColumns = getBitColumns(diagnosticReport);

        var ratingBuilder = new StringBuilder();
        for (String bits: bitColumns) {
            ratingBuilder.append(frequency(frequencyType, bits));
        }

        return Integer.parseInt(ratingBuilder.toString(), 2);
    }

    private List<String> getBitColumns(List<String> diagnosticReport) {
        List<String> bitSet = new ArrayList<>();

        for (int column = 0; column < diagnosticReport.get(0).length(); column++) {
            var bitSetBuilder = new StringBuilder();

            for (int row = 0; row < diagnosticReport.size(); row++) {
                bitSetBuilder.append(diagnosticReport.get(row).charAt(column));
            }

            bitSet.add(bitSetBuilder.toString());
        }

        return bitSet;
    }

    private int frequency(FrequencyType frequencyType, String bits) {
        int mostCommonThreshold = bits.length() / 2;
        int zeroCount = 0;
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '0') {
                zeroCount++;
            }
        }

        switch(frequencyType) {
            case HIGHEST:
                if (zeroCount > mostCommonThreshold) {
                    return 0;
                }

                return zeroCount > mostCommonThreshold ? 0 : 1;

            case LOWEST:
                return zeroCount > mostCommonThreshold ? 1 : 0;

            default:
                throw new IllegalArgumentException("Invalid rate type");
        }
    }
}
