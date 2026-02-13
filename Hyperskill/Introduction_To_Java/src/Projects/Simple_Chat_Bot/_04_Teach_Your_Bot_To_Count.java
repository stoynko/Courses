package Projects.Simple_Chat_Bot;

import java.util.*;

public class _04_Teach_Your_Bot_To_Count {

/*Description:
Now you will teach your bot to count. It's going to become an expert in numbers!

Objective:
In this stage, you will program the bot to count from 0 to any positive number users enter. */

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

    }

    private static void countToN(Scanner scanner) {
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= num; i++) {
            System.out.println(i + "!");
        }
        System.out.println("Completed, have a nice day!");
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
