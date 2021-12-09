import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VentDataReaderTest {
    VentDataReader reader = new VentDataReader("src/example-data.txt");

    @Test
    public void testDataRead() {
        List<String> rawData = reader.getRawVentData();
        List<String> expectedData = Arrays.asList(
                "0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2"
        );

        assertEquals(expectedData, rawData);
    }

    @Test
    public void testAllLinesFormatted() {
        List<String> unformattedLines = reader.getRawVentData();

        List<Vector2D[]> expectedFormatted = new ArrayList<>() {{
            add(new Vector2D[]{ new Vector2D(0, 9),  new Vector2D(5, 9) });
            add(new Vector2D[]{ new Vector2D(8, 0),  new Vector2D(0, 8) });
            add(new Vector2D[]{ new Vector2D(9, 4),  new Vector2D(3, 4) });
            add(new Vector2D[]{ new Vector2D(2, 2),  new Vector2D(2, 1) });
            add(new Vector2D[]{ new Vector2D(7, 0),  new Vector2D(7, 4) });
            add(new Vector2D[]{ new Vector2D(6, 4),  new Vector2D(2, 0) });
            add(new Vector2D[]{ new Vector2D(0, 9),  new Vector2D(2, 9) });
            add(new Vector2D[]{ new Vector2D(3, 4),  new Vector2D(1, 4) });
            add(new Vector2D[]{ new Vector2D(0, 0),  new Vector2D(8, 8) });
            add(new Vector2D[]{ new Vector2D(5, 5),  new Vector2D(8, 2) });
        }};

        List<Vector2D[]> actualFormatted = VentDataFormatter.formatAll(unformattedLines);

        for (int i = 0; i < expectedFormatted.size(); i++) {
            for (int j = 0; j <= 1; j++) {
                assertEquals(expectedFormatted.get(i)[j].getX(), actualFormatted.get(i)[j].getX());
                assertEquals(expectedFormatted.get(i)[j].getY(), actualFormatted.get(i)[j].getY());
            }
        }
    }
}
