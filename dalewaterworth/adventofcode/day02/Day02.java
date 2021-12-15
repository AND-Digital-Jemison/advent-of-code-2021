package adventofcode.day02;

import adventofcode.FileReader;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day02 {

    public List<String> getData(){
        return FileReader.getFile("adventofcode/day02/data.txt").collect(Collectors.toList());
    }

    public int getDepth(List<String> positions){
        var horizontalPosition = 0;
        var depth = 0;
        var aim = 0;
        for (String position : positions){
            var data = position.split(" ");
            var direction = data[0].trim();
            var value = Integer.valueOf(data[1].trim());
            if(direction.equals("forward")){
                horizontalPosition += value;
                depth += (aim * value);
            } else if(direction.equals("down")){
                aim += value;
            } else if(direction.equals("up")){
                aim -= value;
            } else {
                throw new RuntimeException("not matched");
            }
        }
        System.out.println("horizontalPosition: " + horizontalPosition);
        System.out.println("depth: " + depth);
        System.out.println("aim: " + aim);
        return horizontalPosition * depth;
    }
}
