package adventofcode.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CodeTest {

    Code code;

    @BeforeEach()
    public void before() {
        code = new Code();
    }

    @Test
    public void testConvertData() {
        code.setData(" 1 , 2, 3,4,5,6,7, 8,    9    ",
                Arrays.asList(
                        " 1  5 64 81 34\n",
                        "15 99 31 63 65\n",
                        "45 39 54 93 83\n",
                        "51 14 23 86 32\n",
                        "19 22 16 13  3\n",
                        "\n",
                        "20 83 38 85 70\n",
                        "69 12 14 26 84\n",
                        "19 76 45 78 99\n",
                        "22 80 90 33 46\n",
                        "75 31 21  6 28"
                )
        );
        Assertions.assertEquals(code.numbers.length, 9);
        Assertions.assertEquals(code.numbers[0], "1");
        Assertions.assertEquals(code.numbers[code.numbers.length - 1], "9");

        Assertions.assertEquals(code.boards.size(), 2);
        Assertions.assertEquals(code.boards.get(0).boardGrid.get(0).get(0).number, "1");
        Assertions.assertEquals(code.boards.get(1).boardGrid.get(0).get(0).number, "20");
    }

    @Test
    public void testMarkNumberOnBoard() {
        code.setData("1, 10",
                Arrays.asList(
                        "1 2 3",
                        "4 5 6",
                        "7 8 9",
                        " ",
                        "10 11 12",
                        "13 14 15",
                        "16 17 18"
                )
        );

        code.markNumber("1");
        Assertions.assertTrue(code.boards.get(0).boardGrid.get(0).get(0).marked);
        code.markNumber("10");
        Assertions.assertEquals(code.boards.get(1).boardGrid.get(0).get(0).marked, true);

    }

    @Test
    public void testCompleteRow() {
        code.setData("1, 10",
                Arrays.asList(
                        "1 2 3",
                        "4 5 6",
                        "7 8 9",
                        " ",
                        "10 11 12",
                        "13 14 15",
                        "16 17 18"

                )
        );

        code.markNumber("1");
        code.markNumber("2");
        code.markNumber("3");
        Assertions.assertEquals(true, code.boards.get(0).bingo().bingo());
        Assertions.assertEquals(false, code.boards.get(1).bingo().bingo());
    }

    @Test
    public void testCompleteColumn() {
        code.setData("1, 10",
                Arrays.asList(
                        "1 2 3",
                        "4 5 6",
                        "7 8 9",
                        " ",
                        "10 11 12",
                        "13 14 15",
                        "16 17 18"

                )
        );

        code.markNumber("10");
        code.markNumber("13");
        code.markNumber("16");
        Assertions.assertEquals(false, code.boards.get(0).bingo().bingo());
        Assertions.assertEquals(true, code.boards.get(1).bingo().bingo());
    }

    @Test
    public void testCalculation() {
        code.setData("1, 2, 3",
                Arrays.asList(
                        "1 2 3",
                        "4 5 6",
                        "7 8 9",
                        " ",
                        "10 11 12",
                        "13 14 15",
                        "16 17 18"

                )
        );
        code.playBingo();
        Assertions.assertEquals((4 + 5 + 6 + 7 + 8 + 9) * 3, code.bingoWins.get(0).sum());
    }

    @Test
    public void testFindWinningBoard() {
        code.playBingo();
        Assertions.assertEquals(39902, code.bingoWins.get(0).sum());
    }
    @Test
    public void testFindLastWinningBoard() {
        code.playBingo();
        Assertions.assertEquals(26936, code.bingoWins.get(code.bingoWins.size() -1).sum());
    }

    @Test
    public void testFindLastWinningBoard2() {
        code.setData("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
                Arrays.asList(
                        "22 13 17 11  0",
                                " 8  2 23  4 24",
                                "21  9 14 16  7",
                                " 6 10  3 18  5",
                                " 1 12 20 15 19",
                                "",
                                " 3 15  0  2 22",
                                " 9 18 13 17  5",
                                "19  8  7 25 23",
                                "20 11 10 24  4",
                                "14 21 16 12  6",
                                "",
                                "14 21 17 24  4",
                                "10 16 15  9 19",
                                "18  8 23 26 20",
                                "22 11 13  6  5",
                                " 2  0 12  3  7"
                )
        );
        code.playBingo();
        Assertions.assertEquals(4512, code.bingoWins.get(0).sum());
        Assertions.assertEquals(1924, code.bingoWins.get(code.bingoWins.size() -1).sum());
    }

}
