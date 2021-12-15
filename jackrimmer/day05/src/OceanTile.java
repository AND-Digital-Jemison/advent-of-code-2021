public class OceanTile {
    private int x;
    private int y;
    private int overlapCount;

    public OceanTile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addOverlap() {
        overlapCount++;
    }

    public int getOverlap() {
        return overlapCount;
    }
}
