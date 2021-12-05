import java.util.List;

public class BingoSolver {
    private int finalSolution;

    public int solveGame(List<Integer> numberDraw, List<BingoSquare[][]> boards, Outcome outcome) {
        for (int drawnNumber: numberDraw) {
            for (BingoSquare[][] board: boards) {
                boolean roundWon = playRound(drawnNumber, board);
                if (roundWon) {
                    if (outcome == Outcome.WIN_LAST && boards.size() > 1) {
                        boards.remove(board);
                        continue;
                    }
                    else {
                        return finalSolution;
                    }
                }
            }
        }

        throw new IllegalArgumentException("Game must be solvable");
    }

    private boolean playRound(int drawnNumber, BingoSquare[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                BingoSquare currentSquare = board[row][column];
                if (currentSquare.getValue() == drawnNumber) {
                    currentSquare.mark();
                    boolean wonGame = checkRowAndColumnForBingo(board, row, column);

                    if (wonGame) {
                        finalSolution = drawnNumber * getUnmarkedSum(board);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int getUnmarkedSum(BingoSquare[][] board) {
        int unmarkedSum = 0;
        for (int row = 0; row < board[0].length; row++) {
            for (int column = 0; column < board.length; column++) {
                BingoSquare currentSquare = board[row][column];
                if (!currentSquare.isMarked()) {
                    unmarkedSum+= currentSquare.getValue();
                }
            }
        }

        return unmarkedSum;
    }

    private boolean checkRowAndColumnForBingo(BingoSquare[][] board, int row, int column) {
        boolean rowBingo = checkRowForBingo(board, row);
        boolean columnBingo = checkColumnForBingo(board, column);

        return rowBingo || columnBingo;
    }

    private boolean checkRowForBingo(BingoSquare[][] board, int row) {
        for (int column = 0; column < board[row].length; column++) {
            if (!board[row][column].isMarked()) {
                return false;
            }
        }

        return true;
    }

    private boolean checkColumnForBingo(BingoSquare[][] board, int column) {
        for (int row = 0; row < board.length; row++) {
            if (!board[row][column].isMarked()) {
                return false;
            }
        }

        return true;
    }
}
