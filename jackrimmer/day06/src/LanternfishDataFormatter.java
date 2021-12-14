import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LanternfishDataFormatter {
    public static List<Lanternfish> format(String rawData) {
        return Arrays.asList(rawData.split(","))
                .stream()
                .map(data -> new Lanternfish(Integer.parseInt(data), 1))
                .collect(Collectors.toList());
    }
}
