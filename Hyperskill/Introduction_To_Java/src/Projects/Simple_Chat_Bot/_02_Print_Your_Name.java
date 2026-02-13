package Projects.Simple_Chat_Bot;

import java.util.*;

public class _02_Print_Your_Name {

/* Description:
The greeting part is great, but chatbots are also supposed to interact with a user.
It's time to implement this functionality.

Objective:
In this stage, you will introduce yourself to the bot so that it can greet you by your name.

Your program should print the following lines:
    Hello! My name is Aid.
    I was created in 2023.
    Please, remind me your name.
    What a great name you have, {your_name}!

You may change the name and the creation year of your bot if you want.

Instead of {your_name}, the bot must print your name entered from the standard input. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String botName = "Robby";
        int birthYear = java.time.Year.now().getValue();

        greetings(botName, birthYear, scanner);
    }

    private static void greetings(String botName, int birthYear, Scanner scanner) {
        System.out.printf("Hello! My name is %s.\n", botName);
        System.out.printf("I was created in %d.\n", birthYear);
        System.out.println("Please, remind me your name.");
        System.out.printf("What a great name you have, %s!", scanner.nextLine());
    }
}
