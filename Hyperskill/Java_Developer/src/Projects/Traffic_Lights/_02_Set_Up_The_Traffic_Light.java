package Projects.Traffic_Lights;

import java.util.Scanner;

public class _02_Set_Up_The_Traffic_Light {

/*Description
What is a system without parameters? The traffic light should work the way users want it. Everything is simple — provide input and get the corresponding program's output.

Objectives
In this stage, after the welcoming line,
ask the users to input the desired number of roads and input the interval at which the roads should open/close.
After each request, read the value that a user provides.

Next, implement a looped selection menu. The loop (as well as the program execution) ends when a user selects 0 as the desired option.
Any other option (1, 2, 3) prints an informational text on the action performed (add, delete, system) for each option. */

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(WELCOME_MESSAGE);
        System.out.print(INPUT_PROMPT_ROADS);
        int roads = Integer.parseInt(scanner.nextLine());

        System.out.print(INPUT_PROMPT_INTERVAL);
        int interval = Integer.parseInt(scanner.nextLine());

        while (true) {
            displayMenu();
            int userInput = Integer.parseInt(scanner.nextLine());

            if (userInput == 0) {
                System.out.println("Bye!");
                break;
            }

            switch (userInput) {
                case 1 -> System.out.println(OUTPUT_ROAD_ADD);
                case 2 -> System.out.println(OUTPUT_ROAD_DELETE);
                case 3 -> System.out.println(OUTPUT_SYSTEM);
            }
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