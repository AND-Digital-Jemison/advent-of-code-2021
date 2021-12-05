import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BingoDataFormatter {
    public static List<Integer> formatNumberDraw(String unformattedDraw) {
        String[] unformattedArray = unformattedDraw.split(",");
        List<Integer> formattedNumberDraw = new ArrayList<>();

        for (int i = 0; i < unformattedArray.length; i++) {
            formattedNumberDraw.add(Integer.parseInt(unformattedArray[i]));
        }

        return formattedNumberDraw;
    }

    public static List<BingoSquare[][]> formatBingoBoards(List<String> unformattedData) {
        List<BingoSquare[][]> bingoCards = new ArrayList<>();

        for (int i = 0; i < unformattedData.size(); i += 6) {
            BingoSquare[][] bingoCard = formatBingoCard(unformattedData.subList(i + 1, i + 6));
            bingoCards.add(bingoCard);
        }

        return bingoCards;
    }

    private static BingoSquare[][] formatBingoCard(List<String> unformattedCard) {
        BingoSquare[][] bingoCard = new BingoSquare[5][5];
        for (int i = 0; i < unformattedCard.size(); i++) {
            bingoCard[i] = formatLine(unformattedCard.get(i));
        }

        return bingoCard;
    }

    private static BingoSquare[] formatLine(String unformattedLine) {
        String[] unformattedArray = makeFormattable(unformattedLine);
        var formattedCardLine = new BingoSquare[unformattedArray.length];

        for (int i = 0; i < unformattedArray.length; i++) {
            formattedCardLine[i] = new BingoSquare(Integer.parseInt(unformattedArray[i]));
        }

        return formattedCardLine;
    }

    private static String[] makeFormattable(String unformattedLine) {
        String[] unformattedArray = unformattedLine.split("  | ");
        if (unformattedArray[0] == "") {
            unformattedArray = Arrays.copyOfRange(unformattedArray, 1, 6);
        }

        return unformattedArray;
    }
}
