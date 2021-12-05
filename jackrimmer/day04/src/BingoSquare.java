public class BingoSquare {
    private int value;
    private boolean marked = false;

    public BingoSquare(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void mark() {
        marked = true;
    }

    public boolean isMarked() {
        return marked;
    }
}
