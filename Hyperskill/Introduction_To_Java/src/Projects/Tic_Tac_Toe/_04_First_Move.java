package Projects.Tic_Tac_Toe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _04_First_Move {

/* It's time to make our game interactive! Now we're going to add the ability for a user to make a move. To do this, we need to divide the grid into cells. 
Suppose the top left cell has the coordinates (1, 1) and the bottom right cell has the coordinates (3, 3):

(1, 1) (1, 2) (1, 3)
(2, 1) (2, 2) (2, 3)
(3, 1) (3, 2) (3, 3)

The program should ask the user to enter the coordinates of the cell where they want to make a move.

In this stage, the user plays as X, not O. Keep in mind that the first coordinate goes from top to bottom and the second coordinate goes from left to right. 
The coordinates can include the numbers 1, 2, or 3.

What happens if the user enters incorrect coordinates? 
The user could enter symbols instead of numbers, or enter coordinates representing occupied cells or cells that aren't even on the grid. 
You need to check the user's input and catch possible exceptions.

Objectives
The program should work as follows:
    • Get the initial 3x3 grid from the input as in the previous stages. Here the user should input 9 symbols representing the field, for example, _XXOO_OX_.
    • Output this 3x3 grid as in the previous stages.
    • Prompt the user to make a move. The user should input 2 coordinate numbers that represent the cell where they want to place their X, for example, 1 1.
    • Analyze user input. If the input is incorrect, inform the user why their input is wrong:
    • Print This cell is occupied! Choose another one! if the cell is not empty.
    • Print You should enter numbers! if the user enters non-numeric symbols in the coordinates input.
    • Print Coordinates should be from 1 to 3! if the user enters coordinates outside the game grid.
    • Keep prompting the user to enter the coordinates until the user input is valid.
    • If the input is correct, update the grid to include the user's move and print the updated grid to the console.
    
To summarize, you need to output the field 2 times: 
once before the user's move (based on the first line of input) and once after the user has entered valid coordinates (then you need to update the grid to include that move).*/

    public static char[][] field = new char[3][3];
    public static final char playerX = 'X';
    public static final String INVALID_INPUT = "You should enter numbers!";
    public static final String INVALID_COORDINATES = "Coordinates should be from 1 to 3!";
    public static final String CELL_OCCUPIED = "This cell is occupied! Choose another one!";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();
        field = populatePlayingField(inputData);
        displayPlayingField(field);

        List<Integer> userInput = new ArrayList<>();

        while (userInput.isEmpty()) {
            userInput = processUserInput(scanner);
        }

        processPlayerMove(userInput);

        displayPlayingField(field);
    }

    private static void processPlayerMove(List<Integer> userInput) {
        int coordinateX = userInput.get(0);
        int coordinateY = userInput.get(1);

        field[coordinateX][coordinateY] = playerX;
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

    public static char[][] populatePlayingField(String inputData) {
        int inputIndex = 0;
        char[][] field = new char[3][3];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {

                char element = Character.valueOf(inputData.charAt(inputIndex++));
                if (element == '_') {
                    field[row][col] = ' ';
                } else {
                    field[row][col] = element;
                }
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
