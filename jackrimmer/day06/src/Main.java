import java.util.List;

public class Main {

    public static void main(String[] args) {
        String rawData = LanternfishDataReader.readRawLanternfishData("src/lanternfish-input.txt");
        List<Lanternfish> initialPopulation = LanternfishDataFormatter.format(rawData);

//        var simulator = new LanternfishBreedingSimulator(initialPopulation);
//
//        simulator.elapseTime(80);
//
//        System.out.println("Part 1: " + simulator.getLanternfishSchool().size());

        var efficientSimulator = new EfficientLanternfishBreedingSimulator(initialPopulation);

        efficientSimulator.elapseTime(256);

        System.out.println("Part 2: " + efficientSimulator.getPopulationSize());
    }
}
