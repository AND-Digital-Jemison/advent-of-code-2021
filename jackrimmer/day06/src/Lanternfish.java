public class Lanternfish {
    private int internalTimer;
    private long magnitude;

    public Lanternfish(int internalTimer, long magnitude) {
        this.internalTimer = internalTimer;
        this.magnitude = magnitude;
    }

    public int getInternalTimer() {
        return internalTimer;
    }

    public long getMagnitude() {
        return magnitude;
    }

    public void ageOneDay() {
        this.internalTimer--;
    }

    public Lanternfish breed() {
        if (internalTimer == -1) {
            this.internalTimer = 6;
            return new Lanternfish(8, this.magnitude);
        }

        throw new RuntimeException("Too young to breed");
    }

    public void incrementMagnitude(long magnitude) {
        this.magnitude += magnitude;
    }
}
