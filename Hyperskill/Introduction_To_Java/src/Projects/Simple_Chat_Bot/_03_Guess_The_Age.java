package Projects.Simple_Chat_Bot;

import java.util.*;

public class _03_Guess_The_Age {

/*Description

Keep improving your bot by developing new skills for it. We suggest a simple guessing game that will predict the age of a user.
It's based on a simple math trick. First, take a look at this formula:
    age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105

The numbers remainder3, remainder5, and remainder7 are the remainders of division by 3, 5 and 7 respectively.
It turns out that for each number ranging from 0 to 104, the calculation will result in the number itself.
This perfectly fits the ordinary age range, doesn't it? Ask the user for the remainders and use them to guess the age!

Objective
In this stage, you will introduce yourself to the bot.
It will greet you by your name and then try to guess your age using arithmetic operations.

Your program should print the following lines:
    Hello! My name is Aid.
    I was created in 2023.
    Please, remind me your name.
    What a great name you have, Max!
    Let me guess your age.
    Enter remainders of dividing your age by 3, 5 and 7.
    Your age is {your_age}; that's a good time to start programming! */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String botName = "Robby";
        int birthYear = java.time.Year.now().getValue();

        greetings(botName, birthYear, scanner);
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int age = guessAge(scanner);
        System.out.printf("Your age is %d; that's a good time to start programming!\n", age);
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
}
