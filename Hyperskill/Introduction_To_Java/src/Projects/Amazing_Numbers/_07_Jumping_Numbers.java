package Projects.Amazing_Numbers;

import java.util.*;
import java.util.stream.Collectors;

public class _07_Jumping_Numbers {

/* Description
A number is a Jumping number if the adjacent digits inside the number differ by 1. The difference between 9 and 0 is not considered as 1.
Single-digit numbers are considered Jumping numbers. For example, 78987, and 4343456 are Jumping numbers, but 796 and 89098 are not.

In this stage, we will also remove the limitation on pending properties in a request. The program knows how to calculate ten properties of numbers,
and it would be strange to limit the query to just two properties. Let's remove this limitation. Let the program indicate all properties for all numbers in the request.

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
    7. For one number, print the properties of the number;
    8. For two numbers, print the list of numbers with their properties.
    9. For two numbers and properties, print the numbers with the specified properties;
    10. If a user specifies mutually exclusive properties, abort the request and warn the user;
    11. Once a request has been processed, continue execution from step 3.

In the current stage, the property names include even, odd, buzz, duck, palindromic, gapful, spy, square, sunny, and jumping.
The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like.

Instructions:
    Supported requests:
    - enter a natural number to know its properties;
    - enter two natural numbers to obtain the properties of the list:
      * the first parameter represents a starting number;
      * the second parameter shows how many consecutive numbers are to be printed;
    - two natural numbers and properties to search for;
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
    private static final String SINGLE_PARAM_ERROR = "The property %s is wrong.";
    private static final String THIRD_FOURTH_PARAM_ERROR = "The property [%s] are wrong.";
    private static final String MULTIPLE_PARAM_ERROR = "The property %s are wrong.";
    private static final String EXCLUSIVE_PARAM_ERROR = "The request contains mutually exclusive properties: %s";
    private static final String NO_NUMBERS = "There are no numbers with these properties.";
    private static final List<String> PROPERTY_CATALOG = List.of("EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING");
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
            - two natural numbers and properties to search for;
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

            if ("0".equals(input[0])) {
                System.out.println("Goodbye!");
                System.out.println();
                break;
            } else if (Long.parseLong(input[0]) < 1) {
                System.out.println();
                System.out.println(FIRST_PARAM_ERROR);
                System.out.println();
                continue;
            } else if (input.length == 0) {
                System.out.println(INSTRUCTIONS);
                System.out.println();
            } else if (input.length == 1) {
                String digit = input[0];
                Map<String, Boolean> propertiesForSingleNumber = getPropertiesForSingleNumber(digit);
                printSingleProperties(digit, propertiesForSingleNumber);
                continue;
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
                continue;

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
                continue;
            } else {
                long startNumber = Long.parseLong(input[0]);
                long requestedNumbers = Long.parseLong(input[1]);

                List<String> requestedProperties = getFilterProperties(input);
                List<String> wrongProperties = getWrongFilterProperties(requestedProperties);

                if (wrongProperties.size() > 0) {
                    if (wrongProperties.size() == 1) {
                        System.out.println(SINGLE_PARAM_ERROR.formatted(wrongProperties.toString()));
                        System.out.println("Available properties: " + PROPERTY_CATALOG);
                        System.out.println();
                        continue;
                    } else {
                        System.out.println(MULTIPLE_PARAM_ERROR.formatted(wrongProperties.toString()));
                        System.out.println("Available properties: " + PROPERTY_CATALOG);
                        System.out.println();
                        continue;
                    }
                }

                List<String> exclusiveProperties = getExclusiveProperties(requestedProperties);

                if (exclusiveProperties.size() > 0) {
                    System.out.println(EXCLUSIVE_PARAM_ERROR.formatted(exclusiveProperties));
                    System.out.println(NO_NUMBERS);
                    System.out.println();
                    continue;
                }

                Map<Long, Map<String, Boolean>> numbers = new LinkedHashMap<>();

                while (numbers.size() < requestedNumbers) {

                    boolean matchesAll = true;

                    for (String property : requestedProperties) {
                        if (!isNumberByProperty(String.valueOf(startNumber), property)) {
                            matchesAll = false;
                            break;
                        }
                    }

                    if (matchesAll) {
                        numbers.put(
                                startNumber,
                                getPropertiesForSingleNumber(String.valueOf(startNumber))
                        );
                    }

                    startNumber++;
                }

                printMultipleProperties(numbers);
                continue;
            }

            String userInput = input[0];
            Map<String, Boolean> numberProperties = getPropertiesForSingleNumber(userInput);
            printSingleProperties(userInput, numberProperties);
        }
    }

    private static List<String> getExclusiveProperties(List<String> requestedProperties) {

        Set<String> requested = new HashSet<>(requestedProperties);
        List<String> exclusiveProperties = new ArrayList<>();

        for (Set<String> exclusivePropertiesPair : EXCLUSIVE_PROPERTIES) {
            if (requested.containsAll(exclusivePropertiesPair)) {
                exclusiveProperties.addAll(exclusivePropertiesPair);
            }
        }

        return exclusiveProperties;
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

    private static boolean checkIfJumpingNumber(String userInput) {

        String[] digits = userInput.split("");

        if (digits.length == 1) {
            return true;
        }

        for (int index = 0; index < digits.length; index++) {

            if (index + 1 < digits.length) {

                int currentDigit = Integer.parseInt(digits[index]);
                int adjacentDigit = Integer.parseInt(digits[index + 1]);

                if (Math.abs(currentDigit - adjacentDigit) != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static List<String> getFilterProperties(String[] input) {

        List<String> requestedProperties = new ArrayList<>();

        for (int inputIndex = 2; inputIndex < input.length; inputIndex++) {
            String filterProperty = input[inputIndex].toUpperCase();
            requestedProperties.add(filterProperty);
        }

        return requestedProperties;
    }

    private static List<String> getWrongFilterProperties(List<String> requestedProperties) {

        List<String> wrongProperties = new ArrayList<>();

        for (String property : requestedProperties) {
            if (!PROPERTY_CATALOG.contains(property)) {
                wrongProperties.add(property);
            }
        }

        return wrongProperties;
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
        numberProperties.put("jumping", checkIfJumpingNumber(userInput));
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
            case "JUMPING" -> checkIfJumpingNumber(userInput);
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
