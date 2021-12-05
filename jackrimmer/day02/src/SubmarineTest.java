import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubmarineTest {

    @Test
    public void testMoveForward() {
        var sub = new Vector2D(0, 0);
        var forward = new Vector2D(3, 0);
        sub.translate(forward);

        assertEquals(3, sub.getX(), "Submarine moves forward");
    }

    @Test void testMoveUp() {
        var sub = new Vector2D(0, 0);
        var forward = new Vector2D(0, 5);
        sub.translate(forward);

        assertEquals(5, sub.getY(), "Submarine moves up");
    }

    @Test void testMoveDown() {
        var sub = new Vector2D(0, 10);
        var forward = new Vector2D(0, -5);
        sub.translate(forward);

        assertEquals(5, sub.getY(), "Submarine moves down");
    }
}
