import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDepthChanges {
    private final SonarSweep sonarSweep = new SonarSweep();

    @Test
    public void testUnchangedDepth() {
        assertEquals(0, sonarSweep.totalDepthIncrease(new ArrayList<>()), "Depth count should not change");
    }

    @Test
    public void testFirstDepth() {
        var depths = new ArrayList<Integer>() {{
            add(100);
        }};

        assertEquals(0, sonarSweep.totalDepthIncrease(depths), "Depth count should not change");
    }

    @Test
    public void testSingleDepthIncrease() {
        var depths = new ArrayList<Integer>() {{
            add(100);
            add(105);
        }};
        assertEquals(
                1,
                sonarSweep.totalDepthIncrease(depths),
                "Depth count should increase once"
        );
    }

    @Test
    public void testSingleDepthDecrease() {
        var depths = new ArrayList<Integer>() {{
            add(105);
            add(100);
        }};

        assertEquals(0, sonarSweep.totalDepthIncrease(depths), "Depth count should increase once");
    }

    @Test
    public void testMultiDepthIncrease() {
        var depths = new ArrayList<Integer>() {{
            add(100);
            add(101);
            add(102);
        }};

        assertEquals(
                2,
                sonarSweep.totalDepthIncrease(depths),
                "Depth count should increase twice"
        );
    }

    @Test
    public void testMultiDepthOscillation() {
        var depths = new ArrayList<Integer>() {{
            add(100);
            add(99);
            add(105);
        }};

        assertEquals(1, sonarSweep.totalDepthIncrease(depths), "Depth count should increase once");
    }

    @Test
    public void testMultiDepthDecrease() {
        var depths = new ArrayList<Integer>() {{
            add(100);
            add(99);
            add(98);
        }};

        assertEquals(0, sonarSweep.totalDepthIncrease(depths), "Depth count should not increase");
    }
}
