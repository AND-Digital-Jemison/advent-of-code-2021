import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoveInstructionReader {
    public static List<MoveInstruction> readMoveInstructions() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/move-instructions.txt"))) {
            var moveInstructions = new ArrayList<MoveInstruction>();
            String line;

            while ((line = br.readLine()) != null) {
                var moveInstruction = parseMoveInstruction(line);
                moveInstructions.add(moveInstruction);
            }

            return moveInstructions;
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Could not load file");
    }

    private static MoveInstruction parseMoveInstruction(String line) {
        String[] arguments = line.split(" ");
        MoveInstruction moveInstruction;
        int moveValue = Integer.parseInt(arguments[1]);
        switch(arguments[0]) {
            case "forward":
                moveInstruction = new MoveInstruction(Direction.Forward, moveValue);
                break;

            case "up":
                moveInstruction = new MoveInstruction(Direction.Up, moveValue);
                break;

            case "down":
                moveInstruction = new MoveInstruction(Direction.Down, moveValue);
                break;

            default:
                throw new IllegalArgumentException("Invalid movement option");
        }

        return moveInstruction;
    }
}
