import java.util.ArrayList;
import java.util.List;

public class VentDataFormatter {
    public static List<Vector2D[]> formatAll(List<String> unformattedLines) {
        List<Vector2D[]> formattedData = new ArrayList<>();
        for (String line: unformattedLines) {
            formattedData.add(format(line));
        }

        return formattedData;
    }

    private static Vector2D[] format(String unformattedLine) {
        String[] unformattedArray = unformattedLine.split(" -> ");
        String[] unformattedStartPosition = unformattedArray[0].split(",");
        String[] unformattedEndPosition = unformattedArray[1].split(",");

        return new Vector2D[] {
                new Vector2D(Integer.parseInt(unformattedStartPosition[0]), Integer.parseInt(unformattedStartPosition[1])),
                new Vector2D(Integer.parseInt(unformattedEndPosition[0]), Integer.parseInt(unformattedEndPosition[1]))
        };
    }
}
