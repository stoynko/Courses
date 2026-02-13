package Projects.Battleship_With_Java;

import java.util.*;
import java.util.stream.Collectors;

public class _01_Create_The_Field {

/*Description
Battleship (also called Battleships or Sea Battle) is a two-player strategy game whose history traces back to the First World War.
It started off as a pencil and paper game, until Milton Bradley coined the rules and published the game.
Fun fact: it was one of the first games to be produced as a computer game in 1979! In this project, we will recreate this timeless classic.

First off, brush up on the rules of the game. There are different variations of the Battleship game,
but we will stick to the original rules written by Milton Bradley. You have a 10×10 game field and five ships to arrange on that field.
The ships can be placed horizontally or vertically but not diagonally across the grid spaces; the ships should not cross or touch each other.
The goal is to sink all the ships of the opponent before your opponent does this to you.

Understanding how the ships will be fielded is exactly where we are going to start!

Before you start, let's discuss the conventions of the game:
    1. On a 10x10 field, the first row should contain numbers from 1 to 10 indicating the column,
       and the first column should contain letters from A to J indicating the row.
    2. The symbol ~ denotes the fog of war: the unknown area on the opponent's field and the yet untouched area on your field.
    3. The symbol O denotes a cell with your ship, X denotes that the ship was hit, and M signifies a miss.

Objectives
At this stage, you will put your first ship on the game field.
    1. Print an empty game field, according to game conventions.
    2. To place a ship, enter two coordinates, the beginning and the end of the ship.
       The order of the coordinates (start to end or end to start) does not really matter.
    3. In later stages we will need to know the length of the ship and the positions on the field on which it's parts are placed.
       Therefore output this information to a player. Here is an example of possible formatting: Length: 3 and Parts: F2 F3 F4
    4. If an error occurs in the input coordinates (coordinates are not on the same line or out of bounds),
       your program should report it. The message should contain the word Error. */

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
        List<int[]> coordinates = new ArrayList<>();

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
