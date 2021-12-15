package adventofcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseChallenge {
    public Map<Integer, List<String>> rawData = new HashMap<>();

    public BaseChallenge(String[] filePaths){
        for (int i = 0; i < filePaths.length; i++) {
            rawData.put(i, FileReader.getFile(filePaths[i]).collect(Collectors.toList()));
        }
        System.out.println(rawData);
    }
}
