package _06_Sixth_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Sixth_Day_Of_Coding {

/*On the sixth day of coding my team lead sent to me... Six handshakes,

Five-pointed star, four dining elves, three security rules, two pointers, and a nasty bug in a production tree!

Mr. Frost bursts into the office looking excited.
"I've been analyzing our company's internal social network - you know, who knows who at North Pole Technologies.
There's this famous theory called 'six degrees of separation' that says any two sentient beings are connected through at most six steps."
He pulls up a massive network diagram on his screen. "I want to test this theory on our network. Starting from one being,
I need you to find who is the FURTHEST away in terms of connections - the individual at the end of the longest chain of 'friend-of-a-friend'
relationships. If multiple beings are equally far, just give me the first one alphabetically."


Input format: starting being's name on the first line. All other lines contain bidirectional relationships in a format Name1,Name2.
Output: The name of the being who is furthest from the starting one (maximum degrees of separation).
If multiple entities are at the same maximum distance, output the name of the one that comes first alphabetically.*/

    public static void main(String[] args) throws IOException {

        List<Object> inputData = getInputData();

        String start = ((String[]) inputData.get(0))[0];
        Map<String, Set<String>> graph = new HashMap<>();
        graph.putIfAbsent(start, new HashSet<>());

        for (int index = 1; index < inputData.size() - 1; index++) {
            String[] input = (String[]) inputData.get(index);

            graph.putIfAbsent(input[0], new HashSet<>());
            graph.putIfAbsent(input[1], new HashSet<>());

            graph.get(input[0]).add(input[1]);
            graph.get(input[1]).add(input[0]);
        }

        Map<String, Integer> distanceMap = new HashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        distanceMap.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String currentNode = queue.removeFirst();
            int distanceFromRoot = distanceMap.get(currentNode);

            for (String neighbourNode : graph.getOrDefault(currentNode, Collections.emptySet())) {
                if (!distanceMap.containsKey(neighbourNode)) {
                    distanceMap.put(neighbourNode, distanceFromRoot + 1);
                    queue.addLast(neighbourNode);
                }
            }
        }

        String bestNode = getBestNode(distanceMap);
        System.out.println(bestNode);
    }

    private static String getBestNode(Map<String, Integer> distanceMap) {
        int maxDistance = -1;
        String bestNode = null;

        for (Map.Entry<String, Integer> entry : distanceMap.entrySet()) {
            String node = entry.getKey();
            int distance = entry.getValue();

            if (distance > maxDistance) {
                maxDistance = distance;
                bestNode = node;
            } else if (distance == maxDistance) {
                if (bestNode == null || node.compareTo(bestNode) < 0) {
                    bestNode = node;
                }
            }
        }
        return bestNode;
    }

    public static List<Object> getInputData() throws IOException {
        String[] input = Files.readString(Path.of("_06_Sixth_Day_Of_Coding/resources/hyperskill-dataset-119091378.txt")).split("\n");

        List<Object> inputData = new ArrayList<>();

        for (int index = 0; index < input.length; index++) {
            String[] data = new String[2];

            data[0] = input[index].split(",")[0];

            if (index != 0) {
                data[1] = input[index].split(",")[1];
            }
            inputData.add(data);
        }
        return inputData;
    }
}
