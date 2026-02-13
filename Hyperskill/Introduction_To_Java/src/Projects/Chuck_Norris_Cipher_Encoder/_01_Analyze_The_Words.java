package Projects.Chuck_Norris_Cipher_Encoder;

import java.util.Scanner;

public class _01_Analyze_The_Words {

/*Description
In this task, you will practice parsing an encrypted message by dividing it into individual characters.
This skill will be essential for future stages where you will be tasked with decrypting messages.

Objectives
Your program should perform the following steps:

    1. Read Input:
        • Prompt the user with the message: Input string:
        • Read a single line of text from the console.
        • Assume that the input string will contain alphabetic characters, space characters, and punctuation marks.
        • There is no limit on the length of the input string.

    2. Process and Output Characters:
        • Output all characters in the string, each separated by a single space.
        • This includes space characters, which should be represented as they are, without removal or substitution. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            System.out.print(input.charAt(i) + " ");
        }
    }
}
