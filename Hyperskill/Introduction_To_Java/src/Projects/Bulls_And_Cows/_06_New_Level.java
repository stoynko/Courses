package Projects.Bulls_And_Cows;

import java.util.List;
import java.util.Scanner;

public class _06_New_Level {

/*Description
Some players need a challenge, so let's make the secret code in the game harder to guess.
You should add support for more than 10 symbols by including letters too.
Now, the secret code can contain the 10 numbers 0-9 and the 26 lowercase Latin characters a-z.
So, the new maximum length for the secret code is 36.

You should also implement a system where users can select the number of possible symbols that can be used to create the secret code.
So you should request input twice: once for the secret code length and once for the number of possible symbols in it.
Note that the length of the secret code may not match the number of possible symbols in it. Therefore,
it is important to verify that the secret code length is not greater than the number of possible symbols as the integers in secret code have to be unique.

Also, since the secret code is not a number anymore, allow the symbol 0 as the first character in a secret code.

Objectives
In this step, your program should:
    1. Ask for the length of the secret code.
    2. Ask for the range of possible symbols in the secret code.
    3. Generate a secret code using numbers and characters.
       This time, you should also print the secret code using * characters and print which symbols were used to generate the secret code.
    4. Function as a fully playable game.

Example
    Example 1:
        Input the length of the secret code:
        > 4
        Input the number of possible symbols in the code:
        > 16
        The secret is prepared: **** (0-9, a-f).
        Okay, let's start a game!
        Turn 1:
        > 1a34
        Grade: 1 bull and 1 cow
        Turn 2:
        > b354
        Grade: 2 bulls and 1 cow
        Turn 3:
        > 93b4
        Grade: 4 bulls
        Congratulations! You guessed the secret code.

    Example 2:
        Input the length of the secret code:
        > 6
        Input the number of possible symbols in the code:
        > 27
        The secret is prepared: ****** (0-9, a-q).
        Okay, let's start a game!
        Turn 1:
        > gx567e
        Grade: 2 bulls
        Turn 2:
        > gx089f
        Grade: 1 bull and 1 cow
        Turn 3:
        > g530r9
        Grade: 2 bulls
        Turn 4:
        > gyt0n7
        Grade: 2 bulls and 2 cows
        Turn 5:
        > g0n7ed
        Grade: 1 bull and 3 cows
        Turn 6:
        > g7n0op
        Grade: 2 bulls and 4 cows
        Turn 7:
        > gpo07n
        Grade: 6 bulls
        Congratulations! You guessed the secret code. */

    public static final String SECRET_LENGTH_PROMPT = "Input the length of the secret code:";
    public static final String SECRET_SYMBOLS_PROMPT = "Input the number of possible symbols in the code:";
    public static final String SECRET_GENERATED = "The secret is prepared: %s (%s).";
    public static final String GAME_START = "Okay, let's start a game!";
    public static final String END_GAME = "Congratulations! You guessed the secret code.";
    public static final String TURN_PROMPT = "Turn %d:";
    public static final String SYMBOLS_POOL = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static final String MASK_SYMBOL = "*";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(SECRET_LENGTH_PROMPT);
        int codeLength = Integer.parseInt(scanner.nextLine());
        System.out.println(SECRET_SYMBOLS_PROMPT);
        int symbolsRange = Integer.parseInt(scanner.nextLine());

        if (codeLength > symbolsRange || symbolsRange > 36) {
            System.out.println("Error: ");
            return;
        }

        if (codeLength > 36) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", symbolsRange);
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
