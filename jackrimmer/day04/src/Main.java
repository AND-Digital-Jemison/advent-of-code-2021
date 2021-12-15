import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var reader = new BingoDataReader("src/bingo-data.txt");
        String rawNumberDrawData = reader.getNumberDrawData();
        List<String> rawBingoBoardData = reader.getBingoBoardData();

        var solver = new BingoSolver();

        List<Integer> numberDrawPartOne = BingoDataFormatter.formatNumberDraw(rawNumberDrawData);
        LinkedList<BingoSquare[][]> bingoBoardsPartOne = BingoDataFormatter.formatBingoBoards(rawBingoBoardData);

        int partOneSolution = solver.solveGame(numberDrawPartOne, bingoBoardsPartOne, Outcome.WIN_FIRST);

        List<Integer> numberDrawPartTwo = BingoDataFormatter.formatNumberDraw(rawNumberDrawData);
        LinkedList<BingoSquare[][]> bingoBoardsPartTwo = BingoDataFormatter.formatBingoBoards(rawBingoBoardData);

        int partTwoSolution = solver.solveGame(numberDrawPartTwo, bingoBoardsPartTwo, Outcome.WIN_LAST);

        System.out.println(partOneSolution);
        System.out.println(partTwoSolution);
    }
}
