import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternfishBreedingSimulatorTest {
    String rawData = LanternfishDataReader.readRawLanternfishData("src/example-input.txt");
    List<Lanternfish> initialPopulation = LanternfishDataFormatter.format(rawData);

    @Test
    public void testElapseOneDay() {
        var simulator = new LanternfishBreedingSimulator(initialPopulation);

        simulator.elapseTime(1);

        List<Integer> expectedInternalTimers = Arrays.asList(
            2, 3, 2, 0, 1
        );

        List<Lanternfish> actualLanternfishSchool = simulator.getLanternfishSchool();

        assertEquals(expectedInternalTimers.size(), actualLanternfishSchool.size());
        for (int i = 0; i < expectedInternalTimers.size(); i++) {
            assertEquals(expectedInternalTimers.get(i), actualLanternfishSchool.get(i).getInternalTimer());
        }
    }

    @Test
    public void testElapseTwoDays() {
        var simulator = new LanternfishBreedingSimulator(initialPopulation);

        simulator.elapseTime(2);

        List<Integer> expectedInternalTimers = Arrays.asList(
                1, 2, 1, 6, 0, 8
        );

        List<Lanternfish> actualLanternfishSchool = simulator.getLanternfishSchool();

        assertEquals(expectedInternalTimers.size(), actualLanternfishSchool.size());
        for (int i = 0; i < expectedInternalTimers.size(); i++) {
            assertEquals(expectedInternalTimers.get(i), actualLanternfishSchool.get(i).getInternalTimer());
        }
    }

    @Test
    public void testElapseTenDays() {
        var simulator = new LanternfishBreedingSimulator(initialPopulation);

        simulator.elapseTime(10);

        List<Integer> expectedInternalTimers = Arrays.asList(
                0, 1, 0, 5, 6, 0, 1, 2, 2, 3, 7, 8
        );

        List<Lanternfish> actualLanternfishSchool = simulator.getLanternfishSchool();

        assertEquals(expectedInternalTimers.size(), actualLanternfishSchool.size());
        for (int i = 0; i < expectedInternalTimers.size(); i++) {
            assertEquals(expectedInternalTimers.get(i), actualLanternfishSchool.get(i).getInternalTimer());
        }
    }

    @Test
    public void testElapseEighteenDays() {
        var simulator = new LanternfishBreedingSimulator(initialPopulation);

        simulator.elapseTime(18);

        List<Integer> expectedInternalTimers = Arrays.asList(
                6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8,8,8,8
        );

        List<Lanternfish> actualLanternfishSchool = simulator.getLanternfishSchool();

        assertEquals(expectedInternalTimers.size(), actualLanternfishSchool.size());
        for (int i = 0; i < expectedInternalTimers.size(); i++) {
            assertEquals(expectedInternalTimers.get(i), actualLanternfishSchool.get(i).getInternalTimer());
        }
    }
}
