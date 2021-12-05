public class Main {

    public static void main(String[] args) {
        var part1Sub = new Submarine();
        part1Sub.executeMoveInstructions(Part.Part1);

        var part2Sub = new Submarine();
        part1Sub.executeMoveInstructions(Part.Part2);

        System.out.println(part1Sub.getCoordinates().getX() * part1Sub.getCoordinates().getY());
        System.out.println(part2Sub.getCoordinates().getX() * part2Sub.getCoordinates().getY());
    }
}
