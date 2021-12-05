public class Vector2D {
    private int x;
    private int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void translate(Vector2D vector2D) {
        translateX(vector2D.getX());
        translateY(vector2D.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void translateX(int dx) {
        this.x += dx;
    }

    private void translateY(int dy) {
        this.y += dy;
    }
}
