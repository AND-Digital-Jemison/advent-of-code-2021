import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestBingoDataFormatter {
    private final List<String> bingoData = new BingoDataReader("src/example-data.txt").getBingoData();

    @Test
    public void testFormatNumberDraw() {
        String unformattedDraw = bingoData.get(0);
        List<Integer> expectedFormattedDraw = new ArrayList<>() {{
                add(7);  add(4);  add(9);  add(5);  add(11);
                add(17); add(23); add(2);  add(0);  add(14);
                add(21); add(24); add(10); add(16); add(13);
                add(6);  add(15); add(25); add(12); add(22);
                add(18); add(20); add(8);  add(19); add(3);
                add(26); add(1);
        }};

        assertTrue(
                BingoDataFormatter.formatNumberDraw(unformattedDraw)
                .equals(expectedFormattedDraw)
        );
    }

    @Test
    public void testFormatBingoCards() {
        List<String> unformattedData = bingoData.subList(1, bingoData.size());

        List<BingoSquare[][]> expectedFormattedCards = new ArrayList<>() {{
            add(new BingoSquare[][] {
                    {new BingoSquare(22), new BingoSquare(13), new BingoSquare(17), new BingoSquare(11), new BingoSquare(0)},
                    {new BingoSquare(8), new BingoSquare(2), new BingoSquare(23), new BingoSquare(4), new BingoSquare(24)},
                    {new BingoSquare(21), new BingoSquare(9), new BingoSquare(14), new BingoSquare(16), new BingoSquare(7)},
                    {new BingoSquare(6), new BingoSquare(10), new BingoSquare(3), new BingoSquare(18), new BingoSquare(5)},
                    {new BingoSquare(1), new BingoSquare(12), new BingoSquare(20), new BingoSquare(15), new BingoSquare(19)},
            });
            add(new BingoSquare[][] {
                    {new BingoSquare(3), new BingoSquare(15), new BingoSquare(0), new BingoSquare(2), new BingoSquare(22)},
                    {new BingoSquare(9), new BingoSquare(18), new BingoSquare(13), new BingoSquare(17), new BingoSquare(5)},
                    {new BingoSquare(19), new BingoSquare(8), new BingoSquare(7), new BingoSquare(25), new BingoSquare(23)},
                    {new BingoSquare(20), new BingoSquare(11), new BingoSquare(10), new BingoSquare(24), new BingoSquare(4)},
                    {new BingoSquare(14), new BingoSquare(21), new BingoSquare(16), new BingoSquare(12), new BingoSquare(6)},
            });
            add(new BingoSquare[][] {
                    {new BingoSquare(14), new BingoSquare(21), new BingoSquare(17), new BingoSquare(24), new BingoSquare(4)},
                    {new BingoSquare(10), new BingoSquare(16), new BingoSquare(15), new BingoSquare(9), new BingoSquare(19)},
                    {new BingoSquare(18), new BingoSquare(8), new BingoSquare(23), new BingoSquare(26), new BingoSquare(20)},
                    {new BingoSquare(22), new BingoSquare(11), new BingoSquare(13), new BingoSquare(6), new BingoSquare(5)},
                    {new BingoSquare(2), new BingoSquare(0), new BingoSquare(12), new BingoSquare(3), new BingoSquare(7)},
            });
        }};

        List<BingoSquare[][]> actualFormattedCards = BingoDataFormatter.formatBingoBoards(unformattedData);

        for (int i = 0; i < expectedFormattedCards.size(); i++) {
            for (int row = 0; row < expectedFormattedCards.get(i).length; row++) {
                for (int column = 0; column < expectedFormattedCards.get(i).length; column++) {
                    assertEquals(actualFormattedCards.get(i)[row][column].getValue(), expectedFormattedCards.get(i)[row][column].getValue());
                }
            }
        }
    }
}
