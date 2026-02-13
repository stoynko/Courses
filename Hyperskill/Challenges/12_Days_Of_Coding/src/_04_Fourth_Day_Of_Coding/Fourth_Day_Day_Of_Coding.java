package _04_Fourth_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Fourth_Day_Day_Of_Coding {

/*On the fourth day of coding my team lead sent to me... Four dining elves,

Mr. Frost looks exhausted. "We have a situation in the cafeteria.
Four elves - Jingle, Sparkle, Tinsel, and Holly - are sitting around a circular table trying to eat lunch.
There are four forks on the table, one between each pair of elves.
Each elf needs TWO forks to eat (the one on their left AND the one on their right)."

He pulls up a log on his screen. "The problem is, they keep trying to grab forks that other elves are already using.
Every time an elf attempts to pick up a fork that's currently held by someone else,
it causes a 'contention' - they have to wait, complain, and it slows everything down."

"I need you to analyze this log and count how many contentions occurred during lunch.
Help me figure out how bad the problem really is."

Input: logs of actions separated by newline.
Each log contains name of the elf, action (pick or release) and an id of a fork, all separated by comma.
Example: Jingle,pick,3
Output: Total number of contentions (attempts to pick up a fork that's already held by another elf).

Order of elves and forks around the table:

Jingle - Fork_1 - Sparkle - Fork_2 - Tinsel - Fork_3 - Holly - Fork_4 - (back to) Jingle */

    public static void main(String[] args) throws IOException {

        String[] inputData = getInputData();
        int contentions = 0;

        boolean[] forkAvailability = getForkAvailability();

        for (String inputLine : inputData) {
            String[] data = inputLine.split(",");

            String command = data[1];
            int forkIndex = Integer.parseInt(data[2]) - 1;

            if ("pick".equals(data[1]) && (forkAvailability[forkIndex] == true)) {
                forkAvailability[forkIndex] = false;
            } else if ("pick".equals(data[1]) && forkAvailability[forkIndex] == false) {
                contentions++;
            } else {
                forkAvailability[forkIndex] = true;
            }
        }
        System.out.println(contentions);
    }

    public static String[] getInputData() throws IOException {
        return Files.readString(Path.of("_04_Fourth_Day_Of_Coding/resource/hyperskill-dataset-119031395.txt")).split("\n");
    }

    public static boolean[] getForkAvailability() {
        boolean[] forkAvailability = new boolean[4];
        Arrays.fill(forkAvailability, true);
        return forkAvailability;
    }
}
