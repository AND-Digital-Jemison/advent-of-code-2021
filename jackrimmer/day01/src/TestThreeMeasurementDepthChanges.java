import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestThreeMeasurementDepthChanges {
    private final SonarSweep sonarSweep = new SonarSweep();

    @Test
    public void testThreeMeasurementUnchangedDepth() {
        assertEquals(0, sonarSweep.threeMeasurementDepthIncrease(new ArrayList<>()), "Depth count should not change");
    }

    @Test
    public void testThreeMeasurementFirstDepth() {
        var depths = new ArrayList<Integer>() {{
            add(100);
        }};

        assertEquals(0, sonarSweep.threeMeasurementDepthIncrease(depths), "Depth count should not change");
    }

    @Test
    public void testThreeMeasurementFirstTwoDepths() {
        var depths = new ArrayList<Integer>() {{
            add(100);
            add(101);
        }};

        assertEquals(0, sonarSweep.threeMeasurementDepthIncrease(depths), "Depth count should not change");
    }

    @Test
    public void testThreeMeasurementSingleDepthIncrease() {
        var depths = new ArrayList<Integer>() {{
            add(99);
            add(100);
            add(101);
            add(102);
        }};
        assertEquals(
                1,
                sonarSweep.threeMeasurementDepthIncrease(depths),
                "Depth count should increase once"
        );
    }
}
