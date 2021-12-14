import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LanternfishTest {
    @Test
    public void testAgeOneDay() {
        var parent = new Lanternfish(1, 1);
        int expectedAge = 0;

        parent.ageOneDay();
        int actualAge = parent.getInternalTimer();

        assertEquals(actualAge, expectedAge);
    }

    @Test
    public void testBreed() {
        var parent = new Lanternfish(-1, 1);
        int parentExpectedAge = 6;
        int babyExpectedAge = 8;

        Lanternfish baby = parent.breed();
        int parentActualAge = parent.getInternalTimer();
        int babyActualAge = baby.getInternalTimer();

        assertEquals(parentActualAge, parentExpectedAge);
        assertEquals(babyActualAge, babyExpectedAge);
    }

    @Test
    public void testInvalidBreed() {
        var invalidParent = new Lanternfish(0, 1);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            invalidParent.breed();
        });

        String expectedMessage = "Too young to breed";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testHigherMagnitudeBreed() {
        var parent = new Lanternfish(-1, 7);
        int parentExpectedAge = 6;
        int babyExpectedAge = 8;
        int babyExpectedMagnitude = 7;

        Lanternfish baby = parent.breed();
        int parentActualAge = parent.getInternalTimer();
        int babyActualAge = baby.getInternalTimer();
        long babyActualMagnitude = baby.getMagnitude();

        assertEquals(parentActualAge, parentExpectedAge);
        assertEquals(babyActualAge, babyExpectedAge);
        assertEquals(babyActualMagnitude, babyExpectedMagnitude);
    }
}
