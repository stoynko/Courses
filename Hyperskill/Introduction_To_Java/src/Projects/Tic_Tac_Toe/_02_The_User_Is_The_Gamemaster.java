package Projects.Tic_Tac_Toe;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _02_The_User_Is_The_Gamemaster {

/* Description:
Our program should be able to display the grid at all stages of the game.
ow we’re going to write a program that allows the user to enter a string representing the game state and correctly
prints the 3x3 game grid based on this input. We’ll also add some boundaries around the game grid.

Objectives:
In this stage, you will write a program that:
Reads a string of 9 symbols from the input and displays them to the user in a 3x3 grid. The grid can contain only X, O and _ symbols.
Outputs a line of dashes --------- above and below the grid, adds a pipe | symbol to the beginning and end of each line of the grid,
and adds a space between all characters in the grid. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        char[][] field = populatePlayingField(inputData);
        displayPlayingField(field);

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
            for (int col = 0; col < field.length; col++) {
                System.out.print(field[row][col] + " ");
            }
            System.out.print("| ");
            System.out.println();
        }
        System.out.println("---------");
    }
}
