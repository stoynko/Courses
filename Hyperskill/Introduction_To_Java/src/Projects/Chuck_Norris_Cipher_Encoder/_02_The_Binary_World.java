package Projects.Chuck_Norris_Cipher_Encoder;

import java.util.Scanner;

public class _02_The_Binary_World {

/*Description
In this stage, you'll learn how to convert each character of a string into a binary form. Any ASCII character has a size of 7 bits; in binary,
the form is 0 and 1. For example, the character A has a decimal value of 65. The binary representation is 1000001.
b is 98 in decimal or 1100010 in binary. The space character is 32 in decimal value or 0100000 in binary.

In this stage, you will learn to represent characters in binary form.

Objectives
In this stage, your program should:
    1. Read a string from a console. The input contains a single line.
    2. Print The result: line, followed by each character of input on a separate line, formatted as <char> = <binary value>.

Note that the binary representation must be 7-bit, even if the first digits are zeros.
The Integer.toBinaryString() and String.format() methods can help you with that. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();

        char[] characters = input.toCharArray();
        System.out.println("The result:");

        for (int i = 0; i < characters.length; i++) {
            String binaryString = Integer.toBinaryString(characters[i]);
            String paddedBinary = String.format("%7s", binaryString).replace(" ", "0");
            System.out.printf("%c = %s\n", characters[i], paddedBinary);
        }
    }
}
