package Projects.Tic_Tac_Toe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _05_Fight {

/* Our game is almost ready! Now let's combine what we’ve learned in the previous stages to make a game of tic-tac-toe that two players
can play from the beginning (with an empty grid) through to the end (until there is a draw, or one of the players wins).
The first player has to play as X and their opponent plays as O.

Objectives
In this stage, you should write a program that:

Prints an empty grid at the beginning of the game.
Creates a game loop where the program asks the user to enter the cell coordinates, analyzes the move for correctness and shows a grid with the changes if everything is okay.
Ends the game when someone wins or there is a draw.
You need to output the final result at the end of the game. Good luck! */

    public static char[][] field = initPlayingField();
    public static Scanner scanner = new Scanner(System.in);
    public static final char playerX = 'X';
    public static final char playerO = 'O';

    public static final String X_WINS = "X wins";
    public static final String O_WINS = "O wins";
    public static final String DRAW = "Draw";
    public static final String INVALID_INPUT = "You should enter numbers!";
    public static final String INVALID_COORDINATES = "Coordinates should be from 1 to 3!";
    public static final String CELL_OCCUPIED = "This cell is occupied! Choose another one!";

    public static void main(String[] args) {


        boolean hasGameEnded = false;
        char currentPlayer = 'X';

        while (!hasGameEnded) {
            displayPlayingField(field);


            List<Integer> userInput = new ArrayList<>();

            while (userInput.isEmpty()) {
                userInput = processUserInput(scanner);
            }

            processPlayerMove(userInput, currentPlayer);

            String gameEndCondition = getGameEndCondition();

            if (gameEndCondition == null) {
                hasGameEnded = false;
            } else {
                displayPlayingField(field);
                System.out.println(gameEndCondition);
                return;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        displayPlayingField(field);
    }

    private static String getGameEndCondition() {

        boolean hasEmptySpaces = containsEmptySpaces();
        boolean playerXIsWinner = isPlayerWinner(playerX);
        boolean playerOIsWinner = isPlayerWinner(playerO);

        if (playerXIsWinner) {
            return X_WINS;
        } else if (playerOIsWinner) {
            return O_WINS;
        } else if (!playerXIsWinner && !playerOIsWinner &&  !hasEmptySpaces) {
            return DRAW;
        }
        return null;
    }

    private static boolean isPlayerWinner(char player) {
        for (int i = 0; i < field.length; i++) {

            //ROW CHECK
            if (field[i][0] == player && field[i][1] == player && field[i][2] == player) {
                return true;
            }

            // COLUMN CHECK
            if (field[0][i] == player && field[1][i] == player && field[2][i] == player) {
                return true;
            }
        }

        // DIAGONALS CHECK
        return (field[0][0] == player && field[1][1] == player && field[2][2] == player) ||
                (field[0][2] == player && field[1][1] == player && field[2][0] == player);
    }

    private static boolean containsEmptySpaces() {
        for (int row = 0; row < field.length; row++) {
            for (int column = 0; column < field.length; column++) {
                if (field[row][column] == '_' || field[row][column] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private static void processPlayerMove(List<Integer> userInput, char currentPlayer) {
        int coordinateX = userInput.get(0);
        int coordinateY = userInput.get(1);

        if (currentPlayer == 'X') {
            field[coordinateX][coordinateY] = playerX;
        } else {
            field[coordinateX][coordinateY] = playerO;
        }
    }

    private static List<Integer> processUserInput(Scanner scanner) {

        String[] userInput = scanner.nextLine().split("\\s");
        List<Integer> parsedUserInput = new ArrayList<>();

        try {
            int coordinateX = Integer.parseInt(userInput[0].trim());
            int coordinateY = Integer.parseInt(userInput[1].trim());
            parsedUserInput.add(coordinateX);
            parsedUserInput.add(coordinateY);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(INVALID_INPUT);
            return new ArrayList<>();
        }

        if (!isInputValid(parsedUserInput)) {
            System.out.println(INVALID_COORDINATES);
            return new ArrayList<>();
        }

        if (!isSpaceEmpty(parsedUserInput.get(0) - 1, parsedUserInput.get(1) - 1)) {
            System.out.println(CELL_OCCUPIED);
            return new ArrayList<>();
        }

        for (int index = 0; index < parsedUserInput.size(); index++) {
            int value = parsedUserInput.get(index) - 1;
            parsedUserInput.set(index, value);
        }

        return parsedUserInput;
    }

    private static boolean isInputValid(List<Integer> userInput) {

        int coordinateX = userInput.get(0).intValue();
        int coordinateY = userInput.get(1).intValue();

        return coordinateX >= 1 && coordinateX <= 3 && coordinateY >=1 && coordinateY <= 3;
    }

    private static boolean isSpaceEmpty(int coordinate, int coordinateY) {
        return field[coordinate][coordinateY] == ' ' ? true : false;
    }

    public static char[][] initPlayingField() {
        char[][] field = new char[3][3];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                field[row][col] = ' ';
            }
        }
        return field;
    }

    public static void displayPlayingField(char[][] field) {
        System.out.println("---------");
        for (int row = 0; row < field.length; row++) {
            System.out.print("| ");

            for (int column = 0; column < field.length; column++) {
                System.out.print(field[row][column] + " ");
            }

            System.out.print("| ");
            System.out.println();
        }
        System.out.println("---------");
    }
}
