package Projects.Tic_Tac_Toe;

import java.util.Scanner;

public class _03_Whats_On_The_Field {

/* In this stage, we’re going to analyze the game state to determine if either player has already won the game or it is still ongoing,
if the game is a draw, or if the user has entered an impossible game state (two winners, or with one player having made too many moves).

Objectives
In this stage, your program should:
    • Take a string entered by the user and print the game grid as in the previous stage.
    • Analyze the game state and print the result. Possible states:
    • Game not finished when neither side has three in a row but the grid still has empty cells.
    • Draw when no side has a three in a row and the grid has no empty cells.
    • X wins when the grid has three X’s in a row (including diagonals).
    • O wins when the grid has three O’s in a row (including diagonals).
    • Impossible when the grid has three X’s in a row as well as three O’s in a row, or there are a lot more X's than O's or vice versa
      (the difference should be 1 or 0; if the difference is 2 or more, then the game state is impossible).
    • In this stage, we will assume that either X or O can start the game.

You can choose whether to use a space or underscore _ to print empty cells.*/

    public static char[][] field = new char[3][3];
    public static final char playerX = 'X';
    public static final char playerO = 'O';

    public static final String X_WINS = "X wins";
    public static final String O_WINS = "O wins";
    public static final String DRAW = "Draw";
    public static final String NOT_FINISHED = "Game not finished";
    public static final String IMPOSSIBLE = "Impossible";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        field = populatePlayingField(inputData);
        displayPlayingField(field);

        boolean hasEmptySpaces = containsEmptySpaces();
        boolean playerXIsWinner = isPlayerWinner(playerX);
        boolean playerOIsWinner = isPlayerWinner(playerO);
        int playerXCount = getPlayerCount(playerX);
        int playerOCount = getPlayerCount(playerO);

        if (playerXIsWinner && playerOIsWinner || Math.abs(playerXCount - playerOCount) > 1) {
            System.out.println(IMPOSSIBLE);
        } else if (playerXIsWinner) {
            System.out.println(X_WINS);
        } else if (playerOIsWinner) {
            System.out.println(O_WINS);
        } else if (!playerXIsWinner && !playerOIsWinner) {

            if (hasEmptySpaces) {
                System.out.println(NOT_FINISHED);
            } else {
                System.out.println(DRAW);
            }
        }
    }

    private static int getPlayerCount(char player) {

        int  count = 0;

        for (int row = 0; row < field.length; row++) {
            for (int column = 0; column < field.length; column++) {
                if (field[row][column] == player) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPlayerWinner(char player) {
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

    public static char[][] populatePlayingField(String inputData) {
        int inputIndex = 0;
        char[][] field = new char[3][3];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                field[row][col] = Character.valueOf(inputData.charAt(inputIndex++));
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
