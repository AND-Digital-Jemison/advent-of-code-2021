package adventofcode.day01;

import adventofcode.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class day01 {

    public static void main(String[] args) {
        List<Integer> numberList = FileReader.getFile("adventofcode/day01/day01.txt")
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int previous;
        int count = 0;
        for (int i = 0; i < numberList.size(); i++) {
            if(i != 0){
                previous = numberList.get(i-1);
                int current = numberList.get(i);
                if(current > previous){
                    count++;
                }
            }
        }
        System.out.println(count); // 1502

        // part 2
        count = 0;
        List<List<Integer>> threeMeasures = new ArrayList<List<Integer>>();
        for (int i = 0; i < numberList.size(); i++) {
            if(i +2 < numberList.size()){
                var arr = Arrays.asList(new Integer[]{numberList.get(i), numberList.get(i + 1), numberList.get(i + 2)});
                System.out.println(arr);
                threeMeasures.add(arr);
            }
        }
        for (int i = 0; i < threeMeasures.size(); i++) {
            if(i != 0){
                previous = threeMeasures.get(i-1).stream().reduce(0, Integer::sum);
                int current = threeMeasures.get(i).stream().reduce(0, Integer::sum);
                if(current > previous){
                    count++;
                }
            }
        }
        System.out.println(count); // 1538
    }
}
