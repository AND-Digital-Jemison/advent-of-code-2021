package adventofcode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    public static java.util.stream.Stream<String> getFile(String file){
        Path path = null;
        try {
            path = Paths.get(FileReader.class.getClassLoader().getResource(file).toURI());
            return Files.lines(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Could not load file");
    }
}
