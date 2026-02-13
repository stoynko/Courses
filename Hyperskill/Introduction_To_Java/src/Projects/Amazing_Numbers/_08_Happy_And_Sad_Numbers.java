package Projects.Amazing_Numbers;

import java.util.*;
import java.util.stream.Collectors;

public class _08_Happy_And_Sad_Numbers {

/* Description
In number theory, a happy number is a number that reaches 1 after a sequence during which the number is replaced by the sum of each digit squares.
For example, 13 is a happy number, as 12 + 32 = 10 which leads to 12 + 02 = 1. On the other hand,
4 is not a happy number because the sequence starts with 42 = 16, 12 + 62 = 37, and finally reaches 22 + 02 = 4.
This is the number that started the sequence, so the process goes on in an infinite cycle.
A number that is not happy is called Sad (or Unhappy).

Our program is finished. It can indicate many interesting properties of numbers, it knows how to calculate them.
Now, when prompted, a user can have a list of number properties. To complete the program,
let's add an ability to exclude a property from the search query. If a user puts a minus (-) before the property,
exclude this property from the search query. For example, if a user specifies palindromic -duck,
it means that they are looking for Palindromic numbers that are not Ducks.

Objectives
Your program should process the user requests. In this stage, your program should:
    1. Welcome users;
    2. Display the instructions;
    3. Ask for a request;
    4. If a user enters an empty request, print the instructions;
    5. If the user enters zero, terminate the program;
    6. If numbers are not natural, print the error message;
    7. If an incorrect property is specified, print the error message and the list of available properties;
    8. For one number, print the properties of the number;
    9. For two numbers, print the properties of all numbers in the list;
    10. For two numbers and two properties, print the list of numbers that contain the specified properties;
    11. If a property is preceded by a minus, this property should not be present in a number;
    12. If the user specifies mutually exclusive properties, abort the request and warn the user.
    13. Once the request is processed, continue execution from step 3.

In this stage, property names include even, odd, buzz, duck, palindromic, gapful, spy, sunny, square, jumping, sad, and happy.
Mutually exclusive properties are even/odd, duck/spy, sunny/square, sad/happy pairs, as well as direct opposites (property and -property).
The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like.

Instructions:
    Supported requests:
    - enter a natural number to know its properties;
    - enter two natural numbers to obtain the properties of the list:
      * the first parameter represents a starting number;
      * the second parameter shows how many consecutive numbers are to be printed;
    - two natural numbers and properties to search for;
    - a property preceded by minus must not be present in numbers;
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
    private static final String SINGLE_PARAM_ERROR = "The property %s is wrong.";
    private static final String MULTIPLE_PARAM_ERROR = "The property %s are wrong.";
    private static final String EXCLUSIVE_PARAM_ERROR = "The request contains mutually exclusive properties: %s";
    private static final String NO_NUMBERS = "There are no numbers with these properties.";
    private static final List<String> PROPERTY_CATALOG = List.of("EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL",
            "SPY", "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD");

    private static final String INSTRUCTIONS = """
            Supported requests:
            - enter a natural number to know its properties;
            - enter two natural numbers to obtain the properties of the list:
              * the first parameter represents a starting number;
              * the second parameter shows how many consecutive numbers are to be printed;
            - two natural numbers and properties to search for;
            - a property preceded by minus must not be present in numbers;
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

            } else {
                long startNumber = Long.parseLong(input[0]);
                long requestedNumbers = Long.parseLong(input[1]);

                List<String> inputProperties = getFilterProperties(input);

                List<String> wrongProperties = getWrongFilterProperties(inputProperties);

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

                List<String> exclusiveProperties = getExclusiveProperties(inputProperties);

                if (exclusiveProperties.size() > 0) {
                    System.out.println(EXCLUSIVE_PARAM_ERROR.formatted(exclusiveProperties));
                    System.out.println(NO_NUMBERS);
                    System.out.println();
                    continue;
                }

                List<String> requestedProperties = inputProperties.stream()
                        .filter(property -> !property.startsWith("-")).collect(Collectors.toList());

                List<String> excludedProperties = inputProperties.stream()
                        .filter(property -> property.startsWith("-"))
                        .map(property -> property.substring(1))
                        .collect(Collectors.toList());

                Map<Long, Map<String, Boolean>> numbers = new LinkedHashMap<>();

                while (numbers.size() < requestedNumbers) {

                    boolean matchesAll = true;

                    for (String property : requestedProperties) {
                        if (!isNumberByProperty(String.valueOf(startNumber), property)) {
                            matchesAll = false;
                            break;
                        }
                    }

                    for (String property : excludedProperties) {
                        if (isNumberByProperty(String.valueOf(startNumber), property)) {
                            matchesAll = false;
                            break;
                        }
                    }

                    if (matchesAll) {
                        numbers.put(startNumber, getPropertiesForSingleNumber(String.valueOf(startNumber)));
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

    private static List<String> getExclusiveProperties(List<String> inputProperties) {

        Set<String> properties = new HashSet<>(inputProperties);

        for (String property : properties) {
            if (property.startsWith("-") && properties.contains(property.substring(1))) {
                return List.of(property, property.substring(1));
            }
            if (!property.startsWith("-") && properties.contains("-" + property)) {
                return List.of(property, "-" + property);
            }
        }

        if (properties.contains("EVEN") && properties.contains("ODD")) {
            return List.of("EVEN", "ODD");

        }
        if (properties.contains("DUCK") && properties.contains("SPY")) {
            return List.of("DUCK", "SPY");
        }

        if (properties.contains("SUNNY") && properties.contains("SQUARE")) {
            return List.of("SUNNY", "SQUARE");
        }

        if (properties.contains("HAPPY") && properties.contains("SAD")) {
            return List.of("HAPPY", "SAD");
        }

        if (properties.contains("-EVEN") && properties.contains("-ODD")) {
            return List.of("-EVEN", "-ODD");
        }

        if (properties.contains("-HAPPY") && properties.contains("-SAD")) {
            return List.of("-HAPPY", "-SAD");
        }

        return List.of();
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

    private static boolean checkIfHappyNumber(String userInput) {
        Long number = Long.parseLong(userInput);
        Set<Long> processedNumbers = new HashSet<>();

        while (number != 1 && !processedNumbers.contains(number)) {
            processedNumbers.add(number);
            long sum = 0;
            while (number > 0) {
                long d = number % 10;
                sum += d * d;
                number /= 10;
            }
            number = sum;
        }
        return number == 1;
    }

    private static boolean checkIfSadNumber(String userInput) {
        return !checkIfHappyNumber(userInput);
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

            String normalizedProperty = property.startsWith("-") ? property.substring(1) : property;
            if (!PROPERTY_CATALOG.contains(normalizedProperty)) {
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
        numberProperties.put("happy", checkIfHappyNumber(userInput));
        numberProperties.put("sad", checkIfSadNumber(userInput));
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
            case "HAPPY" -> checkIfHappyNumber(userInput);
            case "SAD" -> checkIfSadNumber(userInput);
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
