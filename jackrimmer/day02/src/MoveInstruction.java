public class MoveInstruction {
    private Direction direction;
    private int moveValue;

    public MoveInstruction(Direction direction, int moveValue) {
        this.direction = direction;
        this.moveValue = moveValue;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getMoveValue() {
        return moveValue;
    }
}
