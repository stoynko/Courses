package Projects.Bulls_And_Cows;

import java.util.Scanner;

public class _04_Game_Time {

/*Description
In this stage, you should combine all the previous parts into a simple playable version of the "Bulls and Cows" game.
First, prompt the player to input the length of the secret code. The length will determine the difficulty level for the current game session.
The program should generate a secret code of the given length. Remember that it should consist of unique numbers.

Then, the game starts and the program prompts the player to guess the code. When the player inputs a number,
the program should grade it in bulls and cows. The game goes on until the code is guessed, that is,
until the number of bulls is equal to the number of digits in the code. When the game ends, the program should finish its execution.

Objectives
In this stage, your program should:
    1. Ask for the length of the secret code and then generate the code.
    2. Wait for the user input.
    3. Grade the guessing attempt in bulls and cows.
    4. If the secret code has been guessed, the program stops; otherwise, return to the second step. */

    public static final String SECRET_LENGTH_PROMPT = "Please, enter the secret code's length:";
    public static final String END_GAME = "Congratulations! You guessed the secret code.";
    public static final String TURN_PROMPT = "Turn %d:";


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

            if (bulls == secretCode.length()) {
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

        String secretCode = "";
        String randomNumber = String.valueOf(System.nanoTime());

        int index = randomNumber.length() - 1;

        while (secretCode.length() < codeLength) {

            char currentChar = randomNumber.charAt(index);

            if (!secretCodeContains(secretCode, currentChar)) {

                if (secretCode.isEmpty() && currentChar == '0') {
                    index--;
                    continue;
                }

                secretCode += currentChar;
            }

            if (index == 0) {
                randomNumber = String.valueOf(System.nanoTime());
                index = randomNumber.length() - 1;
            }

            index--;
        }

        return secretCode;
    }

    private static boolean secretCodeContains(String secretCode, char candidate) {

        for (int index = 0; index < secretCode.length(); index++) {

            char currentChar = secretCode.charAt(index);

            if (currentChar == candidate) {
                return true;
            }
        }
        return false;
    }
}