package Projects.Bulls_And_Cows;

import java.util.Scanner;

public class _02_Grader {

/* Description
Let's add some interactivity to our program. The program should create a 4-digit secret code,
and the player should try to guess it on the first try. The program should give a grade to evaluate how accurate the player was.

As you remember, a correctly guessed digit is a cow, and if its position is also correct, then it is a bull.
After the player tries to guess the secret code, the program should grade the attempt and finish the execution.

For example, if the secret code is 9305, then:
    1. The number 9305 contains 4 bulls and 0 cows since all 4 digits are correct and their positions are correct as well.
       It's the only number that can contain 4 bulls, so it's also the secret code itself.
    2. The numbers 3059, 3590, 5930, 5039 contain 0 bulls and 4 cows since all 4 digits are correct but their positions don't match the positions in the secret code.
    3. The numbers 9306, 9385, 9805, 1305 contain 3 bulls.
    4. The numbers 9350, 9035, 5309, 3905 contain 2 bulls and 2 cows.
    5. The numbers 1293, 5012, 3512, 5129 contain 0 bulls and 2 cows.
    6. The numbers 1246, 7184, 4862, 2718 contain 0 bulls and 0 cows.

Note that guesses can contain repetitive digits, so:
    1. The number 1111 contains 0 bulls and 0 cows.
    2. The number 9999 contains 1 bull and 3 cows.
    3. The number 9955 contains 2 bulls and 2 cows.

Objectives
In this stage, your goal is to write the core part of the game: the grader.

Your program should take a 4-digit number as an input.
    1. Use a predefined 4-digit code and grade the answer that was input. You can do it digit by digit.
    2. The grade is considered correct if it contains number-and-word pairs (like X bulls and Y cows) that give the correct information.
       If the answer doesn't contain any bulls and cows, you should output None.

Example 1
    > 1234
    Grade: 1 cow(s). The secret code is 9305.

Example 2
    > 9087
    Grade: 1 bull(s) and 1 cow(s). The secret code is 9305.

Example 3
    > 1267
    Grade: None. The secret code is 9305. */

    public static final String PREDEFINED_CODE = "9305";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int bulls = 0;
        int cows = 0;

        for (int index = 0; index < input.length(); index++) {

            char currentChar = input.charAt(index);

            for (int k = 0; k < PREDEFINED_CODE.length(); k++) {

                if (currentChar == PREDEFINED_CODE.charAt(k) && index == k) {
                    bulls++;
                } else if (currentChar == PREDEFINED_CODE.charAt(k)) {
                    cows++;
                }
            }
        }

        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", bulls, cows, PREDEFINED_CODE);
        } else if (bulls > 0 && cows == 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %s.", bulls, PREDEFINED_CODE);
        } else if (bulls == 0 && cows > 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s.", cows, PREDEFINED_CODE);
        } else {
            System.out.printf("Grade: None. The secret code is %s.", PREDEFINED_CODE);
        }
    }
}
