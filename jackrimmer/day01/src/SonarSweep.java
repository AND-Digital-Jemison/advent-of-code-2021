import java.util.ArrayList;
import java.util.List;

public class SonarSweep {
    public int threeMeasurementDepthIncrease(List<Integer> depths) {
        var threeMeasurementWindows = new ArrayList<Integer>();

        for (int i = 2; i < depths.size(); i++) {
            threeMeasurementWindows.add(
                    depths.get(i - 2) +
                    depths.get(i - 1) +
                    depths.get(i)
            );
        }

        return totalDepthIncrease(threeMeasurementWindows);
    }

    public int totalDepthIncrease(List<Integer> depths) {
        int total = 0;
        for (int i = 1; i < depths.size(); i++) {
            total += countDepthIncrease(depths.get(i - 1), depths.get(i));
        }

        return total;
    }

    private int countDepthIncrease(int previousDepth, int currentDepth) {
        return previousDepth < currentDepth
                ? 1
                : 0;
    }

}
