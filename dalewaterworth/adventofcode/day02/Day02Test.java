package adventofcode.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Day02Test {
    Day02 day2;

    @BeforeEach()
    public void before(){
        day2 = new Day02();
    }

    @Test
    public void testGetData(){
        var list = day2.getData();
        Assertions.assertEquals(list.get(0), "forward 9");
    }

    @Test
    public void testGetDepth(){
        var list = Arrays.asList(new String[]{
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2",
        });
        var positions = day2.getDepth(list);
      // pt1  Assertions.assertEquals( 150, positions);
        Assertions.assertEquals( 900, positions);
    }

    @Test
    public void testGetResult(){
        var list = day2.getData();
        var positions = day2.getDepth(list);
     // pt 1   Assertions.assertEquals( 1499229, positions);
        Assertions.assertEquals( 1340836560, positions);
    }
}
