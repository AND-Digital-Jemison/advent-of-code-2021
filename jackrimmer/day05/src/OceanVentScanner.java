import java.util.ArrayList;
import java.util.List;

public class OceanVentScanner {
    private OceanTile[][] oceanFloor;

    public OceanVentScanner(List<Vector2D[]> ventData) {
        setOceanFloor(ventData);
        setVentData(ventData);
    }

    public void displayToConsole() {
        for (int y = 0; y < oceanFloor.length; y++) {
            for (int x = 0; x < oceanFloor[0].length; x++) {
                System.out.print(oceanFloor[y][x].getOverlap() + " ");
            }
            System.out.println();
        }
    }

    public OceanTile[][] getOceanFloor() {
        return oceanFloor;
    }

    public int countMultipleOverlaps() {
        int count = 0;
        for (int y = 0; y < oceanFloor.length; y++) {
            for (int x = 0; x < oceanFloor[0].length; x++) {
                if (oceanFloor[y][x].getOverlap() >= 2) {
                    count++;
                }
            }
        }

        return count;
    }

    private void setGridRange(List<Vector2D[]> ventData) {
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < ventData.size(); i++) {
            int firstVectorX = ventData.get(i)[0].getX();
            int secondVectorX = ventData.get(i)[1].getX();
            int firstVectorY = ventData.get(i)[0].getY();
            int secondVectorY = ventData.get(i)[1].getY();

            maxX = firstVectorX > maxX ? firstVectorX : maxX;
            maxX = secondVectorX > maxX ? secondVectorX : maxX;
            maxY = firstVectorY > maxY ? firstVectorY : maxY;
            maxY = secondVectorY > maxY ? secondVectorY : maxY;
        }

        oceanFloor = new OceanTile[maxX + 1][maxY + 1];
    }

    private void setOceanFloor(List<Vector2D[]> ventData) {
        setGridRange(ventData);

        for (int y = 0; y < oceanFloor.length; y++) {
            for (int x = 0; x < oceanFloor[0].length; x++) {
                oceanFloor[y][x] = new OceanTile(x, y);
            }
        }
    }

    private void setVentData(List<Vector2D[]> ventData) {
        for (Vector2D[] ventVector: ventData) {
            List<Vector2D> interimVectors;
            Vector2D startVector = ventVector[0];
            Vector2D endVector = ventVector[1];

            if (startVector.getX() == endVector.getX()) {
                interimVectors = startVector.allVerticalPointsBetweenSelfAnd(endVector);
            }
            else if (startVector.getY() == endVector.getY()) {
                interimVectors = startVector.allHorizontalPointsBetweenSelfAnd(endVector);
            }
            else {
                interimVectors = new ArrayList<>();
            }

            for (Vector2D vector: interimVectors) {
                oceanFloor[vector.getY()][vector.getX()].addOverlap();
            }
        }
    }
}
