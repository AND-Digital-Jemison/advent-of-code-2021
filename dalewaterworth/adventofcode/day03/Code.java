package adventofcode.day03;

import adventofcode.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class Code {
    private List<String> dataList;

    public Stream<String> getData() {
        return FileReader.getFile("adventofcode/day03/data.txt");
    }

    public String[][] convertData(Stream<String> data) {
        // messy
        if(dataList == null){
            dataList = data.collect(Collectors.toList());
        }
        return convertTo2dArray(dataList);
    }

    private String[][] convertTo2dArray(List<String> dataList){
        return dataList.stream()
                .map(line -> Arrays.stream(line.split(""))
                        .map(String::new).toArray(String[]::new))
                .toArray(String[][]::new);
    }


    public PowerConsumption getPowerConsumption(String[][] array2D) {
        var gammaRate = "";
        var epsilonRate = "";
        for (int i = 0; i < array2D[0].length; i++) {
            var tmp = "";
            for (int j = 0; j < array2D.length; j++) {
                tmp += array2D[j][i];
            }

            var grouped = Arrays.stream(tmp.split(""))
                    .collect(Collectors.groupingBy(Function.identity(), counting()));

            gammaRate += grouped.entrySet().stream()
                    .max((first, second) -> (int) (first.getValue() - second.getValue()))
                    .get().getKey();
            // could this just be the reverse of above?
            epsilonRate += grouped.entrySet().stream()
                    .min((first, second) -> (int) (first.getValue() - second.getValue()))
                    .get().getKey();
        }

        return new PowerConsumption(gammaRate,
                Integer.parseInt(gammaRate, 2),
                epsilonRate,
                Integer.parseInt(epsilonRate, 2));
    }

    public LifeSupport getLifeSupport(String[][] array2D) {
        var oxygenDecimal = 0;
        var co2Decimal = 0;

        var index = 0;
        var columnSum = getSumOfRows(array2D, index);
        List<String> filtered = filterData(dataList, columnSum, index);

        while(filtered.size() > 1){
            index++;
            columnSum = getSumOfRows(convertTo2dArray(filtered), index);
            filtered = filterData(filtered, columnSum, index);
        }

        oxygenDecimal =  Integer.parseInt(filtered.get(0), 2);
        // this could be combined and made more elegant with more time and energy
         index = 0;
         columnSum = getSumOfRows(array2D, index);
         filtered = filterDataCo2(dataList, columnSum, index);

        while(filtered.size() > 1){
            index++;
            columnSum = getSumOfRows(convertTo2dArray(filtered), index);
            filtered = filterDataCo2(filtered, columnSum, index);
        }

        co2Decimal = Integer.parseInt(filtered.get(0), 2);

        return new LifeSupport(oxygenDecimal, co2Decimal);
    }

    public List<String> filterData(List<String> data, Map<String, Long> columnSum, int index) {
        if (columnSum.get("1") >= columnSum.get("0")) {
            return data.stream().filter(x -> x.charAt(index) == "1".charAt(0))
                    .collect(Collectors.toList());
        } else {
            return data.stream().filter(x -> x.charAt(index) == "0".charAt(0))
                    .collect(Collectors.toList());
        }
    }

    public List<String> filterDataCo2(List<String> data, Map<String, Long> columnSum, int index) {
        if (columnSum.get("0") <= columnSum.get("1")) {
            return data.stream().filter(x -> x.charAt(index) == "0".charAt(0))
                    .collect(Collectors.toList());
        } else {
            return data.stream().filter(x -> x.charAt(index) == "1".charAt(0))
                    .collect(Collectors.toList());
        }
    }

    public Map<String, Long> getSumOfRows(String[][] array2D, int colIndex) {
        var tmp = "";
        for (int i = 0; i < array2D.length; i++) {
            tmp += array2D[i][colIndex];
        }
        return Arrays.stream(tmp.split(""))
                .collect(Collectors.groupingBy(Function.identity(), counting()));

    }


}

record LifeSupport(int oxygenDecimal, int co2Decimal) {
}

record PowerConsumption(String gammaRate,
                        int gammaDeciaml,
                        String epsilonRate,
                        int epsilonDecimal) {
}
