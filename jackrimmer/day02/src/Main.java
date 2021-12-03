public class Main {

    public static void main(String[] args) {
        var sub = new Submarine();
        sub.executeMoveInstructions();

        System.out.println(sub.getCoordinates().getX() * sub.getCoordinates().getY());
    }
}
