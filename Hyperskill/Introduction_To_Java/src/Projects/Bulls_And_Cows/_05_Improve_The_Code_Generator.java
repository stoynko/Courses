package Projects.Bulls_And_Cows;

import java.util.List;
import java.util.Scanner;

public class _05_Improve_The_Code_Generator {

/*Description
The algorithm suggested for generating the secret code in the previous stage was really a “reinvention of the wheel”.
Java already has the tools for generating random numbers! Research some common pseudo-random generation methods,
such as Math.random() and other methods from the Random class. Choose the method you like and use it to rewrite the secret code generation.
To learn more about the Random class, jump to Random topic. If you want to get to know all the intricacies of the Math library,
don't forget to check out the Math library topic as well.

Nothing else is supposed to change at this stage: the program asks for the length, generates a secret code,
and then receives and grades the attempts until the code is guessed. Your task here is to rewrite the code generator without breaking the existing code.

Objectives
In this stage, rewrite the secret code generator using a suitable Java method. */

    public static final String SECRET_LENGTH_PROMPT = "Please, enter the secret code's length:";
    public static final String GAME_START = "Okay, let's start a game!";
    public static final String END_GAME = "Congratulations! You guessed the secret code.";
    public static final String TURN_PROMPT = "Turn %d:";
    public static final String SYMBOLS_POOL = "0123456789";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(SECRET_LENGTH_PROMPT);
        int codeLength = Integer.parseInt(scanner.nextLine());

        if (codeLength > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", codeLength);
            return;
        }

        String secretCode = getRandomSecretNumber(codeLength);

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
                break;
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

    private static String getRandomSecretNumber(int codeLength) {

        List<Character> digits = SYMBOLS_POOL.chars().mapToObj(c -> (char) c).toList();
        List<Character> shuffled = new java.util.ArrayList<>(digits);
        java.util.Collections.shuffle(shuffled);

        if (shuffled.get(0) == '0') {
            for (int index = 1; index < shuffled.size(); index++) {
                if (shuffled.get(index) != '0') {
                    java.util.Collections.swap(shuffled, 0, index);
                    break;
                }
            }
        }

        StringBuilder secret = new StringBuilder(codeLength);
        for (int index = 0; index < codeLength; index++) {
            secret.append(shuffled.get(index));
        }

        return secret.toString();
    }
}

