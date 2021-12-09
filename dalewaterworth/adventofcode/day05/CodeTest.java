package adventofcode.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class CodeTest {

    Code code;

    List<String> list = Arrays.asList(
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

    @BeforeEach()
    public void before() {
        code = new Code();
    }

    @Test
    public void testConvertData() {
        code.setData(list);

        Assertions.assertEquals(code.coordinates.get(0), new Coordinates(0, 9, 5, 9));
        Assertions.assertEquals(code.coordinates.get(code.coordinates.size() - 1),
                new Coordinates(5, 5, 8, 2));
        Assertions.assertEquals(code.grid.length, 10);
        Assertions.assertEquals(code.grid[0].length, 10);
    }


    @Test
    public void testGetPointsBetweenY() {
        var points = new Coordinates(1, 1, 1, 3).points;
        var list = Arrays.asList(
                new int[]{1,1},
                new int[]{1,2},
                new int[]{1,3}
        );
        compareArrays2( points, list);
    }

    @Test
    public void testGetPointsBetweenX() {
        var points = new Coordinates(9, 7, 7, 7).points;
        var list = Arrays.asList(
                new int[]{9,7},
                new int[]{8,7},
                new int[]{7,7}
        );
        compareArrays2( points, list);
    }

    @Test
    public void bug1() {
        var points = new Coordinates(2,2,2,1).points;
        var list = Arrays.asList(
                new int[]{2,2},
                new int[]{2,1}
                );
        compareArrays2( points, list);
    }

    @Test
    public void bug2() {
        var c = new Coordinates(990,254, 990,368);
        Assertions.assertEquals(Arrays.toString(c.points.get(0)), Arrays.toString(new int[]{990,254}));
        Assertions.assertEquals(c.points.size(), c.y2 - c.y1 +1);

        code.coordinates = Arrays.asList(c);
        code.setGrid();
        code.plotData();
    }

    @Test
    public void testGetPointsWhereNotX1eqX2andY1eqY2() {
        var c = new Coordinates(1, 2, 3, 4);
        Assertions.assertEquals(c.points.size(), 0);
    }


    @Test
    public void plotCoordinates() {
        code.setData(list);
        var points = code.coordinates.get(0).points; // 0,9 -> 5,9
        var list = Arrays.asList(
                new int[]{0, 9},
                new int[]{1, 9},
                new int[]{2, 9},
                new int[]{3, 9},
                new int[]{4, 9},
                new int[]{5, 9}
        );
        compareArrays2( points, list);

        points = code.coordinates.get(1).points; // "8,0 -> 0,8"
        list = Arrays.asList();
        compareArrays2( points, list);

        points = code.coordinates.get(2).points; //  "9,4 -> 3,4",
        list = Arrays.asList(
                new int[]{9, 4},
                new int[]{8, 4},
                new int[]{7, 4},
                new int[]{6, 4},
                new int[]{5, 4},
                new int[]{4, 4},
                new int[]{3, 4}
        );
        compareArrays2( points, list);

        points = code.coordinates.get(3).points; //   "2,2 -> 2,1",
        list = Arrays.asList(
                new int[]{2, 2},
                new int[]{2, 1}

        );
        compareArrays2( points, list);

        points = code.coordinates.get(4).points; //  "7,0 -> 7,4",
        list = Arrays.asList(
                new int[]{7, 0},
                new int[]{7, 1},
                new int[]{7, 2},
                new int[]{7, 3},
                new int[]{7, 4}

        );
        compareArrays2( points, list);


        points = code.coordinates.get(5).points; //  "6,4 -> 2,0",
        list = Arrays.asList();
        compareArrays2( points, list);

        points = code.coordinates.get(6).points; //   "0,9 -> 2,9",
        list = Arrays.asList(
                new int[]{0, 9},
                new int[]{1, 9},
                new int[]{2, 9}
        );
        compareArrays2( points, list);


        points = code.coordinates.get(7).points; //   "3,4 -> 1,4",
        list = Arrays.asList(
                new int[]{3, 4},
                new int[]{2, 4},
                new int[]{1, 4}
        );
        compareArrays2( points, list);

        points = code.coordinates.get(8).points; //   "0,0 -> 8,8",
        list = Arrays.asList(

        );
        compareArrays2( points, list);

        points = code.coordinates.get(9).points; //    "5,5 -> 8,2"
        list = Arrays.asList(

        );
        compareArrays2( points, list);
        code.plotData();
    }

    @Test
    public void testGrid() {
        code.setData(list);
        code.plotData();

        Assertions.assertEquals(code.grid[0][9].value, 2);
        Assertions.assertEquals(code.getOverlapCount(), 5);

    }

    @Test
    public void testChallenge() {
        code.setData(code.rawData.get(0));
        code.plotData();

        // TODO fix
        Assertions.assertEquals(code.getOverlapCount(), 4698);
    }

    private void compareArrays2(List<int[]> points, List<int[]> list) {
        if (points.size() == 0 && list.size() == 0) {
            return;
        }

        var matched =  (points.size()==list.size() &&
                IntStream.range(0, points.size())
                        .allMatch(i -> Arrays.equals(points.get(i), list.get(i))));

            var str = "";
            for (int i = 0; i < points.size(); i++) {
                str += Arrays.toString(points.get(i)) + " - " + Arrays.toString(list.get(i)) + "\n";
            }
            System.out.println(str);
            System.out.println("-----");

        Assertions.assertTrue(matched);
    }

}
