import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EfficientLanternfishBreedingSimulatorTest {
    String rawData = LanternfishDataReader.readRawLanternfishData("src/example-input.txt");
    List<Lanternfish> initialPopulation = LanternfishDataFormatter.format(rawData);

    @Test
    public void testElapseOneDay() {
        var simulator = new EfficientLanternfishBreedingSimulator(initialPopulation);
        simulator.elapseTime(1);

        long expectedPopulationSize = 5;

        long actualPopulationSize = simulator.getPopulationSize();

        assertEquals(expectedPopulationSize, actualPopulationSize);
    }

    @Test
    public void testElapseTwoDays() {
        var simulator = new EfficientLanternfishBreedingSimulator(initialPopulation);
        simulator.elapseTime(2);

        long expectedPopulationSize = 6;

        long actualPopulationSize = simulator.getPopulationSize();

        assertEquals(expectedPopulationSize, actualPopulationSize);
    }

    @Test
    public void testElapseFourDays() {
        var simulator = new EfficientLanternfishBreedingSimulator(initialPopulation);
        simulator.elapseTime(4);

        long expectedPopulationSize = 9;

        long actualPopulationSize = simulator.getPopulationSize();

        assertEquals(expectedPopulationSize, actualPopulationSize);
    }

    @Test
    public void testElapseTenDays() {
        var simulator = new EfficientLanternfishBreedingSimulator(initialPopulation);
        simulator.elapseTime(10);

        long expectedPopulationSize = 12;

        long actualPopulationSize = simulator.getPopulationSize();

        assertEquals(expectedPopulationSize, actualPopulationSize);
    }

    @Test
    public void testElapseEighteenDays() {
        var simulator = new EfficientLanternfishBreedingSimulator(initialPopulation);
        simulator.elapseTime(18);

        long expectedPopulationSize = 26;

        long actualPopulationSize = simulator.getPopulationSize();

        assertEquals(expectedPopulationSize, actualPopulationSize);
    }

    @Test
    public void testElapseEightyDays() {
        var simulator = new EfficientLanternfishBreedingSimulator(initialPopulation);
        simulator.elapseTime(80);

        long expectedPopulationSize = 5934;

        long actualPopulationSize = simulator.getPopulationSize();

        assertEquals(expectedPopulationSize, actualPopulationSize);
    }

    @Test
    public void testElapse256Days() {
        var simulator = new EfficientLanternfishBreedingSimulator(initialPopulation);
        simulator.elapseTime(256);

        long expectedPopulationSize = Long.parseLong("26984457539");

        long actualPopulationSize = simulator.getPopulationSize();

        assertEquals(expectedPopulationSize, actualPopulationSize);
    }
}
