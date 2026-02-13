package Projects.Chuck_Norris_Cipher_Encoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _05_Cooler_Than_Chuck_Norris {

/*Description
Let's finish our encryption-decryption software by adding a simple user interface. T
he program asks the user for the desired option (encode/decode/exit), performs it, and all that in a loop until the user wants to finish.

Objectives
In this stage, your program should:
    1. Ask users what they want to do, encode a string, decode a string or quit the program with
        Please input operation (encode/decode/exit):
    2. If user inputs encode as the desired operation, the program should print Input string:
        to the output, read a line and output two lines — Encoded string: followed by the encoded string;
    3. If user inputs decode as the desired operation, the program should print Input encoded string:
        to the output, read a line and output two lines — Decoded string: followed by the actual decoded string;
    4. If user inputs exit as the desired operation, the program should say Bye! and finish its execution.

The program should be looped to terminate only if the user inputs exit as an operation. Otherwise, it should continue asking users Please input operation (encode/decode/exit): after each iteration.

Also, let's prevent some incorrect input.
    1. If the user misspells the operation name, the program should print out There is no '<input>' operation
    2. If the user provided an incorrect encoded message as input to decode, the program should print out appropriate feedback containing not valid substring

List of not valid encoded messages:
    • The encoded message includes characters other than 0 or spaces;
    • The first block of each sequence is not 0 or 00;
    • The number of blocks is odd;
    • The length of the decoded binary string is not a multiple of 7. */

    public static final String ZERO = "0";
    public static final String ONE = "1";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input operation (encode/decode/exit):");
        String action = scanner.nextLine();

        while (!"exit".equals(action)) {

            switch (action) {
                case "encode" -> {
                    System.out.println("Input string:");
                    String input = scanner.nextLine();
                    String encodedMessage = encode(input);
                    System.out.println("Encoded string:");
                    System.out.println(encodedMessage);
                }
                case "decode" -> {
                    System.out.println("Input encoded string:");
                    String input = scanner.nextLine();

                    if (isInputValid(input)) {
                        String decodedMessage = decode(input);
                        System.out.println("Decoded string:");
                        System.out.println(decodedMessage);
                    } else {
                        System.out.println("Encoded string is not valid.");
                    }
                }
                default -> {
                    System.out.printf("There is no '%s' operation\n", action);
                    System.out.println();
                }
            }

            System.out.println();
            System.out.println("Please input operation (encode/decode/exit):");
            action = scanner.nextLine();
        }

        System.out.println("Bye!");
    }

    private static boolean isInputValid(String input) {

        String[] blocks = input.split("\\s+");

        if (input.matches(".*[^0 ].*")) {
            return false;
        }

        if (blocks.length % 2 != 0) {
            return false;
        }

        for (int index = 0; index < blocks.length; index += 2) {
            if (blocks[index].length() > 2) {
                return false;
            }
        }

        String binaryValue = decodeToBinary(input);

        if (binaryValue.length() % 7 != 0) {
            return false;
        }

        return true;
    }

    private static String encode(String input) {

        char[] characters = input.toCharArray();

        StringBuilder product = new StringBuilder();
        StringBuilder fullBinary = new StringBuilder();

        for (char c : characters) {
            String binary = Integer.toBinaryString(c & 0x7F);
            fullBinary.append(String.format("%7s", binary).replace(' ', '0'));
        }
        List<String> blocks = getBlocks(fullBinary.toString());

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

    private static String decode(String input) {
        String binary = decodeToBinary(input);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < binary.length(); i += 7) {
            String chunk = binary.substring(i, i + 7);
            int value = Integer.parseInt(chunk, 2);

            result.append((char) value);
        }

        return result.toString();
    }

    private static String decodeToBinary(String input) {
        String[] blocks = input.split("\\s+");
        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < blocks.length; i += 2) {
            String prefix = blocks[i];
            int count = blocks[i + 1].length();

            String bit = prefix.equals(ZERO) ? ONE : ZERO;
            binary.append(bit.repeat(count));
        }

        return binary.toString();
    }
}
