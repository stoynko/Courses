package Projects.Chuck_Norris_Cipher_Encoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_Chuck_Norris_Encrypts_With_Zeroes {

/*Description
Binary with 0 and 1 is good, but binary with only 0 is even better! This encoding has a name — the Chuck Norris Unary Code.
Let's convert our text into a sequence of zeros and spaces!

Objectives
The encoding principle is simple. The input message consists of ASCII characters (7-bit). You need to transform the text into the sequence of 0 and 1 and use the Chuck Norris technique.
The encoded output message consists of blocks of 0. A block is separated from another block by a space.

Two consecutive blocks are used to produce a series of the same value bits (only 1 or 0 values):
    • First block: it is always 0 or 00. If it is 0, then the series contains 1, if not, it contains 0
    • Second block: the number of 0 in this block is the number of bits in the series

Let's take a simple example with a message which consists of only one character C. The C symbol in binary is represented as 1000011, so with Chuck Norris technique this gives:
    • 0 0 (the first series consists of only a single 1);
    • 00 0000 (the second series consists of four 0);
    • 0 00 (the third consists of two 1)
    • So C is coded as: 0 0 00 0000 0 00

Make sure, that an encoding of a single character sequence is not separated. For example, 000 should be encoded as 00 000 and not as 00 0 00 0 00 0 or 00 0 00 00 or 00 00 00 0

In this stage, your program should:
    • Read a string from a console. The input contains a single line.
    • Print The result: line, followed by a line with an encoded message. */

    public static final String ZERO = "0";
    public static final String ONE = "1";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();

        char[] characters = input.toCharArray();
        System.out.println("The result:");

        StringBuilder fullBinary = new StringBuilder();

        for (char c : characters) {
            String binary = Integer.toBinaryString(c & 0x7F);
            fullBinary.append(String.format("%7s", binary).replace(' ', '0'));
        }

        List<String> blocks = getBlocks(fullBinary.toString());
        String result = getProductsFromBlocks(blocks);

        System.out.println(result);

    }

    private static String getProductsFromBlocks(List<String> blocks) {

        StringBuilder product = new StringBuilder();

        for (String block : blocks) {

            if (block.contains(ONE)) {
                product.append(ZERO + " " + ZERO.repeat(block.length()));
            } else {
                product.append(ZERO + ZERO + " " + ZERO.repeat(block.length()));
            }

            product.append(" ");
        }

        return product.toString().trim();
    }

    private static List<String> getBlocks(String paddedBinary) {

        List<String> blocks = new ArrayList<>();
        StringBuilder currentBlock = new StringBuilder();

        for (int index = 0; index < paddedBinary.length(); index++) {
            if (index == 0 || paddedBinary.charAt(index) == paddedBinary.charAt(index - 1)) {
                currentBlock.append(paddedBinary.charAt(index));
            } else {
                blocks.add(currentBlock.toString());
                currentBlock.setLength(0);
                currentBlock.append(paddedBinary.charAt(index));
            }

            if (index + 1 == paddedBinary.length()) {
                blocks.add(currentBlock.toString());
            }
        }

        return blocks;
    }
}