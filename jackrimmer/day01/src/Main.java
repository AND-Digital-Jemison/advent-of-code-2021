import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var depths = DepthsReader.readDepths();

        SonarSweep sonarSweep = new SonarSweep();

        System.out.println(sonarSweep.totalDepthIncrease(depths));
        System.out.println(sonarSweep.threeMeasurementDepthIncrease(depths));
    }
}
