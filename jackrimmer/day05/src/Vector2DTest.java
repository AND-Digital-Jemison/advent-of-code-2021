import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2DTest {
    @Test
    public void testGetAllHorizontalVectorsBetweenSelf() {
        Vector2D vector = new Vector2D(1, 1);

        List<Vector2D> expectedVectors = Arrays.asList(vector);
        List<Vector2D> actualVectors = vector.allHorizontalPointsBetweenSelfAnd(vector);

        assertEquals(1, actualVectors.size());
        assertEquals(expectedVectors.get(0).getX(), actualVectors.get(0).getX());
        assertEquals(expectedVectors.get(0).getY(), actualVectors.get(0).getY());
    }

    @Test
    public void testGetAllVectorsBetweenHorizontalVectors() {
        Vector2D vector = new Vector2D(1, 1);
        Vector2D comparisonVector = new Vector2D(5, 1);

        List<Vector2D> expectedVectors = Arrays.asList(
            new Vector2D(1, 1),
            new Vector2D(2, 1),
            new Vector2D(3, 1),
            new Vector2D(4, 1),
            new Vector2D(5, 1)
        );

        List<Vector2D> actualVectors = vector.allHorizontalPointsBetweenSelfAnd(comparisonVector);

        assertEquals(5, actualVectors.size());

        for (int i = 0; i < expectedVectors.size(); i++) {
            assertEquals(expectedVectors.get(i).getX(), actualVectors.get(i).getX());
            assertEquals(expectedVectors.get(i).getY(), actualVectors.get(i).getY());
        }
    }

    @Test
    public void testHorizontalCurrentLargerThanComparisonVector() {
        Vector2D vector = new Vector2D(5, 1);
        Vector2D comparisonVector = new Vector2D(1, 1);

        List<Vector2D> expectedVectors = Arrays.asList(
                new Vector2D(1, 1),
                new Vector2D(2, 1),
                new Vector2D(3, 1),
                new Vector2D(4, 1),
                new Vector2D(5, 1)
        );

        List<Vector2D> actualVectors = vector.allHorizontalPointsBetweenSelfAnd(comparisonVector);

        assertEquals(5, actualVectors.size());

        for (int i = 0; i < expectedVectors.size(); i++) {
            assertEquals(expectedVectors.get(i).getX(), actualVectors.get(i).getX());
            assertEquals(expectedVectors.get(i).getY(), actualVectors.get(i).getY());
        }
    }

    @Test
    public void testGetAllVerticalVectorsBetweenSelf() {
        Vector2D vector = new Vector2D(1, 1);

        List<Vector2D> expectedVectors = Arrays.asList(
                new Vector2D(1, 1)
        );

        List<Vector2D> actualVectors = vector.allVerticalPointsBetweenSelfAnd(vector);

        assertEquals(1, actualVectors.size());
        assertEquals(expectedVectors.get(0).getX(), actualVectors.get(0).getX());
        assertEquals(expectedVectors.get(0).getY(), actualVectors.get(0).getY());
    }

    @Test
    public void testGetAllVectorsBetweenVerticalVectors() {
        Vector2D vector = new Vector2D(1, 1);
        Vector2D comparisonVector = new Vector2D(1, 5);

        List<Vector2D> expectedVectors = Arrays.asList(
                new Vector2D(1, 1),
                new Vector2D(1, 2),
                new Vector2D(1, 3),
                new Vector2D(1, 4),
                new Vector2D(1, 5)
        );

        List<Vector2D> actualVectors = vector.allVerticalPointsBetweenSelfAnd(comparisonVector);

        assertEquals(5, actualVectors.size());

        for (int i = 0; i < expectedVectors.size(); i++) {
            assertEquals(expectedVectors.get(i).getX(), actualVectors.get(i).getX());
            assertEquals(expectedVectors.get(i).getY(), actualVectors.get(i).getY());
        }
    }

    @Test
    public void testVerticalCurrentLargerThanComparisonVectors() {
        Vector2D vector = new Vector2D(1, 5);
        Vector2D comparisonVector = new Vector2D(1, 1);

        List<Vector2D> expectedVectors = Arrays.asList(
                new Vector2D(1, 1),
                new Vector2D(1, 2),
                new Vector2D(1, 3),
                new Vector2D(1, 4),
                new Vector2D(1, 5)
        );

        List<Vector2D> actualVectors = vector.allVerticalPointsBetweenSelfAnd(comparisonVector);

        assertEquals(5, actualVectors.size());

        for (int i = 0; i < expectedVectors.size(); i++) {
            assertEquals(expectedVectors.get(i).getX(), actualVectors.get(i).getX());
            assertEquals(expectedVectors.get(i).getY(), actualVectors.get(i).getY());
        }
    }

    @Test
    public void testGetAllDiagonalVectorsBetweenSelf() {
        Vector2D vector = new Vector2D(1, 1);

        List<Vector2D> expectedVectors = Arrays.asList(
                new Vector2D(1, 1)
        );

        List<Vector2D> actualVectors = vector.allDiagonalPointsBetweenSelfAnd(vector);

        assertEquals(1, actualVectors.size());
        assertEquals(expectedVectors.get(0).getX(), actualVectors.get(0).getX());
        assertEquals(expectedVectors.get(0).getY(), actualVectors.get(0).getY());
    }

    @Test
    public void testGetAllPointsBetweenDiagonalVectorsBottomLeftToTopRight() {
        Vector2D vector = new Vector2D(1, 1);
        Vector2D comparisonVector = new Vector2D(5, 5);

        List<Vector2D> expectedVectors = Arrays.asList(
                new Vector2D(1, 1),
                new Vector2D(2, 2),
                new Vector2D(3, 3),
                new Vector2D(4, 4),
                new Vector2D(5, 5)
        );

        List<Vector2D> actualVectors = vector.allDiagonalPointsBetweenSelfAnd(comparisonVector);

        assertEquals(5, actualVectors.size());

        for (int i = 0; i < expectedVectors.size(); i++) {
            assertEquals(expectedVectors.get(i).getX(), actualVectors.get(i).getX());
            assertEquals(expectedVectors.get(i).getY(), actualVectors.get(i).getY());
        }
    }

//    @Test
//    public void testVerticalCurrentLargerThanComparison() {
//        Vector2D vector = new Vector2D(1, 5);
//        Vector2D comparisonVector = new Vector2D(1, 1);
//
//        List<Vector2D> expectedVectors = Arrays.asList(
//                new Vector2D(1, 1),
//                new Vector2D(1, 2),
//                new Vector2D(1, 3),
//                new Vector2D(1, 4),
//                new Vector2D(1, 5)
//        );
//
//        List<Vector2D> actualVectors = vector.allVerticalPointsBetweenSelfAnd(comparisonVector);
//
//        assertEquals(5, actualVectors.size());
//
//        for (int i = 0; i < expectedVectors.size(); i++) {
//            assertEquals(expectedVectors.get(i).getX(), actualVectors.get(i).getX());
//            assertEquals(expectedVectors.get(i).getY(), actualVectors.get(i).getY());
//        }
//    }
}
