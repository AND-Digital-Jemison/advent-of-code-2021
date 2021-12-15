package adventofcode.day05;

import adventofcode.BaseChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Code extends BaseChallenge {

    List<Coordinates> coordinates;
    Cell[][] grid;

    public Code() {
        super(new String[]{"adventofcode/day05/data.txt"});
    }

    public void setData(List<String> list) {
        coordinates = new ArrayList<>();

        for (String listItem : list) {
            var split = listItem.split(" -> ");
            var left = split[0].split(",");
            var right = split[1].split(",");
            coordinates.add(new Coordinates(
                    Integer.valueOf(left[0]),
                    Integer.valueOf(left[1]),
                    Integer.valueOf(right[0]),
                    Integer.valueOf(right[1])));
        }
        setGrid();
    }

    public void setGrid(){
        var max = coordinates.stream()
                .map(x -> Arrays.asList(x.x1, x.y1, x.x2, x.y2))
                .flatMapToInt(x -> x.stream().mapToInt(y -> y))
                .max().getAsInt();
        System.out.println("Grid size2:" + max);
        grid = new Cell[max + 1][max + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void printUtil() {
        for (int i = 0; i < grid.length; i++) {
            var str = "";
            for (int j = 0; j < grid[i].length; j++) {
                str += String.format("%3s", grid[j][i].value);
            }
            System.out.println(str);
        }
    }

    public void plotData() {
        for (Coordinates coordinates : coordinates) {
            for (int[] points : coordinates.points) {
                var x = points[0];
                var y = points[1];
               try {
                   grid[x][y].value++;
               } catch (Exception e){
                   System.out.println(e);
               }
            }
        }
        printUtil();
    }

    public int getOverlapCount(){
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[j][i].value >= 2){
                    count++;
                }
            }
        }
        return count;
    }
}

class Cell {
    public int value = 0;
}

class Coordinates {
    int x1;
    int y1;
    int x2;
    int y2;
    List<int[]> points = new ArrayList<>();

    public Coordinates(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        if (x1 == x2 || y1 == y2) {
            points.add(new int[]{x1, y1});
            points.addAll(getPointsBetween());
            points.add(new int[]{x2, y2});
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x1 == that.x1 && y1 == that.y1 && x2 == that.x2 && y2 == that.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }

    public List<int[]> getPointsBetween() {
        List<int[]> points = new ArrayList<>();
        if (y2 > y1) {
            var diff = y2 - y1;
            for (int i = 1; i < diff; i++) {
                points.add(new int[]{x2, y1 + i});
            }
        } else if (x1 > x2) {
            var diff = x1 - x2;
            for (int i = 1; i < diff; i++) {
                points.add(new int[]{x1 - i, y2,});
            }
        } else if (x1 < x2) {
            var diff = x2 - x1;
            for (int i = 1; i < diff; i++) {
                points.add(new int[]{x1 + i, y2,});
            }
        } else if(y1 > y2){
            var diff = y1 - y2;
            for (int i = 1; i < diff; i++) {
                points.add(new int[]{x2, y1 + i});
            }
        }
        else {
            throw new RuntimeException("no matches");
        }

        return points;
    }
};
