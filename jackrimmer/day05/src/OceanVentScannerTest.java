import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OceanVentScannerTest {
    private VentDataReader reader = new VentDataReader("src/example-data.txt");

    @Test
    public void testOneSquareOverlap() {
        OceanTile[][] oceanFloor = new OceanTile[][] {
                { new OceanTile(0, 0) }
        };

        oceanFloor[0][0].addOverlap();

        assertEquals(1, oceanFloor[0][0].getOverlap());
    }

    @Test
    public void testOceanFloorTileRange() {
        List<String> rawData = reader.getRawVentData();
        List<Vector2D[]> ventData = VentDataFormatter.formatAll(rawData);
        var oceanVentScanner = new OceanVentScanner(ventData);

        OceanTile[][] oceanFloor = oceanVentScanner.getOceanFloor();

        assertEquals(10, oceanFloor.length);
        assertEquals(10, oceanFloor[0].length);
    }

    @Test
    public void testOneSquareMultipleOverlaps() {
        OceanTile[][] oceanFloor = new OceanTile[][] {
                { new OceanTile(0, 0) }
        };

        oceanFloor[0][0].addOverlap();
        oceanFloor[0][0].addOverlap();
        oceanFloor[0][0].addOverlap();

        assertEquals(3, oceanFloor[0][0].getOverlap());
    }

    @Test
    public void testSetVentData() {
        List<String> rawData = reader.getRawVentData();
        List<Vector2D[]> ventData = VentDataFormatter.formatAll(rawData);

        var ventScanner = new OceanVentScanner(ventData);

        OceanTile[][] expectedOceanFloor = new OceanTile[10][10];
        for (int y = 0; y < expectedOceanFloor.length; y++) {
            for (int x = 0; x < expectedOceanFloor[0].length; x++) {
                expectedOceanFloor[y][x] = new OceanTile(x, y);
            }
        }

        expectedOceanFloor[9][0].addOverlap();
        expectedOceanFloor[9][1].addOverlap();
        expectedOceanFloor[9][2].addOverlap();
        expectedOceanFloor[9][3].addOverlap();
        expectedOceanFloor[9][4].addOverlap();
        expectedOceanFloor[9][5].addOverlap();
        expectedOceanFloor[4][9].addOverlap();
        expectedOceanFloor[4][8].addOverlap();
        expectedOceanFloor[4][7].addOverlap();
        expectedOceanFloor[4][6].addOverlap();
        expectedOceanFloor[4][5].addOverlap();
        expectedOceanFloor[4][4].addOverlap();
        expectedOceanFloor[4][3].addOverlap();
        expectedOceanFloor[2][2].addOverlap();
        expectedOceanFloor[1][2].addOverlap();
        expectedOceanFloor[0][7].addOverlap();
        expectedOceanFloor[1][7].addOverlap();
        expectedOceanFloor[2][7].addOverlap();
        expectedOceanFloor[3][7].addOverlap();
        expectedOceanFloor[4][7].addOverlap();
        expectedOceanFloor[9][0].addOverlap();
        expectedOceanFloor[9][1].addOverlap();
        expectedOceanFloor[9][2].addOverlap();
        expectedOceanFloor[4][3].addOverlap();
        expectedOceanFloor[4][2].addOverlap();
        expectedOceanFloor[4][1].addOverlap();

        expectedOceanFloor[0][8].addOverlap();
        expectedOceanFloor[1][7].addOverlap();
        expectedOceanFloor[2][6].addOverlap();
        expectedOceanFloor[3][5].addOverlap();
        expectedOceanFloor[4][4].addOverlap();
        expectedOceanFloor[5][3].addOverlap();
        expectedOceanFloor[6][2].addOverlap();
        expectedOceanFloor[7][1].addOverlap();
        expectedOceanFloor[8][0].addOverlap();

        expectedOceanFloor[4][6].addOverlap();
        expectedOceanFloor[3][5].addOverlap();
        expectedOceanFloor[2][4].addOverlap();
        expectedOceanFloor[1][3].addOverlap();
        expectedOceanFloor[0][2].addOverlap();

        expectedOceanFloor[0][0].addOverlap();
        expectedOceanFloor[1][1].addOverlap();
        expectedOceanFloor[2][2].addOverlap();
        expectedOceanFloor[3][3].addOverlap();
        expectedOceanFloor[4][4].addOverlap();
        expectedOceanFloor[5][5].addOverlap();
        expectedOceanFloor[6][6].addOverlap();
        expectedOceanFloor[7][7].addOverlap();
        expectedOceanFloor[8][8].addOverlap();

        expectedOceanFloor[5][5].addOverlap();
        expectedOceanFloor[4][6].addOverlap();
        expectedOceanFloor[3][7].addOverlap();
        expectedOceanFloor[2][8].addOverlap();

        OceanTile[][] actualOceanFloor = ventScanner.getOceanFloor();

        for (int y = 0; y < expectedOceanFloor.length; y++) {
            for (int x = 0; x < expectedOceanFloor[0].length; x++) {
                assertEquals(expectedOceanFloor[y][x].getOverlap(), actualOceanFloor[y][x].getOverlap());
            }
        }
    }

    @Test
    public void testIsDisplayedToConsole() {
        List<String> rawData = reader.getRawVentData();
        List<Vector2D[]> ventData = VentDataFormatter.formatAll(rawData);

        var ventScanner = new OceanVentScanner(ventData);

        ventScanner.displayToConsole();
    }

    @Test
    public void testMultipleOverlapCount() {
        List<String> rawData = reader.getRawVentData();
        List<Vector2D[]> ventData = VentDataFormatter.formatAll(rawData);

        var ventScanner = new OceanVentScanner(ventData);

        int overlaps = ventScanner.countMultipleOverlaps();

        assertEquals(12, overlaps);
    }
}
