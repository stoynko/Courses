package Projects.Amazing_Numbers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_Palindromic_Numbers {

/* Description
In this stage, the program should check whether a number is a Palindromic one. A Palindromic number is symmetrical; in other words,
it stays the same regardless of whether we read it from left or right. For example, 17371 is a palindromic number.
5 is also a palindromic number. 1234 is not. If read it from right, it becomes 4321. Add this new property to our program.

In previous stages, the program could process only one number. From now on, the program should accept a request from a user,
analyze and execute it. The program should print Enter a request instead of asking for a natural number.
The program should also continue execution unless a user enters a terminate command. Let's make it 0 (zero).

Your program should welcome users and print the instructions. At this point, make your program execute two commands.
If a user enters a natural number, the program should indicate the properties of that number.
If a user enters zero, then the program should exit. If a user enters a negative number by mistake, print an error message.

Objectives
In this stage, your program should:
    1. Welcome users;
    2. Display the instructions;
    3. Ask for a request;
    4. Terminate the program if a user enters zero;
    5. If a number is not natural, print an error message;
    6. Print the properties of the natural number;
    7. Continue execution from step 3, after the request has been processed.

The properties are even, odd, buzz, duck and palindromic. The tests won't check the order of properties, indentation, and spaces.
You may format numbers as you like. Please, add the information below:

Instructions:
    Supported requests:
    - enter a natural number to know its properties;
    - enter 0 to exit.

Error message:
    The first parameter should be a natural number or zero. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.\n");

        while (true) {
            System.out.printf("Enter a request: ");

            String userInput = scanner.nextLine();

            if ("0".equals(userInput)) {
                break;
            }

            long userInputDigit = Long.parseLong(userInput);

            if (userInputDigit < 1) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                continue;
            }

            Map<String, Boolean> numberResults = new LinkedHashMap<>();

            numberResults.put("even", userInputDigit % 2 == 0);
            numberResults.put("odd", userInputDigit % 2 == 1);
            numberResults.put("buzz", checkIfBuzzNumber(userInputDigit));
            numberResults.put("duck", checkIfDuckNumber(userInput));
            numberResults.put("palindromic", checkIfPalindromicNumber(userInput));
            printMessage(userInputDigit, numberResults);
        }
    }

    private static boolean checkIfBuzzNumber(long userInputDigit) {
        boolean isDivisibleBySeven = userInputDigit % 7 == 0;
        boolean endsWithSeven = userInputDigit % 10 == 7;
        return isDivisibleBySeven || endsWithSeven;
    }

    private static boolean checkIfDuckNumber(String userInput) {

        String[] digits = userInput.split("");
        for (String digit : digits) {
            int parsedDigit = Integer.parseInt(digit);
            if (parsedDigit == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfPalindromicNumber(String userInput) {

        StringBuilder sb = new StringBuilder(userInput);
        String reversed = sb.reverse().toString();
        return userInput.equals(reversed);
    }

    private static void printMessage(long number, Map<String, Boolean> numberResults) {
        System.out.printf("\nProperties of %d\n", number);
        numberResults.forEach((key, value) -> {
            System.out.printf("        %s: %s\n", key, value);
        });
        System.out.println();
    }
}
