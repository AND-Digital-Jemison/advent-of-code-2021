import java.util.List;

public class Submarine {
    private Vector2D coordinates = new Vector2D(0, 0);
    private int aim = 0;
    private List<MoveInstruction> moveInstructions = MoveInstructionReader.readMoveInstructions();

    public void executeMoveInstructions(Part part) {
        for (MoveInstruction moveInstruction : moveInstructions) {
            switch (part) {
                case Part1:
                    executePartOne(moveInstruction);
                    break;

                case Part2:
                    executePartTwo(moveInstruction);
                    break;

                default:
                    throw new IllegalArgumentException("Must be part one or two");
            }
        }
    }

    public Vector2D getCoordinates() {
        return coordinates;
    }

    private void executePartOne(MoveInstruction moveInstruction) {
        int value = moveInstruction.getMoveValue();
        switch (moveInstruction.getDirection()) {
            case Down:
                coordinates.translate(new Vector2D(0, value));
                break;

            case Up:
                coordinates.translate(new Vector2D(0, -value));
                break;

            case Forward:
                coordinates.translate(new Vector2D(value, 0));
                break;
        }
    }

    private void executePartTwo(MoveInstruction moveInstruction) {
        int value = moveInstruction.getMoveValue();
        switch (moveInstruction.getDirection()) {
            case Down:
                aim += value;
                break;

            case Up:
                aim -= value;
                break;

            case Forward:
                Vector2D movementVector = new Vector2D(value, aim * value);
                coordinates.translate(movementVector);
                break;
        }
    }
}
