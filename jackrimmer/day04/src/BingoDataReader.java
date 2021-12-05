import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BingoDataReader {
    private List<String> bingoData;

    public BingoDataReader(String path) {
        readBingoData(path);
    }

    public List<String> getBingoData() {
        return bingoData;
    }

    public String getNumberDrawData() {
     return bingoData.get(0);
    }

    public List<String> getBingoBoardData() {
        return bingoData.subList(1, bingoData.size());
    }

    private void readBingoData(String path) {
        try {
            this.bingoData = Files.readAllLines(Paths.get(path));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
