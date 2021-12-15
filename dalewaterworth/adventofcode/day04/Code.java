package adventofcode.day04;

import adventofcode.BaseChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Code extends BaseChallenge {
    String[] numbers;
    List<Board> boards;
    List<Bingo> bingoWins = new ArrayList<>();

    public Code() {
        super(new String[]{"adventofcode/day04/data.txt", "adventofcode/day04/data2.txt"});
        setData(rawData.get(0).get(0), rawData.get(1));
    }

    public void setData(String numberCsv, List<String> boardsRaw) {
        numbers = Arrays.stream(numberCsv.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        boards = new ArrayList<>();
        var board = new Board();
        for (int i = 0; i < boardsRaw.size(); i++) {
            var rowNumbers = Arrays.stream(boardsRaw.get(i).trim().split("\\s+"))
                    .map(String::trim)
                    .map(BoardNumber::new)
                    .collect(Collectors.toList());
            if (rowNumbers.size() == 1) {
                boards.add(board);
                board = new Board();
            } else if (boardsRaw.size() - 1 == i) {
                board.boardGrid.add(rowNumbers);
                boards.add(board);
            } else {
                board.boardGrid.add(rowNumbers);
            }
        }
    }

    public void markNumber(String number) {
        boards.stream()
                .flatMap(board -> board.boardGrid.stream())
                .flatMap(row -> row.stream())
                .filter(boardNumber -> boardNumber.number.equals(number))
                .map(boardNumber -> boardNumber.marked = true)
                .toList();
    }

    public void playBingo() {
        outerlopp:
        for (int i = 0; i < numbers.length; i++) {
            var number = numbers[i];
            markNumber(number);

            for (int j = 0; j < boards.size(); j++) {
                var boardX = boards.get(j);
                var bingo = boardX.bingo();
                if (bingo.bingo()) {
                    bingoWins.add(new Bingo(true, bingo.sum() * Integer.valueOf(number)));

                    boards.remove(boards.get(j));

                    var boardsWon = boards.stream()
                            .filter(board -> board.hasWon)
                            .collect(Collectors.toList());
                    if (boardsWon.size() == boards.size()) {
                        System.out.println("Board: " + j);
                        System.out.println("Score: " + bingo.sum());
                        System.out.println(number);
                        boardX.print();
                        System.out.println(bingo.sum() * Integer.valueOf(number));
                        break outerlopp;
                    }
                }
            }
        }
    }

    public int getLastToWin() {
        return 0;
    }
}

class BoardNumber {
    String number;
    boolean marked = false;

    BoardNumber(String number) {
        this.number = number;
    }
}

class Board {
    public List<List<BoardNumber>> boardGrid = new ArrayList<>();
    public boolean hasWon = false;

    public void print() {
        for (int i = 0; i < boardGrid.size(); i++) {
            var str = "";
            for (int j = 0; j < boardGrid.get(i).size(); j++) {
                str += boardGrid.get(i).get(j).marked + ":" + boardGrid.get(i).get(j).number + " | ";
            }
            System.out.println(str);
        }
    }

    public Bingo bingo() {
        var bingo = false;
        var sumOfUnmarkedNumbers = 0;
        for (int i = 0; i < boardGrid.size(); i++) {
            var rowMatched = boardGrid.get(i)
                    .stream()
                    .allMatch(cell -> cell.marked == true);
            if (rowMatched) {
                bingo = true;
                sumOfUnmarkedNumbers = boardGrid.stream()
                        .flatMap(row -> row.stream())
                        .filter(boardNumber -> !boardNumber.marked)
                        .map(x -> Integer.valueOf(x.number))
                        .reduce(0, Integer::sum);

                break;
            }
        }

        for (int i = 0; i < boardGrid.get(0).size(); i++) {
            List<BoardNumber> column = new ArrayList<>();
            for (int j = 0; j < boardGrid.size(); j++) {
                try {
                    column.add(boardGrid.get(j).get(i));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            var rowMatched = column
                    .stream()
                    .allMatch(cell -> cell.marked == true);
            if (rowMatched) {
                bingo = true;
                sumOfUnmarkedNumbers = boardGrid.stream()
                        .flatMap(row -> row.stream())
                        .filter(boardNumber -> !boardNumber.marked)
                        .map(x -> Integer.valueOf(x.number))
                        .reduce(0, Integer::sum);
                break;
            }
        }
        if (bingo) {
            hasWon = true;
        }

        return new Bingo(bingo, sumOfUnmarkedNumbers);
    }
}

record Bingo(boolean bingo, int sum) {
}

