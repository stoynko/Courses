package Projects.Bulls_And_Cows;

import java.util.List;
import java.util.Scanner;

public class _07_Error {

/*Description
There are many possibilities for errors. What if someone enters an answer of the wrong length?
Or if the number of possible symbols is less than the length of the code? What if the answer contains invalid symbols?
The game may crash before the secret number is guessed!

Let's handle errors like this. At this point, you can implement this without the try-catch construction.
Use the following rule of thumb: if you can avoid exception-based logic, do so! If you use exceptions in normal situations,
how would you deal with unusual (exceptional) situations? Now it may not seem that important,
but when you need to find errors in more complex programs, this makes a difference.

Also, since the secret code is not a number anymore, allow the symbol 0 as the first character in a secret code.

Objectives
In this step, your program should:
    1. Handle incorrect input.
    2. Print an error message that contains the word error.
       After that, don't ask for the numbers again, just finish the program. */

    public static final String SECRET_LENGTH_PROMPT = "Input the length of the secret code:";
    public static final String SECRET_SYMBOLS_PROMPT = "Input the number of possible symbols in the code:";
    public static final String SECRET_GENERATED = "The secret is prepared: %s (%s).";
    public static final String GAME_START = "Okay, let's start a game!";
    public static final String END_GAME = "Congratulations! You guessed the secret code.";
    public static final String TURN_PROMPT = "Turn %d:";
    public static final String SYMBOLS_POOL = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static final String MASK_SYMBOL = "*";
    public static final String ERROR_MIN_LENGTH = "Error: the length of the secret code must be at least 1.";
    public static final String ERROR_MAX_LENGTH = "Error: maximum number of possible symbols in the code is 36 (0-9, a-z).";
    public static final String ERROR_UNIQUE_SYMBOLS = "Error: it's not possible to generate a code with a length of %d with %d unique symbols.";
    public static final String ERROR_INVALID_INPUT = "Error: %s isn't a valid number.";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(SECRET_LENGTH_PROMPT);
        String input = scanner.nextLine();

        if (!input.matches("\\d+")) {
            System.out.println(ERROR_INVALID_INPUT.formatted(input));
            return;
        }
        int codeLength = Integer.parseInt(input);

        if (codeLength < 1) {
            System.out.println(ERROR_MIN_LENGTH);
            return;
        }

        System.out.println(SECRET_SYMBOLS_PROMPT);
        int symbolsRange = Integer.parseInt(scanner.nextLine());

        if (codeLength > symbolsRange) {
            System.out.println(ERROR_UNIQUE_SYMBOLS.formatted(codeLength, symbolsRange));
            return;
        }

        if (symbolsRange > 36) {
            System.out.printf(ERROR_MAX_LENGTH);
            return;
        }

        String secretCode = getRandomSecretNumber(codeLength, symbolsRange);
        String symbolsBound = getSymbolsBound(symbolsRange);

        System.out.println(SECRET_GENERATED.formatted(MASK_SYMBOL.repeat(codeLength), symbolsBound));
        System.out.println(GAME_START);

        int turn = 1;

        while (true) {
            System.out.println(TURN_PROMPT.formatted(turn));
            String userInput = scanner.nextLine();

            int bulls = 0;
            int cows = 0;

            for (int index = 0; index < userInput.length(); index++) {
                char currentChar = userInput.charAt(index);

                for (int k = 0; k < secretCode.length(); k++) {
                    if (currentChar == secretCode.charAt(k) && index == k) {
                        bulls++;
                    } else if (currentChar == secretCode.charAt(k)) {
                        cows++;
                    }
                }
            }

            String bullLabel = bulls > 1 ? "bulls" : "bull";
            String cowLabel = cows > 1 ? "cows" : "cow";

            if (bulls == codeLength) {
                System.out.printf("Grade: %d %s", bulls, bullLabel);
                System.out.println();
                System.out.println(END_GAME);
                return;
            } else if (bulls > 0 && cows > 0) {
                System.out.printf("Grade: %d %s and %d %s", bulls, bullLabel, cows, cowLabel);
                System.out.println();
            } else if (bulls > 0 && cows == 0) {
                System.out.printf("Grade: %d %s", bulls, bullLabel);
                System.out.println();
            } else if (bulls == 0 && cows > 0) {
                System.out.printf("Grade: %d %s", cows, cowLabel);
                System.out.println();
            } else {
                System.out.println("Grade: None.");
            }

            turn++;
        }
    }

    private static String getSymbolsBound(int symbolsRange) {
        if (symbolsRange <= 10) {
            return "0-9";
        }

        char last = (char) ('a' + symbolsRange - 11);
        return "0-9, a-" + last;
    }

    private static String getRandomSecretNumber(int codeLength, int symbolsRange) {
        String pool = SYMBOLS_POOL.substring(0, symbolsRange);

        List<Character> chars = pool.chars().mapToObj(c -> (char) c).toList();
        List<Character> shuffled = new java.util.ArrayList<>(chars);
        java.util.Collections.shuffle(shuffled);

        StringBuilder secretCode = new StringBuilder();
        for (int index = 0; index < codeLength; index++) {
            secretCode.append(shuffled.get(index));
        }

        return secretCode.toString();
    }
}
