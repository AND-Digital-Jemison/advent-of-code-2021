import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class VentDataReader {
    private List<String> rawVentData;

    public VentDataReader(String path) {
        readRawVentData(path);
    }

    public List<String> getRawVentData() {
        return rawVentData;
    }

    private void readRawVentData(String path) {
        try {
            this.rawVentData = Files.readAllLines(Paths.get(path));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
