import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepthsReader {
    public static List<Integer> readDepths() throws IOException {
        Scanner scanner = new Scanner(new File("src/depths.txt"));
        List<Integer> depths = new ArrayList<>();

        while (scanner.hasNextInt()) {
            depths.add(scanner.nextInt());
        }

        return depths;
    }
}
