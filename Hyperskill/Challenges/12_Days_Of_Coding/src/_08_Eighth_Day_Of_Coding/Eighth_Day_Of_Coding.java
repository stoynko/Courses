package _08_Eighth_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eighth_Day_Of_Coding {

/*On the eighth day of coding my team lead sent to me... Eight queens,

On the lunch break you notice puzzled Mr. Frost, looking at a chessboard.
"Hey, good afternoon! Have not seen you today yet. Happy New Year, by the way!
I tried to organize a first chess tournament of 2026 for nutcrackers,
and one of those nutjobs came claiming that he has found a new previously unseen valid solution to the Eight Queens Problem - you know,
 placing 8 queens on a chessboard so none of them can attack each other. This bothers me a lot."

He sets down a file with coordinates. "I need you to verify this. Count how many pairs of queens are attacking each other.
A valid solution should have zero conflicts - no two queens on the same row, column, or diagonal.
If there are conflicts, I need to know exactly how many pairs are problematic.


Input format: 8 lines, each containing a queen's position as row,col (both 0-7, representing positions on an 8×8 chessboard)
Output: The number of queen pairs that are attacking each other. Output 0 if it's a valid solution (no conflicts).

Rules for queen attacks:

Queens attack along rows (horizontal)
Queens attack along columns (vertical)
Queens attack along diagonals (up-left to down-right and up-right to down-left) */

    public static void main(String[] args) throws IOException {

        List<int[]> coordinates = getInputData();
        String[][] chessboard = initChessboard(coordinates);

        System.out.printf("Conflicts: %d", countConflicts(coordinates));
    }

    private static int countConflicts(List<int[]> coordinates) {
        int conflicts = 0;

        for (int i = 0; i < coordinates.size(); i++) {
            int currentQueenX = coordinates.get(i)[0];
            int currentQueenY = coordinates.get(i)[1];

            for (int nextQueen = i + 1; nextQueen < coordinates.size(); nextQueen++) {
                int nextQueenX = coordinates.get(nextQueen)[0];
                int nextQueenY = coordinates.get(nextQueen)[1];

                if (isAttacking(currentQueenX, currentQueenY, nextQueenX, nextQueenY)) {
                    conflicts++;
                }
            }
        }

        return conflicts;
    }

    private static boolean isAttacking(int currentQueenX, int currentQueenY, int nextQueenX, int nextQueenY) {
        if (currentQueenX == nextQueenX) {
            return true;
        }

        if (currentQueenY == nextQueenY) {
            return true;
        }

        return Math.abs(currentQueenX - nextQueenX) == Math.abs(currentQueenY - nextQueenY);
    }

    public static List<int[]> getInputData() throws IOException {
        String[] input = Files.readString(Path.of("_08_Eighth_Day_Of_Coding/resources/hyperskill-dataset-119134743.txt")).split("\n");

        List<int[]> inputData = new ArrayList<>();

        for (int index = 0; index < input.length; index++) {
            int[] data = new int[2];

            data[0] = Integer.parseInt(input[index].split(",")[0]);
            data[1] = Integer.parseInt(input[index].split(",")[1]);

            inputData.add(data);
        }
        return inputData;
    }

    private static String[][] initChessboard(List<int[]> coordinates) {
        String[][] chessboard = new String[8][8];

        for (int row = 0; row < 8; row++) {
            Arrays.fill(chessboard[row], "_");
        }

        for (int[] coordinate : coordinates) {
            int x = coordinate[0];
            int y = coordinate[1];
            chessboard[x][y] = "Q";
        }

        return chessboard;
    }
}
