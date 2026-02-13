package Projects.Amazing_Numbers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _02_Duck_Numbers {

/* Description
Your next task is to determine whether a number is a Duck number. A Duck number is a positive number that contains zeroes.
For example, 3210, 8050896, 70709 are Duck numbers.

In this stage, we need to simplify the way we display the information.
We already have several properties that we need to show; we are going to add new features to our program in each stage.
From now on, the card should follow this notation:

    Properties of {number}
    {property}: true/false
    {property}: true/false
    ...
    {property}: true/false

In this stage, the properties are even, odd, buzz and duck. For 14, the program output should look like this:

    Properties of 14
        even: true
         odd: false
        buzz: true
        duck: false

Objectives
Your program should print the properties of a natural number. In this stage, your program should:
    1. Ask a user to enter a natural number;
    2. If the number is not natural, the program should print an error message;
    3. If the number is natural, the program should indicate the properties of the number;
    4. Finish the program after printing the message.

Natural numbers are whole numbers starting from 1. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");

        String userInput = scanner.nextLine();
        int userInputDigit = Integer.parseInt(userInput);

        if (userInputDigit < 1) {
            System.out.println("This number is not natural!");
            return;
        }

        Map<String, Boolean> numberResults = new LinkedHashMap<>();

        numberResults.put("even", userInputDigit % 2 == 0);
        numberResults.put("odd", userInputDigit % 2 == 1);
        numberResults.put("buzz", checkIfBuzzNumber(userInputDigit));
        numberResults.put("duck", checkIfDuckNumber(userInput));
        printMessage(userInputDigit, numberResults);
    }

    private static boolean checkIfBuzzNumber(int userInputDigit) {
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

    private static void printMessage(int number, Map<String, Boolean> numberResults) {
        System.out.printf("Properties of %d\n", number);
        numberResults.forEach((key, value) -> {
            System.out.printf("        %s: %s\n", key, value);
        });
    }
}
