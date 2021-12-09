import java.util.List;

public class Main {

    public static void main(String[] args) {
        VentDataReader reader = new VentDataReader("src/vent-data.txt");
        List<String> rawData = reader.getRawVentData();
        List<Vector2D[]> ventData = VentDataFormatter.formatAll(rawData);

        var ventScanner = new OceanVentScanner(ventData);

        System.out.println("GRID:");
        ventScanner.displayToConsole();
        System.out.println();
        System.out.println();

        System.out.println("Part 2 solution: " + ventScanner.countMultipleOverlaps());
    }
}
