import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBingoDataReader {
    private final BingoDataReader reader = new BingoDataReader("src/example-data.txt");

    @Test
    public void testDataRead() {
        assertTrue(reader.getBingoData().size() > 0);
    }

    @Test
    public void testDataCorrect() {
        List<String> expectedData = new ArrayList<>() {{
            add("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1");
            add("");
            add("22 13 17 11  0");
            add(" 8  2 23  4 24");
            add("21  9 14 16  7");
            add(" 6 10  3 18  5");
            add(" 1 12 20 15 19");
            add("");
            add(" 3 15  0  2 22");
            add(" 9 18 13 17  5");
            add("19  8  7 25 23");
            add("20 11 10 24  4");
            add("14 21 16 12  6");
            add("");
            add("14 21 17 24  4");
            add("10 16 15  9 19");
            add("18  8 23 26 20");
            add("22 11 13  6  5");
            add(" 2  0 12  3  7");
        }};

        assertEquals(expectedData, reader.getBingoData());
    }

    @Test
    public void testReadNumberDrawData() {
        String expectedData = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";

        assertEquals(expectedData, reader.getNumberDrawData());
    }

    @Test
    public void testReadBingoBoardData() {
        List<String> expectedData = new ArrayList<>() {{
            add("");
            add("22 13 17 11  0");
            add(" 8  2 23  4 24");
            add("21  9 14 16  7");
            add(" 6 10  3 18  5");
            add(" 1 12 20 15 19");
            add("");
            add(" 3 15  0  2 22");
            add(" 9 18 13 17  5");
            add("19  8  7 25 23");
            add("20 11 10 24  4");
            add("14 21 16 12  6");
            add("");
            add("14 21 17 24  4");
            add("10 16 15  9 19");
            add("18  8 23 26 20");
            add("22 11 13  6  5");
            add(" 2  0 12  3  7");
        }};

        assertEquals(expectedData, reader.getBingoBoardData());
    }
}

