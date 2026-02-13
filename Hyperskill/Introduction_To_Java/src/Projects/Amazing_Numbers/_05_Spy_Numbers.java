package Projects.Amazing_Numbers;

import java.util.*;
import java.util.stream.Collectors;

public class _05_Spy_Numbers {

/* Description
In this stage, we will add another property that is called a Spy number.
A number is said to be Spy if the sum of all digits is equal to the product of all digits.

Our program calculates the properties of numbers, and also knows how to process a list of numbers.
But what if we want to find numbers that have a certain property? For example, in case we want to find ten Buzz numbers starting from 1000.
We need to add a new request feature for this. In addition, add a new property — Spy numbers. These numbers hide well, so beware.
Your task is to modify the program so that it can search for these numbers.

Objectives
Your program should process the user requests. In this stage, your program should:
    1. Welcome users;
    2. Display the instructions;
    3. Ask for a request;
    4. If a user enters zero, terminate the program;
    5. If numbers are not natural, print an error message;
    6. If a user inputs an incorrect property, print the error message and the list of available properties;
    7. For one number, print the properties of the number;
    8. For two numbers, print the list of numbers with their properties;
    9. For two numbers (x, y) and a property, start at x and print a list of y numbers with their properties, filtered by the indicated property;
    10. Once a request is processed, continue execution from step 3.

The property to search for can be of any case, so make your program case-insensitive in handling it.

In the current stage, the property names include even, odd, buzz, duck, palindromic , gapful, and spy.
The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like.
Please, add the information below:

Instructions:
    Supported requests:
    - enter a natural number to know its properties;
    - enter two natural numbers to obtain the properties of the list:
      * the first parameter represents a starting number;
      * the second parameter shows how many consecutive numbers are to be printed;
    - two natural numbers and a property to search for;
    - separate the parameters with one space;
    - enter 0 to exit.

Error message:
    • The first parameter should be a natural number or zero.
    • The second parameter should be a natural number.
    • The property [SUN] is wrong.
      Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY] */

    private static final String WELCOME_MESSAGE = "Welcome to Amazing Numbers!";
    private static final String FIRST_PARAM_INFO = "The first parameter should be a natural number or zero.";
    private static final String SECOND_PARAM_INFO = "The second parameter should be a natural number.";
    private static final String THIRD_PARAM_ERROR = "The property [%s] is wrong.";

    private static final String INSTRUCTIONS = """
                                Supported requests:
                                - enter a natural number to know its properties;
                                - enter two natural numbers to obtain the properties of the list:
                                  * the first parameter represents a starting number;
                                  * the second parameter shows how many consecutive numbers are to be printed;
                                - two natural numbers and a property to search for;
                                - separate the parameters with one space;
                                - enter 0 to exit.
                            """;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> propertyCatalog = List.of("EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY");
        System.out.println(WELCOME_MESSAGE);
        System.out.println(INSTRUCTIONS);

        while (true) {
            System.out.printf("Enter a request: ");

            String[] input = scanner.nextLine().split("\\s+");

            if (input.length == 0) {
                System.out.println(INSTRUCTIONS);
                System.out.println();
            } else if (input.length == 2) {
                long startNumber = Long.parseLong(input[0]);
                long iterations = Long.parseLong(input[1]);

                if (iterations < 1) {
                    System.out.println(SECOND_PARAM_INFO);
                    continue;
                }

                Map<Long, Map<String, Boolean>> numbers = new LinkedHashMap<>();

                for (long index = startNumber; index < startNumber + iterations; index++) {
                    Map<String, Boolean> numberProperties = getPropertiesForSingleNumber(String.valueOf(index));
                    numbers.put(index, numberProperties);
                }

                printMultipleProperties(numbers);

            } else if (input.length == 3) {
                long startNumber = Long.parseLong(input[0]);
                long requestedNumbers = Long.parseLong(input[1]);
                String filterProperty = input[2];

                if (!propertyCatalog.contains(filterProperty)) {
                    System.out.println(THIRD_PARAM_ERROR.formatted(filterProperty));
                    System.out.println("Available properties: " + propertyCatalog);
                    System.out.println();
                    continue;
                }

                Map<Long, Map<String, Boolean>> numbers = new LinkedHashMap<>();

                while (numbers.size() != requestedNumbers) {
                    if (isNumberByProperty(String.valueOf(startNumber), filterProperty)) {
                        Map<String, Boolean> numberProperties = getPropertiesForSingleNumber(String.valueOf(startNumber));
                        numbers.put(startNumber, numberProperties);
                    }

                    startNumber++;
                }

                printMultipleProperties(numbers);

            } else if ("0".equals(input[0])) {
                System.out.println("Goodbye!");
                System.out.println();
                break;
            } else {
                if (Long.parseLong(input[0]) < 1) {
                    System.out.println();
                    System.out.println(FIRST_PARAM_INFO);
                    System.out.println();
                    continue;
                }

                String userInput = input[0];
                Map<String, Boolean> numberProperties = getPropertiesForSingleNumber(userInput);
                printSingleProperties(userInput, numberProperties);
            }
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

    private static boolean checkIfGapfulNumber(String userInput) {
        if (userInput.length() < 3) {
            return false;
        }

        long number = Long.parseLong(userInput);
        String[] digits = userInput.split("");
        int concatenated = Integer.parseInt(digits[0] + digits[userInput.length() - 1]);
        return number % concatenated == 0;
    }

    private static boolean checkIfSpyNumber(String userInput) {
        long[] digits = Arrays.stream(userInput.split("")).mapToLong(Long::parseLong).toArray();
        long sum = 0;
        long product = 1;

        for (int index = 0; index < digits.length; index++) {
            sum += digits[index];
            product = product * digits[index];
        }

        return sum == product;
    }

    private static Map<String, Boolean> getPropertiesForSingleNumber(String userInput) {
        Map<String, Boolean> numberProperties = new LinkedHashMap<>();
        numberProperties.put("even", Long.parseLong(userInput) % 2 == 0);
        numberProperties.put("odd", Long.parseLong(userInput) % 2 == 1);
        numberProperties.put("buzz", checkIfBuzzNumber(Long.parseLong(userInput)));
        numberProperties.put("duck", checkIfDuckNumber(userInput));
        numberProperties.put("palindromic", checkIfPalindromicNumber(userInput));
        numberProperties.put("gapful", checkIfGapfulNumber(userInput));
        numberProperties.put("spy", checkIfSpyNumber(userInput));
        return numberProperties;
    }

    private static boolean isNumberByProperty(String userInput, String filterProperty) {
        return switch (filterProperty) {
            case "EVEN" -> Long.parseLong(userInput) % 2 == 0;
            case "ODD" -> Long.parseLong(userInput) % 2 == 1;
            case "BUZZ" -> checkIfBuzzNumber(Long.parseLong(userInput));
            case "DUCK" -> checkIfDuckNumber(userInput);
            case "PALINDROMIC" -> checkIfPalindromicNumber(userInput);
            case "GAPFUL" -> checkIfGapfulNumber(userInput);
            case "SPY" -> checkIfSpyNumber(userInput);
            default -> false;
        };
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
