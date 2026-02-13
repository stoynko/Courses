package Projects.Battleship_With_Java;

import java.io.IOException;
import java.util.*;

public class _05_Define_End_Game_Rules {

/* Description
It looks like everything is ready for full-scale battlefield maneuvers! This time, don't cease fire until all the ships are sunk.
At the end of the game, your program should print a congratulatory message to the winner: You sank the last ship. You won. Congratulations!

Objectives:
To complete this step, you should add a check that all the ships were successfully sunk. The game is supposed to go on until all ships go down.
The program should print an extra message You sank a ship! when all the cells of a particular ship have been hit. */

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Battlefield battlefield = new Battlefield();

        Player player = new Player();

        for (Ship ship : player.getShips()) {

            System.out.println();
            System.out.println(MessagePrompts.COORDINATES_INPUT_PROMPT.formatted(ship.getName(), ship.getLength()));
            List<int[]> coordinates = getUserInput(scanner);
            while (!isCoordinatesValid(coordinates, battlefield, ship)) {
                coordinates = getUserInput(scanner);
            }

            battlefield.deployShip(coordinates);
            List<Part> shipParts = new ArrayList<>();

            for (int[] coordinate : coordinates) {
                int row = coordinate[0];
                int column = coordinate[1];
                Part part = new Part(row, column);
                shipParts.add(part);
            }

            ship.setParts(shipParts);
            battlefield.displayBattlefield();
        }

        battlefield = new Battlefield();

        System.out.println("\nThe game starts!");

        battlefield.displayBattlefield();

        System.out.println("\nTake a shot!\n");

        int[] targetCoordinates = getTargetCoordinates(scanner.nextLine());

        while (player.hasShips()) {

            while (!isTargetCoordinatesValid(targetCoordinates, battlefield)) {
                System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
                targetCoordinates = getTargetCoordinates(scanner.nextLine());
            }

            processShotAttempt(battlefield, player, targetCoordinates);
            targetCoordinates = getTargetCoordinates(scanner.nextLine());
        }
    }

    private static void processShotAttempt(Battlefield battlefield, Player player, int[] targetCoordinates) {

        int row = targetCoordinates[0];
        int column = targetCoordinates[1];

        for (Ship ship : player.getShips()) {

            for (Part part : ship.getParts()) {

                if (part.getCoordinateX() == row && part.getCoordinateY() == column) {

                    battlefield.markHit(new int[]{row, column});
                    part.isDestroyed = true;

                    boolean allDestroyed = true;
                    for (Part p : ship.getParts()) {
                        if (!p.isDestroyed) {
                            allDestroyed = false;
                            break;
                        }
                    }

                    battlefield.displayBattlefield();

                    if (allDestroyed && !ship.isSunk()) {
                        ship.setSunk(true);

                        if (!player.hasShips()) {
                            System.out.println();
                            System.out.println(MessagePrompts.GAME_WON);
                            System.exit(0);
                        }

                        System.out.println();
                        System.out.println(MessagePrompts.SHIP_SUNK);
                        return;
                    }

                    System.out.println();
                    System.out.println(MessagePrompts.HIT_SUCCESSFUL);
                    return;
                }
            }
        }

        battlefield.markMiss(targetCoordinates);
        battlefield.displayBattlefield();
        System.out.println();
        System.out.println(MessagePrompts.HIT_UNSUCCESSFUL);
    }

    private static List<int[]> getUserInput(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        return getDeploymentCoordinates(input);
    }

    private static List<int[]> getDeploymentCoordinates(String[] coordinatesInput) {

        List<int[]> initialCoordinates = new ArrayList<>();

        for (String coordinate : coordinatesInput) {
            char rowChar = coordinate.charAt(0);
            int row = rowChar - 'A';
            int column = Integer.parseInt(coordinate.substring(1)) - 1;
            initialCoordinates.add(new int[]{row, column});
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

    private static int[] getTargetCoordinates(String coordinatesInput) {
        int[] targetCoordinates = new int[2];

        char rowChar = coordinatesInput.charAt(0);
        int row = rowChar - 'A';
        int column = Integer.parseInt(coordinatesInput.substring(1)) - 1;

        targetCoordinates[0] = row;
        targetCoordinates[1] = column;

        return targetCoordinates;
    }

    private static boolean isTargetCoordinatesValid(int[] targetCoordinates, Battlefield battlefield) {
        int row = targetCoordinates[0];
        int column = targetCoordinates[1];
        int battlefieldSize = battlefield.getSize();
        return row >= 0 && row < battlefieldSize && column >= 0 && column < battlefieldSize;
    }

    private static boolean isCoordinatesValid(List<int[]> coordinates, Battlefield battlefield, Ship ship) {

        int startRow = coordinates.get(0)[0];
        int startColumn = coordinates.get(0)[1];
        int endRow = coordinates.get(1)[0];
        int endColumn = coordinates.get(1)[1];

        int battlefieldDimension = battlefield.getSize();

        if (startRow != endRow && startColumn != endColumn) {
            System.out.println(MessagePrompts.PLACEMENT_WRONG_LOCATION);
            return false;
        }

        if (startRow < 0 || endRow >= battlefieldDimension ||
                startColumn < 0 || endColumn >= battlefieldDimension) {
            System.out.println(MessagePrompts.PLACEMENT_WRONG_LOCATION);
            return false;
        }

        if (coordinates.size() != ship.getLength()) {
            System.out.print(MessagePrompts.PLACEMENT_WRONG_LENGTH.formatted(ship.getName()));
            System.out.println();
            return false;
        }

        List<int[]> adjacentFields = getAdjacentFields(coordinates, battlefield);

        if (!isPositionValid(adjacentFields, battlefield)) {
            System.out.println(MessagePrompts.PLACEMENT_TOO_CLOSE);
            return false;
        }
        return true;
    }

    private static List<int[]> getAdjacentFields(List<int[]> coordinates, Battlefield battlefield) {

        List<int[]> adjacentFields = new ArrayList<>();
        int size = battlefield.getSize();

        for (int[] cell : coordinates) {
            int row = cell[0];
            int col = cell[1];

            for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {
                for (int deltaColumn = -1; deltaColumn <= 1; deltaColumn++) {

                    if (deltaRow == 0 && deltaColumn == 0) {
                        continue;
                    }

                    int newRow = row + deltaRow;
                    int newCol = col + deltaColumn;

                    if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                        adjacentFields.add(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return adjacentFields;
    }

    private static boolean isPositionValid(List<int[]> adjacentFields, Battlefield battlefield) {

        for (int[] field : adjacentFields) {
            int row = field[0];
            int column = field[1];

            if (battlefield.getMap()[row][column] == 'O') {
                return false;
            }
        }

        return true;
    }

    public static enum ShipType {
        AIRCRAFT,
        BATTLESHIP,
        SUBMARINE,
        CRUISER,
        DESTROYER;
    }

    public static class Ship {

        private String name;

        private int length;

        private List<Part> parts;

        private boolean isSunk;

        public Ship(String name, int length) {
            setName(name);
            setLength(length);
            setParts(new ArrayList<>(length));
            isSunk = false;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Part> getParts() {
            return parts;
        }

        public void setParts(List<Part> parts) {
            this.parts = parts;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public boolean isSunk() {
            return isSunk;
        }

        public void setSunk(boolean sunk) {
            isSunk = sunk;
        }
    }

    public static class Part {

        private int coordinateX;

        private int coordinateY;

        private boolean isDestroyed;

        public Part(int coordinateX, int coordinateY) {
            this.coordinateX = coordinateX;
            this.coordinateY = coordinateY;
            this.isDestroyed = false;
        }

        public int getCoordinateX() {
            return coordinateX;
        }

        public int getCoordinateY() {
            return coordinateY;
        }

        public boolean isDestroyed() {
            return isDestroyed;
        }
    }

    public static class Aircraft extends Ship {

        private static final String SHIP_NAME = "Aircraft Carrier";
        private static final int SHIP_LENGTH = 5;

        public Aircraft() {
            super(SHIP_NAME, SHIP_LENGTH);
        }
    }

    public static class Battleship extends Ship {

        private static final String SHIP_NAME = "Battleship";
        private static final int SHIP_LENGTH = 4;

        public Battleship() {
            super(SHIP_NAME, SHIP_LENGTH);
        }
    }

    public static class Cruiser extends Ship {

        private static final String SHIP_NAME = "Cruiser";
        private static final int SHIP_LENGTH = 3;

        public Cruiser() {
            super(SHIP_NAME, SHIP_LENGTH);
        }
    }

    public static class Destroyer extends Ship {

        private static final String SHIP_NAME = "Destroyer";
        private static final int SHIP_LENGTH = 2;

        public Destroyer() {
            super(SHIP_NAME, SHIP_LENGTH);
        }
    }

    public static class Submarine extends Ship {

        private static final String SHIP_NAME = "Submarine";
        private static final int SHIP_LENGTH = 3;

        public Submarine() {
            super(SHIP_NAME, SHIP_LENGTH);
        }
    }

    public static class ShipBuilder {

        public static Ship buildShip(ShipType shipType) {

            return switch (shipType) {
                case AIRCRAFT -> new Aircraft();
                case BATTLESHIP -> new Battleship();
                case SUBMARINE -> new Submarine();
                case CRUISER -> new Cruiser();
                case DESTROYER -> new Destroyer();
            };
        }
    }

    public static class Player {

        private List<Ship> ships;

        public Player() {
            setShips();
        }

        public List<Ship> getShips() {
            return this.ships;
        }

        public void setShips() {
            this.ships = List.of(
                    ShipBuilder.buildShip(ShipType.AIRCRAFT),
                    ShipBuilder.buildShip(ShipType.BATTLESHIP),
                    ShipBuilder.buildShip(ShipType.SUBMARINE),
                    ShipBuilder.buildShip(ShipType.CRUISER),
                    ShipBuilder.buildShip(ShipType.DESTROYER)
            );
        }

        public List<int[]> getShipCoordinates() {
            List<int[]> shipCoordinates = new ArrayList<>();

            for (Ship ship : this.ships) {

                for (Part part : ship.getParts()) {
                    int row = part.getCoordinateX();
                    int column = part.getCoordinateY();
                    shipCoordinates.add(new int[]{row, column});
                }
            }

            return shipCoordinates;
        }

        public boolean hasShips() {
            for (Ship ship : this.ships) {
                if (!ship.isSunk()) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class MessagePrompts {
        public static final String COORDINATES_INPUT_PROMPT = "Enter the coordinates of the %s (%d cells):";
        public static final String PLACEMENT_TOO_CLOSE = "Error! You placed it too close to another one. Try again:";
        public static final String PLACEMENT_WRONG_LENGTH = "Error! Wrong length of the %s! Try again:";
        public static final String PLACEMENT_WRONG_LOCATION = "Error! Wrong ship location! Try again:";
        public static final String HIT_SUCCESSFUL = "You hit a ship! Try again:";
        public static final String HIT_UNSUCCESSFUL = "You missed. Try again:";
        public static final String GAME_WON = "You sank the last ship. You won. Congratulations!";
        public static final String SHIP_SUNK = "You sank a ship! Specify a new target:";

    }

    public static class Battlefield {

        public static final char HIT_SUCCESS_FIELD_MARK = 'X';
        public static final char HIT_FAILED_FIELD_MARK = 'M';
        private static final int FIELD_DIMENSION = 10;
        private static final char DEFAULT_FIELD_SYMBOL = '~';
        private static final char OCCUPIED_FIELD_SYMBOL = 'O';
        private final int size;
        private char[][] map;

        public Battlefield() {
            setMap(FIELD_DIMENSION);
            this.size = FIELD_DIMENSION;
        }

        public int getSize() {
            return this.size;
        }

        public char[][] getMap() {
            return map;
        }

        public void setMap(int dimensions) {
            char[][] battlefield = new char[FIELD_DIMENSION][FIELD_DIMENSION];

            for (char[] row : battlefield) {
                Arrays.fill(row, DEFAULT_FIELD_SYMBOL);
            }

            this.map = battlefield;
        }

        public void displayBattlefield() {
            System.out.println();
            System.out.print("  ");

            for (int i = 1; i <= map.length; i++) {
                System.out.print(i + " ");
            }

            System.out.println();

            char rowLabel = 'A';

            for (char[] chars : map) {
                System.out.print(rowLabel++ + " ");
                for (int col = 0; col < map.length; col++) {
                    System.out.print(chars[col] + " ");
                }

                System.out.println();
            }
        }

        public void positionShips(List<int[]> shipCoordinates) {
            for (int[] shipCoordinate : shipCoordinates) {
                int row = shipCoordinate[0];
                int column = shipCoordinate[1];
                map[row][column] = OCCUPIED_FIELD_SYMBOL;
            }
        }

        public void deployShip(List<int[]> coordinates) {
            for (int[] coordinate : coordinates) {
                int row = coordinate[0];
                int column = coordinate[1];
                map[row][column] = OCCUPIED_FIELD_SYMBOL;
            }
        }

        public void markHit(int[] coordinates) {
            map[coordinates[0]][coordinates[1]] = HIT_SUCCESS_FIELD_MARK;
        }

        public void markMiss(int[] coordinates) {
            map[coordinates[0]][coordinates[1]] = HIT_FAILED_FIELD_MARK;
        }
    }
}
