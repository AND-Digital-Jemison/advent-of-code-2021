import java.util.List;

public class Submarine {
    private Vector2D coordinates = new Vector2D(0, 0);
    private int aim = 0;
    private List<MoveInstruction> moveInstructions = MoveInstructionReader.readMoveInstructions();

    public void executeMoveInstructions() {
        for (MoveInstruction moveInstruction : moveInstructions) {
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

    public Vector2D getCoordinates() {
        return coordinates;
    }
}
