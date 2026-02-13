package Projects.Bulls_And_Cows;

import java.util.Scanner;

public class _03_Secret_Code {

/* Description
Using a predefined secret code doesn't make a fun game. Let's implement the ability to generate a pseudo-random secret number of a given length.
If the length is greater than 10, print a warning message and do not generate a number.

We suggest you use the following algorithm to generate the numbers:
    long pseudoRandomNumber = System.nanoTime();

This code saves the nanoseconds elapsed since a certain time to the pseudoRandomNumber variable. We can assume that this is a random number.
You can generate a secret code by iterating over the pseudoRandomNumber in the reverse order and adding unique digits.
If the pseudoRandomNumber lacks the required number of unique digits, call System.nanoTime() again and try to generate the secret code again until you get a satisfactory result.

Objective
In this stage, your program should generate a pseudo-random number of a given length with unique digits and print it.
If the length is greater than 10, the program should print a message containing the word Error.
The secret code may contain any digits from 0 to 9 but only once. The secret code shouldn't start with a digit 0:
for the first digit of the secret code, use digits from 1 to 9.

Example 1
    > 5
    The random secret number is 48379.

Example 2
    > 4
    The random secret number is 5213.

Example 3
    > 11
    Error: can't generate a secret number with a length of 11 because there aren't enough unique digits. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int codeLength = Integer.parseInt(scanner.nextLine());

        if (codeLength > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", codeLength);
            return;
        }

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


        System.out.printf("The random secret number is %s.", secretCode);
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
