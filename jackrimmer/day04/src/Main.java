import java.util.List;

public class Main {

    public static void main(String[] args) {
        var reader = new BingoDataReader("src/bingo-data.txt");
        String rawNumberDrawData = reader.getNumberDrawData();
        List<String> rawBingoBoardData = reader.getBingoBoardData();

        List<Integer> numberDraw = BingoDataFormatter.formatNumberDraw(rawNumberDrawData);
        List<BingoSquare[][]> bingoBoards = BingoDataFormatter.formatBingoBoards(rawBingoBoardData);

        var solver = new BingoSolver();

        int partOneSolution = solver.solveGame(numberDraw, bingoBoards, Outcome.WIN_FIRST);
        int partTwoSolution = solver.solveGame(numberDraw, bingoBoards, Outcome.WIN_LAST);

        System.out.println(partOneSolution);
    }
}
