package Projects.Traffic_Lights;

import java.io.IOException;
import java.util.Scanner;

public class _03_Oops_Wrong_Button {

/*Description
What if users didn't get enough sleep? All night they controlled the movement of imaginary roads and in the morning,
struggling with sleep and misclicks, enter the incorrect parameters. The system should handle wrong input and print appropriate feedback.

In this stage, let's expand our program with error handling and some visual improvements.

The number of roads and intervals at which the roads should open/close should be positive integer values (note, that 0 is not a positive value),
so if a user provided any other input, our system should print an error that contains the Incorrect input and Try again substrings.

The selected option in the menu should be either 0, 1, 2 or 3, so if a user made a mistake, our system should print the Incorrect option feedback.

To make the output of our program more convenient, we can clear the previous output after each menu option is executed.
Due to the cross-platform nature of Java, clearing the console output can be complicated. You can use this snippet to remove the console output.

    try {
      var clearCommand = System.getProperty("os.name").contains("Windows")
              ? new ProcessBuilder("cmd", "/c", "cls")
              : new ProcessBuilder("clear");
      clearCommand.inheritIO().start().waitFor();
    }
    catch (IOException | InterruptedException e) {}

However, it would be difficult for users to get familiar with the result of the execution before the information is cleared,
so after each operation, the program must wait for a new line to be entered before the next iteration.

Note: Clearing won't work in IntelliJ IDEA console. For that to show up you'll need to run a solution from a terminal.
We won't test how you clear the console. If you choose to display the output as solid text, make sure that your program still waits for a new line after option execution.

Objectives:
To complete this stage, your program must comply with the following requirements:
    1. If the provided input for the number of roads or interval is not a positive integer value, the program should print a line, containing Incorrect input and again substrings, followed by a new input.
    2. If the chosen option is something other than 0, 1, 2, or 3, the program should output an Incorrect option feedback.
    3. Modify the infinite loop so that when the result of option execution is shown, the program requires any input before the next iteration. */

    public static final String WELCOME_MESSAGE = "Welcome to the traffic management system!";

    public static final String INPUT_PROMPT_ROADS = "Input the number of roads:";
    public static final String INPUT_PROMPT_INTERVAL = "Input the interval:";

    public static final String MENU = "Menu:";
    public static final String MENU_ITEM_ONE = "1. Add";
    public static final String MENU_ITEM_TWO = "2. Delete";
    public static final String MENU_ITEM_THREE = "3. System";
    public static final String MENU_ITEM_QUIT = "0. Quit";

    public static final String OUTPUT_ROAD_ADD = "Road added";
    public static final String OUTPUT_ROAD_DELETE = "Road deleted";
    public static final String OUTPUT_SYSTEM = "System opened";
    public static final String OUTPUT_INPUT_ERROR = "Incorrect Input. Try again:";
    public static final String OUTPUT_OPTION_ERROR = "Incorrect option";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(WELCOME_MESSAGE);
        System.out.print(INPUT_PROMPT_ROADS);
        int roads = getInput(scanner);

        System.out.print(INPUT_PROMPT_INTERVAL);
        int interval = getInput(scanner);

        while (true) {
            clearScreenTerminal();
            displayMenu();
            String userInput = scanner.nextLine();

            if ("0".equals(userInput)) {
                System.out.println("Bye!");
                break;
            }

            switch (userInput) {
                case "1" -> {
                    System.out.println(OUTPUT_ROAD_ADD);
                    scanner.nextLine();
                }
                case "2" -> {
                    System.out.println(OUTPUT_ROAD_DELETE);
                    scanner.nextLine();
                }
                case "3" -> {
                    System.out.println(OUTPUT_SYSTEM);
                    scanner.nextLine();
                }
                default -> {
                    System.out.println(OUTPUT_OPTION_ERROR);
                    scanner.nextLine();
                }
            }
        }
    }

    private static void clearScreen() {
        System.out.println("\n".repeat(20));
    }

    private static void clearScreenTerminal() {
        try {
            var clearCommand = System.getProperty("os.name").contains("Windows")
                    ? new ProcessBuilder("cmd", "/c", "cls")
                    : new ProcessBuilder("clear");
            clearCommand.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ignored) {
        }
    }

    private static int getInput(Scanner scanner) {
        String input = scanner.nextLine();

        while (true) {

            int integerValue;

            try {
                integerValue = Integer.parseInt(input);
            } catch (NumberFormatException numberFormatException) {
                System.out.print(OUTPUT_INPUT_ERROR);
                input = scanner.nextLine();
                continue;
            }

            if (integerValue > 0) {
                return integerValue;
            }

            System.out.print(OUTPUT_INPUT_ERROR);
            input = scanner.nextLine();
        }
    }

    public static void displayMenu() {
        System.out.println(MENU);
        System.out.println(MENU_ITEM_ONE);
        System.out.println(MENU_ITEM_TWO);
        System.out.println(MENU_ITEM_THREE);
        System.out.println(MENU_ITEM_QUIT);
    }
}