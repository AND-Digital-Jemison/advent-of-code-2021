import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EfficientLanternfishBreedingSimulator {
    List<Lanternfish> groupedLanternfish = new ArrayList<>();

    public EfficientLanternfishBreedingSimulator(List<Lanternfish> initialPopulation) {
        groupPopulation(initialPopulation);
    }

    public long getPopulationSize() {
        long populationSize = 0;
        for (Lanternfish fish: groupedLanternfish) {
            populationSize += fish.getMagnitude();
        }

        return populationSize;
    }

    public void elapseTime(int days) {
        for (int i = 1; i <= days; i++) {
            ageFish();
            Lanternfish breeder = getFishWithTimer(-1);

            if (breeder != null) {
                Lanternfish babyFish = breeder.breed();
                regroup(breeder);
                addToGroup(babyFish);
            }
        }
    }

    private void groupPopulation(List<Lanternfish> initialPopulation) {
        for (int i = 0; i < initialPopulation.size(); i++) {
            addToGroup(initialPopulation.get(i));
        }
    }

    private void ageFish() {
        for (Lanternfish fish: groupedLanternfish) {
            fish.ageOneDay();
        }
    }

    private void regroup(Lanternfish fish) {
        List<Lanternfish> allCorrespondingFish = getAllFishWithTimer(fish.getInternalTimer());

        if (allCorrespondingFish.size() > 1) {
            Lanternfish mainGroup = allCorrespondingFish.get(0);
            for (int i = 1; i < allCorrespondingFish.size(); i++) {
                Lanternfish currentFish = allCorrespondingFish.get(i);

                mainGroup.incrementMagnitude(currentFish.getMagnitude());
                groupedLanternfish.remove(currentFish);
            }
        }
    }

    private void addToGroup(Lanternfish fish) {
        int timer = fish.getInternalTimer();
        long magnitude = fish.getMagnitude();

        Lanternfish correspondingFish = getFishWithTimer(timer);

        if (correspondingFish != null) {
            correspondingFish.incrementMagnitude(magnitude);
        }
        else {
            groupedLanternfish.add(new Lanternfish(timer, magnitude));
        }
    }

    private Lanternfish getFishWithTimer(int timer) {
        return groupedLanternfish
                .stream()
                .filter(fish -> fish.getInternalTimer() == timer)
                .findFirst()
                .orElse(null);
    }

    private List<Lanternfish> getAllFishWithTimer(int timer) {
        return groupedLanternfish
                .stream()
                .filter(fish -> fish.getInternalTimer() == timer)
                .collect(Collectors.toList());
    }
}
