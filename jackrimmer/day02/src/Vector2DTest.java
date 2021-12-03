import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2DTest {
    @Test
    public void testVectorSum() {
        var a = new Vector2D(4, 7);
        var moveCoordinates = new Vector2D(1, 3);
        a.translate(moveCoordinates);

        assertEquals(5, a.getX(), "Should translate x value to new value");
        assertEquals(10, a.getY(), "Should translate y value to new value");
    }
}
