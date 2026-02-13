package _10_Tenth_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Tenth_Day_Of_Coding {

/* On the tenth day of coding my team lead sent to me... Ten little drummers,

Mr. Frost walks in carrying sheet music and looking frustrated. "Here you are. We're organizing the winter festival's drumming performance,
and there is a huge problem. We have hired ten little drummers, and each one has practiced their own rhythm pattern - sequences of beats and rests.
They are not synchronised! Imagine what a tragedy it will be, people are gonna laugh, Mrs. Frost won't be happy.
If only they could play at least one little sequence together..."

He spreads out the sheet music. "I need to find the longest contiguous rhythm pattern that appears in ALL ten drummers' sequences.
That's the only part they can all play together without relearning their parts. You will help me, right?"

Input format: 10 lines, each containing a comma-separated sequence of beats (1 = hit, 0 = rest).
Output: The length of the longest contiguous sequence that appears in all 10 drummers' patterns.*/

    public static void main(String[] args) throws IOException {

            List<String> sequences = getInputData();
            String base = sequences.get(0);

            int lowerBound = 0;
            int upperBound = base.length();

            while (lowerBound < upperBound) {
                int mid = (lowerBound + upperBound + 1) / 2;
                if (substringExists(sequences, base, mid)) {
                    lowerBound = mid;
                }

                else upperBound = mid - 1;
            }

            System.out.println(lowerBound);
        }

        static boolean substringExists(List<String> sequences, String base, int currentBestLength){
            if (currentBestLength == 0) {
                return true;
            }

            Set<String> commonSubstrings = new HashSet<>();
            for (int i = 0; i + currentBestLength <= base.length(); i++) {
                commonSubstrings.add(base.substring(i, i + currentBestLength));
            }

            for (int k = 1; k < sequences.size(); k++) {
                String sequence = sequences.get(k);
                Set<String> currentBest = new HashSet<>();

                for (int index = 0; index + currentBestLength <= sequence.length(); index++) {
                    String subSequence = sequence.substring(index, index + currentBestLength);
                    if (commonSubstrings.contains(subSequence)) {
                        currentBest.add(subSequence);
                    }
                }
                commonSubstrings = currentBest;

                if (commonSubstrings.isEmpty()) {
                    return false;
                }
            }
            return true;

        }

    public static List<String> getInputData() throws IOException {
        String[] input = Files.readString(Path.of("_10_Tenth_Day_Of_Coding/resources/hyperskill-dataset-119177180.txt")).split("\n");

        List<String> inputData = new ArrayList<>();

        for (int index = 0; index < input.length; index++) {
            String sequence = input[index].replace(",", "");
            inputData.add(sequence);

        }

        inputData.sort(Comparator.comparingInt(String::length));
        return inputData;
    }
}