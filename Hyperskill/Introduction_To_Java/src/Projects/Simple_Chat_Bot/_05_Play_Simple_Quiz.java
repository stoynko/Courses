package Projects.Simple_Chat_Bot;

import java.util.*;

public class _05_Play_Simple_Quiz {

/* Description:
At the final stage, you will improve your simple bot so that it can give you a test and check your answers.
The test should be a multiple-choice quiz about programming with any number of options.
Your bot has to repeat the test until you answer correctly and congratulate you upon completion.

Objective:
    Your bot can ask anything you want, but there are two rules for your output:
         • The line with the test should end with the question mark character;
         • An option starts with a digit followed by the dot (1., 2., 3., 4.)
         • If a user enters an incorrect answer, the bot may print a message: Please, try again.

The program should stop on the correct answer and print Congratulations, have a nice day! at the end. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String botName = "Robby";
        int birthYear = java.time.Year.now().getValue();

        greetings(botName, birthYear, scanner);
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int age = guessAge(scanner);
        System.out.printf("Your age is %d; that's a good time to start programming!\n", age);
        System.out.println("Now I will prove to you that I can count to any number you want.");
        countToN(scanner);
        playQuiz(scanner);
    }

    private static void countToN(Scanner scanner) {
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= num; i++) {
            System.out.println(i + "!");
        }
    }

    private static void greetings(String botName, int birthYear, Scanner scanner) {
        System.out.printf("Hello! My name is %s.\n", botName);
        System.out.printf("I was created in %d.\n", birthYear);
        System.out.println("Please, remind me your name.");
        System.out.printf("What a great name you have, %s!\n", scanner.nextLine());
    }

    private static int guessAge(Scanner scanner) {
        int remainder3 = Integer.parseInt(scanner.nextLine());
        int remainder5 = Integer.parseInt(scanner.nextLine());
        int remainder7 = Integer.parseInt(scanner.nextLine());
        return (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
    }

    private static void playQuiz(Scanner scanner) {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Is this a Java project?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        while (true) {
            int userInput = Integer.parseInt(scanner.nextLine());
            if (userInput == 1) {
                System.out.println("Congratulations, have a nice day!");
                return;
            }
            System.out.println("Please, try again.");
        }
    }
}
