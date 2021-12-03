import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMoveInstructionReader {
    private List<Vector2D> moveInstructions = MoveInstructionReader.readMoveInstructionsToVectors();

    @Test
    public void testFileIsRead() {
        assertTrue(moveInstructions.size() == 1000);
    }
}
