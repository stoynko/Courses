package Projects.Chuck_Norris_Cipher_Encoder;

import java.util.*;

public class _04_Try_To_Understand_It {

/*Description
In this stage, you will write a decoder for a cipher. You need to transform the encrypted message into its original format.

Objectives
Your program receives a string of zeros and spaces and converts it to readable text. You must parse the string to the blocks of zeroes and decode the message the same way as in previous stages but in reversed order.

For example, your program receives 0 0 00 0000 0 000 00 0000 0 00. You can split blocks of zeros and group those blocks by two. Then you need to decode these blocks like in the previous stage:

    • 0 0 is 1
    • 00 0000 is 0000
    • 0 000 is 111
    • 00 0000 is 0000
    • 0 00 is 11

Concatenation of the lines above gives us 10000111000011.

After that, you need to split the result into blocks of seven symbols (binary form) and convert these blocks to characters. In this case, splitting 10000111000011 by seven symbols gives us two characters — 1000011 1000011 , convert them into characters and the result will be CC (C is 1000011).

In this stage, your program should:
    1. Read a string from a console. The input contains a single line of spaces and 0 characters.
    2. Print The result: line, followed by a line with a decoded message.

The Integer.parseInt() method might be useful at this stage. */

    public static final String ZERO = "0";
    public static final String ONE = "1";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input encoded string:");
        String input = scanner.nextLine();

        String decodedMessage = getDecodedMessage(input);

        System.out.println("The result:");
        System.out.print(decodedMessage);
    }

    private static String getDecodedMessage(String input) {

        List<HashMap<String, String>> listOfPairs = getBlocks(input);
        String fullBinary = getConcatenatedBlocks(listOfPairs);
        List<String> binaryValues = getBinaryValues(fullBinary);

        StringBuilder message = new StringBuilder();

        for (String binary : binaryValues) {
            message.append((char) getDecimalFromBinary(binary));
        }

        return message.toString();
    }

    private static List<String> getBinaryValues(String fullBinary) {
        List<String> values = new ArrayList<>();

        for (int i = 0; i < fullBinary.length(); i += 7) {
            values.add(fullBinary.substring(i, Math.min(i + 7, fullBinary.length())));
        }

        return values;
    }

    private static int getDecimalFromBinary(String binary) {
        int power = 0;
        int decimal = 0;

        for (int index = binary.length() - 1; index >= 0; index--) {
            int bitValue = Integer.parseInt(String.valueOf(binary.charAt(index)));
            decimal += Math.pow(2, power) * bitValue;
            power++;
        }

        return decimal;
    }


    private static String getConcatenatedBlocks(List<HashMap<String, String>> listOfPairs) {

        StringBuilder result = new StringBuilder();

        for (HashMap<String, String> pair : listOfPairs) {
            pair.forEach((key, value) -> {
                if (key.equals(ZERO)) {
                    result.append(ONE.repeat(value.length()));
                } else {
                    result.append(ZERO.repeat(value.length()));
                }
            });
        }

        return result.toString();
    }

    private static List<HashMap<String, String>> getBlocks(String input) {

        List<HashMap<String, String>> listOfPairs = new ArrayList<>();
        String[] blocks = input.split("\\s+");

        for (int index = 0; index < blocks.length; index += 2) {
            HashMap<String, String> map = new LinkedHashMap<>();

            String key = blocks[index];
            String value = blocks[index + 1];
            map.put(key, value);

            listOfPairs.add(map);
        }

        return listOfPairs;
    }
}