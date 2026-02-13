package Projects.Amazing_Numbers;

import java.util.*;
import java.util.stream.Collectors;

public class _06_Sunny_And_Square_Numbers {

/* Description
N is a sunny number if N+1 is a perfect square number. In mathematics, a square number or a perfect square is an integer that is the square of an integer;
in other words, it is the product of an integer with itself. For example, 9 is a square number, since it equals 32 and can be written as 3×3.

Our program can search for Spy and Palindromic numbers. What if we want to find all even Spy numbers?
Or find all odd numbers among Palindromic numbers? Are there any Palindromics that are also Spies?
In this stage, you will add the ability to search for several properties at once!

What if a user enters the same property twice by mistake? For example, they want to find all even numbers that are even?
Just ignore this duplicate property. What about two mutually exclusive properties? For example, if a user wants to find even numbers that are odd.
In this case, the program will initiate the search, but there are no such numbers. We need to make our program foolproof.
If a request contains mutually exclusive properties, the program should abort this request and warn the user.
There are three pairs of mutually exclusive properties. A request cannot include Even and Odd, Duck and Spy, Sunny and Square numbers.

Objectives
Your program should process the user requests. In this stage, your program should:
    1. Welcome users;
    2. Display the instructions;
    3. Ask for a request;
    4. If a user enters zero, terminate the program;
    5. If numbers are not natural, print the error message;
    6. If an incorrect property is specified, print the error message and the list of available properties;
    7. For one number, calculate and print the properties of the number;
    8. For two numbers, print the list of numbers with their properties;
    9. For two numbers and one property, print the numbers with this property only;
    10. For two numbers and two properties, print the numbers that have both properties.
    11. If a user specifies mutually exclusive properties, abort the request and warn a user.
    12. Once a request has been processed, continue execution from step 3.

In the current stage, the property names include even, odd, buzz , duck, palindromic , gapful , spy, square, and sunny.
The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like.
Please, add the information below:

Instructions:
    Supported requests:
    - enter a natural number to know its properties;
    - enter two natural numbers to obtain the properties of the list:
      * the first parameter represents a starting number;
      * the second parameter shows how many consecutive numbers are to be printed;
    - two natural numbers and a property to search for;
    - two natural numbers and two properties to search for;
    - separate the parameters with one space;
    - enter 0 to exit.

Error messages
    • The first parameter should be a natural number or zero.
    • The second parameter should be a natural number.
    • The property [SUN] is wrong.
      Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]
    • The properties [HOT, SUN] are wrong.
      Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]
    • The request contains mutually exclusive properties: [ODD, EVEN]
      There are no numbers with these properties. */

    private static final String WELCOME_MESSAGE = "Welcome to Amazing Numbers!";
    private static final String FIRST_PARAM_ERROR = "The first parameter should be a natural number or zero.";
    private static final String SECOND_PARAM_ERROR = "The second parameter should be a natural number.";
    private static final String THIRD_PARAM_ERROR = "The property [%s] is wrong.";
    private static final String THIRD_FOURTH_PARAM_ERROR = "The property [%s, %s] are wrong.";
    private static final String EXCLUSIVE_PARAM_ERROR = "The request contains mutually exclusive properties: [%s, %s]";
    private static final String NO_NUMBERS = "There are no numbers with these properties.";
    private static final List<String> PROPERTY_CATALOG = List.of("EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY");
    private static final Set<Set<String>> EXCLUSIVE_PROPERTIES = Set.of(
            Set.of("EVEN", "ODD"),
            Set.of("DUCK", "SPY"),
            Set.of("SUNNY", "SQUARE")
    );
    private static final String INSTRUCTIONS = """
                                Supported requests:
                                - enter a natural number to know its properties;
                                - enter two natural numbers to obtain the properties of the list:
                                  * the first parameter represents a starting number;
                                  * the second parameter shows how many consecutive numbers are to be printed;
                                - two natural numbers and a property to search for;
                                - two natural numbers and two properties to search for;
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
            } else if (input.length == 2) {
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

            } else if (input.length == 3) {
                long startNumber = Long.parseLong(input[0]);
                long requestedNumbers = Long.parseLong(input[1]);
                String filterProperty = input[2].toUpperCase();

                if (!PROPERTY_CATALOG.contains(filterProperty)) {
                    System.out.println(THIRD_PARAM_ERROR.formatted(filterProperty));
                    System.out.println("Available properties: " + PROPERTY_CATALOG);
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

            } else if (input.length == 4) {
                long startNumber = Long.parseLong(input[0]);
                long requestedNumbers = Long.parseLong(input[1]);
                String filterPropertyA = input[2].toUpperCase();
                String filterPropertyB = input[3].toUpperCase();

                if (!PROPERTY_CATALOG.contains(filterPropertyA) || !PROPERTY_CATALOG.contains(filterPropertyB)) {
                    System.out.println(THIRD_FOURTH_PARAM_ERROR.formatted(filterPropertyA, filterPropertyB));
                    System.out.println("Available properties: " + PROPERTY_CATALOG);
                    System.out.println();
                    continue;
                }

                boolean isExclusive = EXCLUSIVE_PROPERTIES.stream()
                        .anyMatch(pair -> pair.contains(filterPropertyA) && pair.contains(filterPropertyB));

                if (isExclusive) {
                    System.out.println(EXCLUSIVE_PARAM_ERROR.formatted(filterPropertyA, filterPropertyB));
                    System.out.println(NO_NUMBERS);
                    System.out.println();
                    continue;
                }


                Map<Long, Map<String, Boolean>> numbers = new LinkedHashMap<>();

                while (numbers.size() != requestedNumbers) {
                    if (isNumberByProperty(String.valueOf(startNumber), filterPropertyA) &&
                        isNumberByProperty(String.valueOf(startNumber), filterPropertyB)) {
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

    private static boolean checkIfSunnyNumber(long number) {
        return checkIfSquareNumber(number + 1);
    }

    private static boolean checkIfSquareNumber(long number) {
        long divided = (long) Math.sqrt(number);
        return divided * divided == number;
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
        numberProperties.put("sunny", checkIfSunnyNumber(Long.parseLong(userInput)));
        numberProperties.put("square", checkIfSquareNumber(Long.parseLong(userInput)));
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
            case "SUNNY" -> checkIfSunnyNumber(Long.parseLong(userInput));
            case "SQUARE" -> checkIfSquareNumber(Long.parseLong(userInput));
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
