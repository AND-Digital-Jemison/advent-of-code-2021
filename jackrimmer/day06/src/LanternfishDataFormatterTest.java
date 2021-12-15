import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternfishDataFormatterTest {
    String rawData = LanternfishDataReader.readRawLanternfishData("src/example-input.txt");

    @Test
    public void testDataFormatted() {
        List<Lanternfish> expectedResult = Arrays.asList(
                new Lanternfish(3, 1),
                new Lanternfish(4, 1),
                new Lanternfish(3, 1),
                new Lanternfish(1, 1),
                new Lanternfish(2, 1)
        );

        List<Lanternfish> actualResult = LanternfishDataFormatter.format(rawData);

        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i).getInternalTimer(), actualResult.get(i).getInternalTimer());
        }
    }
}
