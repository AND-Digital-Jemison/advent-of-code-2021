import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestBingoSolver {
    private BingoSolver solver = new BingoSolver();
    private final BingoDataReader bingoData = new BingoDataReader("src/example-data.txt");

    @Test
    public void testGameSolvedForWinFirst() {
        List<Integer> numberDraw = BingoDataFormatter.formatNumberDraw(bingoData.getNumberDrawData());
        LinkedList<BingoSquare[][]> boards = BingoDataFormatter.formatBingoBoards(bingoData.getBingoBoardData());

        assertEquals(4512, solver.solveGame(numberDraw, boards, Outcome.WIN_FIRST));
    }

    @Test
    public void testGameSolvedForWinLast() {
        List<Integer> numberDraw = BingoDataFormatter.formatNumberDraw(bingoData.getNumberDrawData());
        LinkedList<BingoSquare[][]> boards = BingoDataFormatter.formatBingoBoards(bingoData.getBingoBoardData());

        assertEquals(1924, solver.solveGame(numberDraw, boards, Outcome.WIN_LAST));
    }
}
