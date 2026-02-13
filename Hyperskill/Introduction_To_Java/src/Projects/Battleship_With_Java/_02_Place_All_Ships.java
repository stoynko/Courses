package Projects.Battleship_With_Java;

import java.util.*;
import java.util.stream.Collectors;

public class _02_Place_All_Ships {

/*Description
Now that we've figured out the rules of the game let's continue with positioning the ships and drawing them on our game field!
The goal of this stage is to place all the ships on the game field according to the rules.

Objectives
You have 5 ships:
    1. Aircraft Carrier is 5 cells
    2. Battleship is 4 cells
    3. Submarine is 3 cells
    4. Cruiser is also 3 cells
    5. Destroyer is 2 cells.

In this stage, you should arrange them all on the game field.

    1. Start placing your ships with the largest one.
    2. For each ship read two coordinates: the beginning and the end of the ship. Again, the order of the coordinates does not matter.
    3. Add new ships to a game field and output it the same way as in the previous stage.
    4. If the user has entered coordinates in such a way that the length of the created ship does not match the expected length,
       this should be considered an incorrect input. Also, the game rules state that ships cannot be adjacent to each other.
       For both of these cases report it with a message containing Error word.*/

    private static final int FIELD_DIMENSION = 10;
    private static final char DEFAULT_FIELD_SYMBOL = '~';
    private static final String COORDINATES_INPUT_PROMPT = "Enter the coordinates of the ship:";
    private static final String SHIP_INFO_LENGTH = "Length: ";
    private static final String SHIP_INFO_PARTS = "Parts: ";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] battlefield = initBattlefield();

        displayBattlefield(battlefield);

        System.out.println(COORDINATES_INPUT_PROMPT);
        String[] userInput = scanner.nextLine().split("\s");
        List<int[]> coordinates = null;

        try {
            coordinates = getCoordinates(userInput);
        } catch (IllegalStateException illegalStateException) {
            System.out.println("Error!");
            return;
        }

        Ship ship = deployShip(coordinates);
        System.out.println(SHIP_INFO_LENGTH + ship.getLength());
        System.out.println(SHIP_INFO_PARTS + ship.displayParts());
    }

    public static class Ship {
        private int length;
        private List<String> parts;

        public Ship() {
        }

        private String displayParts() {
            return this.parts.stream().collect(Collectors.joining(" "));
        }

        private int getLength() {
            return length;
        }

        private void setLength(int length) {
            this.length = length;
        }

        private List<String> getParts() {
            return parts;
        }

        private void setParts(List<String> parts) {
            this.parts = parts;
        }
    }

    private static Ship deployShip(List<int[]> coordinates) {
        Ship ship = new Ship();

        List<String> parts = getPartsFromCoordinates(coordinates);
        ship.setParts(parts);
        ship.setLength(parts.size());

        return ship;
    }

    private static List<String> getPartsFromCoordinates(List<int[]> coordinates) {
        List<String> parts = new ArrayList<>();

        for (int[] coordinate : coordinates) {
            char rowChar = (char) ('A' + coordinate[0]);
            int column = coordinate[1] + 1;
            parts.add(rowChar + String.valueOf(column));
        }

        return parts;
    }

    private static List<int[]> getCoordinates(String[] coordinatesInput) {

        List<int[]> initialCoordinates = new ArrayList<>();

        for (String coordinate : coordinatesInput) {
            char rowChar = coordinate.charAt(0);
            int row = rowChar - 'A';
            int column = Integer.parseInt(coordinate.substring(1)) - 1;
            initialCoordinates.add(new int[]{row, column});
        }

        if (!isCoordinatesValid(initialCoordinates)) {
            throw new IllegalStateException();
        }

        initialCoordinates.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparing(a -> a[1]));

        int startRow = initialCoordinates.get(0)[0];
        int startColumn = initialCoordinates.get(0)[1];
        int endRow = initialCoordinates.get(1)[0];
        int endColumn = initialCoordinates.get(1)[1];

        if (startRow == endRow) {
            for (int index = startColumn + 1; index < endColumn; index++) {
                initialCoordinates.add(new int[]{startRow, index});
            }
        } else if (startColumn == endColumn) {
            for (int index = startRow + 1; index < endRow; index++) {
                initialCoordinates.add(new int[]{index, startColumn});
            }
        }

        initialCoordinates.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparing(a -> a[1]));
        return initialCoordinates;
    }

    private static boolean isCoordinatesValid(List<int[]> initialCoordinates) {

        int startRow = initialCoordinates.get(0)[0];
        int startColumn = initialCoordinates.get(0)[1];
        int endRow = initialCoordinates.get(1)[0];
        int endColumn = initialCoordinates.get(1)[1];

        if (startRow != endRow && startColumn != endColumn) {
            return false;
        }


        if (startRow < 0 || endRow >= FIELD_DIMENSION ||
                startColumn < 0 || endColumn >= FIELD_DIMENSION) {
            return false;
        }

        return true;
    }

    private static void displayBattlefield(char[][] field) {

        System.out.print("  ");

        for (int i = 1; i <= FIELD_DIMENSION; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        char rowLabel = 'A';

        for (int row = 0; row < FIELD_DIMENSION; row++) {
            System.out.print(rowLabel++ + " ");
            for (int col = 0; col < FIELD_DIMENSION; col++) {
                System.out.print(field[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] initBattlefield() {
        char[][] battleField = new char[FIELD_DIMENSION][FIELD_DIMENSION];

        for (char[] row : battleField) {
            Arrays.fill(row, DEFAULT_FIELD_SYMBOL);
        }

        return battleField;
    }
}
