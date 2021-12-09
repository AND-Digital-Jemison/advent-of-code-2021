import java.util.ArrayList;
import java.util.List;

public class Vector2D {
    private final int x;
    private final int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Vector2D> allHorizontalPointsBetweenSelfAnd(Vector2D comparisonVector) {
        List<Vector2D> points = new ArrayList<>();
        int[] endpoints = getEndpoints(this.x, comparisonVector.getX());

        for (int i = endpoints[0]; i <= endpoints[1]; i++) {
            points.add(new Vector2D(i, getY()));
        };

        return points;
    }

    public List<Vector2D> allVerticalPointsBetweenSelfAnd(Vector2D comparisonVector) {
        List<Vector2D> points = new ArrayList<>();
        int[] endpoints = getEndpoints(this.y, comparisonVector.getY());

        for (int i = endpoints[0]; i <= endpoints[1]; i++) {
            points.add(new Vector2D(getX(), i));
        };

        return points;
    }

    public List<Vector2D> allDiagonalPointsBetweenSelfAnd(Vector2D comparisonVector) {
        List<Vector2D> points = new ArrayList<>();
        int[] endpoints = getEndpoints(this.y, comparisonVector.getY());

        for (int i = endpoints[0]; i <= endpoints[1]; i++) {
            points.add(new Vector2D(getX(), getY()));
        };

        return points;
    }

    private int[] getEndpoints(int currentCoordinate, int comparisonCoordinate) {
        int max = currentCoordinate - comparisonCoordinate > 0 ? currentCoordinate : comparisonCoordinate;
        int min = currentCoordinate - comparisonCoordinate > 0 ? comparisonCoordinate : currentCoordinate;

        return new int[] {min, max};
    }

}
