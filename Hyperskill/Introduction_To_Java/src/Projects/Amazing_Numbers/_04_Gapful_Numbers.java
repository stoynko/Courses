package Projects.Amazing_Numbers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_Gapful_Numbers {

/* Description
In this stage, we are going to add one more property — Gapful numbers.
It is a number that contains at least 3 digits and is divisible by the concatenation of its first and last digit without a remainder.
12 is not a Gapful number, as it has only two digits. 132 is a Gapful number, as 132 % 12 == 0.
Another good example of a Gapful number is 7881, as 7881 % 71 == 0.

Until this stage, the program could process only one number at a time.
Now, a user should be able to enter two numbers to obtain the properties of a list of numbers. Separate the numbers with one space.
Space separates the first number in the list and the length of the list. For, example. 100 2 tells the program to process two numbers:
100 and 101. 1 100 means that the program is about to process 100 numbers, starting from 1.
If a user enters one number, the program should work the same as in the previous stages.
The program should analyze a number and print its properties. As before, if a user enters a single 0 (zero), terminate the program.
Information about each number should be printed in one line in the following format:

             140 is even, buzz, duck, gapful
             141 is odd, palindromic

So, the format is {number} is {property}, {property}, ... {property}

Objectives
Your program should process various user requests. In this stage, your program should:
    1. Welcome users;
    2. Display the instructions;
    3. Ask for a request;
    4. If a user enters zero, terminate the program;
    5. If a user enters an empty request, print the instructions;
    6. If numbers are not natural, print an error message;
    7. If one number is entered, calculate and print the properties of this number;
    8. For two numbers, print the list of numbers with properties;
    9. Once the request is processed, continue execution from step 3.

In the current stage, the property names include even, odd, buzz , duck, palindromic and gapful.
The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like.
Please, add the information below:

Instructions:
    Supported requests:
    - enter a natural number to know its properties;
    - enter two natural numbers to obtain the properties of the list:
      * the first parameter represents a starting number;
      * the second parameter shows how many consecutive numbers are to be printed;
    - separate the parameters with one space;
    - enter 0 to exit.

Error message:
    The first parameter should be a natural number or zero.
    The second parameter should be a natural number. */

    private static final String WELCOME_MESSAGE = "Welcome to Amazing Numbers!";
    private static final String FIRST_PARAM_ERROR = "The first parameter should be a natural number or zero.";
    private static final String SECOND_PARAM_ERROR = "The second parameter should be a natural number.";

    private static final String INSTRUCTIONS = """
                            Supported requests:
                            - enter a natural number to know its properties;
                            - enter two natural numbers to obtain the properties of the list:
                              * the first parameter represents a starting number;
                              * the second parameter shows how many consecutive numbers are to be printed;
                            - separate the parameters with one space;
                            - enter 0 to exit.
                            """;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);
        System.out.println(INSTRUCTIONS);

        while (true) {
            System.out.printf("Enter a request: ");

            String[] input = scanner.nextLine().split("\\s+");

            if (input.length == 0) {
                System.out.println(INSTRUCTIONS);
                System.out.println();
            } else if (input.length > 1) {
                long startNumber = Long.parseLong(input[0]);

                long iterations = Long.parseLong(input[1]);
                if (iterations < 1) {
                    System.out.println(SECOND_PARAM_ERROR);
                    continue;
                }

                Map<Long, Map<String, Boolean>> numbers = new LinkedHashMap<>();

                for (long index = startNumber; index < startNumber + iterations; index++) {
                    Map<String, Boolean> numberProperties = getPropertiesForSingleNumber(String.valueOf(index));
                    numbers.put(index, numberProperties);
                }

                printMultipleProperties(numbers);

            } else if ("0".equals(input[0])) {
                break;
            } else {
                if (Long.parseLong(input[0]) < 1) {
                    System.out.println();
                    System.out.println(FIRST_PARAM_ERROR);
                    System.out.println();
                    continue;
                }

                String userInput = input[0];
                Map<String, Boolean> numberProperties = getPropertiesForSingleNumber(userInput);
                printSingleProperties(userInput, numberProperties);
            }
        }
    }

    private static boolean checkIfGapfulNumber(String userInput) {
        if (userInput.length() < 3) {
            return false;
        }

        long number = Long.parseLong(userInput);
        String[] digits = userInput.split("");
        int concatenated = Integer.parseInt(digits[0] + digits[userInput.length() - 1]);
        return number % concatenated == 0;
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

    private static Map<String, Boolean> getPropertiesForSingleNumber(String userInput) {
        Map<String, Boolean> numberProperties = new LinkedHashMap<>();
        numberProperties.put("even", Long.parseLong(userInput) % 2 == 0);
        numberProperties.put("odd", Long.parseLong(userInput) % 2 == 1);
        numberProperties.put("buzz", checkIfBuzzNumber(Long.parseLong(userInput)));
        numberProperties.put("duck", checkIfDuckNumber(userInput));
        numberProperties.put("palindromic", checkIfPalindromicNumber(userInput));
        numberProperties.put("gapful", checkIfGapfulNumber(userInput));
        return numberProperties;
    }

    private static void printSingleProperties(String userInput, Map<String, Boolean> numberResults) {
        System.out.printf("\nProperties of %s\n", userInput);
        numberResults.forEach((key, value) -> {
            System.out.printf("        %s: %s\n", key, value);
        });
        System.out.println();
    }

    private static void printMultipleProperties(Map<Long, Map<String, Boolean>> numbers) {

        Map<Long, Map<String, Boolean>> filtered = numbers.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().entrySet().stream()
                .filter(inner -> Boolean.TRUE.equals(inner.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new)),
                    (a, b) -> a, LinkedHashMap::new));

        filtered.forEach((number, properties) -> {
            System.out.printf("             %d is %s\n", number, String.join(", ", properties.keySet()));
        });
        System.out.println();
    }
}
