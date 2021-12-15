import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LanternfishDataReader {
    public static String readRawLanternfishData(String path) {
        try {
            return Files.readString(Paths.get(path));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("Path must be valid");
    }
}
