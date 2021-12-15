import java.util.ArrayList;
import java.util.List;

public class LanternfishBreedingSimulator {
    List<Lanternfish> lanternfishSchool;

    public LanternfishBreedingSimulator(List<Lanternfish> initialPopulation) {
        this.lanternfishSchool = initialPopulation;
    }

    public List<Lanternfish> getLanternfishSchool() {
        return lanternfishSchool;
    }

    public void elapseTime(int days) {
        for (int i = 1; i <= days; i++) {
        List<Lanternfish> tempFish = new ArrayList<>(lanternfishSchool);
            for (Lanternfish fish: tempFish) {
                fish.ageOneDay();

                if (fish.getInternalTimer() == -1) {
                    lanternfishSchool.add(fish.breed());
                }
            }
        }
    }

}
