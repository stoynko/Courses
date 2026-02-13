package Projects.Last_Pencil;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_New_Rules {

/*Description
Your friend's suggestion surprised you a little bit. After a couple of "No, you" retaliations,
you decided that it would be more convenient to input the initial conditions to determine who goes first,and how many pencils there are on the table.

Objectives
Write a program that will satisfy the conditions below:
    1. Ask users to input the number of pencils with the How many pencils string. Read the number;
    2. Ask users to input who goes first from the two possible players. To do so, output the Who will be the first (*Name1*, *Name2*) string.
       You can ask a user to choose from any two names that consist of the letters of the English alphabet and numbers (for example, John and Jack). Read the name;
    3. Print two lines: one with vertical bar symbols representing the input number of pencils, the other with the *NameX* is going first string.*/

    public static final String PEN_INPUT_PROMPT = "How many pencils would you like to use:";
    public static final String FIRST_TURN_PROMPT = "Who will be the first (%s):";
    public static final String FIRST_PLAYER_OUTPUT = "%s is going first!";
    public static final String PEN_SYMBOL = "|";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(PEN_INPUT_PROMPT);
        int pensCount = Integer.parseInt(scanner.nextLine());

        List<String> players = List.of("Jack", "John");
        System.out.println(FIRST_TURN_PROMPT.formatted(players.stream().collect(Collectors.joining(", "))));
        String firstPlayer = scanner.nextLine();

        System.out.println(PEN_SYMBOL.repeat(pensCount));
        System.out.println(FIRST_PLAYER_OUTPUT.formatted(firstPlayer));
    }
}
