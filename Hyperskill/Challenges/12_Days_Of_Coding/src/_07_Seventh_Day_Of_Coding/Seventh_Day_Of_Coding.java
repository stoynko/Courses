package _07_Seventh_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Seventh_Day_Of_Coding {

/* On the seventh day of coding my team lead sent to me... Seven Bridges of Königsberg,

Mr. Frost walks in carrying a historical map. "Have you heard of the Seven Bridges of Königsberg? I
t's one of the most famous problems in mathematics. The city had seven bridges,
and people wondered if you could walk a path crossing each bridge exactly once."

He pulls up a modern map on his screen showing a complex network of land masses connected by 700 bridges.
"We have a similar problem here at the North Pole - our transportation network has grown massive.
I need to know: can our delivery routes cross each bridge exactly once?
And if not, what's the MINIMUM number of times we have to go through a bridge we have already visited to cover all bridges in our network?"

Input format: List of landmasses connected by bridges,
one per line in format LandMass1,LandMass2 (remember that bridges are bidirectional)

Output: The minimum number of additional bridge crossings required (beyond crossing each bridge once).
Or 0 if it's possible to cross each bridge exactly once. */

    public static void main(String[] args) throws IOException {

        List<Object> inputData = getInputData();
        Map<String, Integer> degrees = new HashMap<>();

        for (int index = 0; index < inputData.size(); index++) {

            String[] data = (String[]) inputData.get(index);
            String massA = data[0];
            String massB = data[1];

            degrees.merge(massA, 1, Integer::sum);
            degrees.merge(massB, 1, Integer::sum);

        }

        List<String> oddCount = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : degrees.entrySet()) {
            int degree = entry.getValue();
            if (degree % 2 != 0) {
                oddCount.add(entry.getKey());
            }
        }

        if (oddCount.size() == 0 || oddCount.size() == 2) {
            System.out.println(0);
        }
        else {
            System.out.println((oddCount.size() / 2) - 1);
        }
    }

    public static List<Object> getInputData() throws IOException {
        String[] input = Files.readString(Path.of("_07_Seventh_Day_Of_Coding/resources/hyperskill-dataset-119104624.txt")).split("\n");

        List<Object> inputData = new ArrayList<>();

        for (int index = 0; index < input.length; index++) {
            String[] data = new String[2];

            data[0] = input[index].split(",")[0];
            data[1] = input[index].split(",")[1];

            inputData.add(data);
        }
        return inputData;
    }
}
