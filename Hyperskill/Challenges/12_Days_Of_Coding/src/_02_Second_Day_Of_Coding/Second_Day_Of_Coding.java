package _02_Second_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Second_Day_Of_Coding {

/*On the second day of coding my team lead sent to me... Two pointers
And a nasty bug in a production tree!

Mr. Frost appears at your desk holding two containers with "COCOA" written across them. "Wow it's cold outside today.
Well... Like any day on the North Pole, really. We're preparing some hot beverages.
The problem is, none of them matches the exact same sweetness level that our team likes. Help me out a bit.
I'll email you a list of the sweetness level of each cocoa that we have with a target sweetness we want to achieve.
Pick two cocoa varieties to mix together to get as close to the target as possible, okay?".

Input format:
Line 1: Target sweetness value (integer)
Line 2: Comma-separated integers representing sweetness levels of available cocoa varieties (sorted in ascending order)
Output: The average sweetness level of two cocoa varieties that is closest to the target sweetness. If the result is decimal, round up to the next integer.*/

    public static void main(String[] args) throws IOException {

        String inputData = getInputData();
        int targetValue = getTargetValue(inputData);
        List<Integer> arrayValues = getArrayValues(inputData);

        int pointerA = 0;
        int pointerB = arrayValues.size() - 1;
        int bestSum = arrayValues.get(pointerA) + arrayValues.get(pointerB); // track sum, not avg
        int bestDifference = Math.abs(bestSum - 2 * targetValue);

        while (pointerA < pointerB) {

            int sum = arrayValues.get(pointerA) + arrayValues.get(pointerB);
            int difference = Math.abs(sum - 2 * targetValue);

            if (difference < bestDifference) {
                bestDifference = difference;
                bestSum = sum;
            }

            if (sum == 2 * targetValue) {
                break;
            }
            if (sum < 2 * targetValue) {
                pointerA++;
            } else {
                pointerB--;
            }
        }

        System.out.println((bestSum + 1) / 2);
    }

    public static String getInputData() throws IOException {
        return Files.readString(Path.of("_02_Second_Day_Of_Coding/resources/hyperskill-dataset-118985128.txt"));
    }

    public static int getTargetValue(String inputData) {
        return Integer.parseInt(inputData.split("\n")[0]);
    }

    public static List<Integer> getArrayValues(String inputData) {
        List<Integer> integerArray = new ArrayList<>();
        for (String value : inputData.split("\n")[1].split(",")) {
            integerArray.add(Integer.parseInt(value));
        }
        return integerArray;
    }
}
