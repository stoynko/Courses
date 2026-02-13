package _09_Ninth_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Ninth_Day_Of_Coding {

/* On the ninth day of coding my team lead sent to me... Nine cat lives,

Mr. Frost rushes in looking worried. "We have a situation.
One of our delivery cats needs to cross the warehouse district to deliver an urgent package.
The district is a 20×20 grid, and each cell has a hazard level from 0 to 3.
Every time the cat passes through a cell, it loses lives equal to that cell's hazard level."

He pulls up a map. "The cat starts at the top-left corner and needs to reach the bottom-right corner.
It can move up, down, left, or right - one cell at a time. The cat has 9 lives total.
Find the safest path - the one that costs the fewest lives."

Input format: 20 lines, each containing 20 comma-separated numbers (0-3) representing hazard levels
Output: The minimum number of lives lost on the optimal path from top-left (0,0) to bottom-right (19,19) */

    public static void main(String[] args) throws IOException {

        int[][] warehouse = initWarehouse(getInputData());
        System.out.printf("Lives lost: %d", getMinimumLivesLost(warehouse));
    }

    private static int getMinimumLivesLost(int[][] warehouse) {
        int rows = warehouse.length;
        int columns = warehouse[0].length;

        int[][] distance = new int[rows][columns];

        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            Arrays.fill(distance[rowIndex], Integer.MAX_VALUE);
        }

        distance[0][0] = warehouse[0][0];

        PriorityQueue<State> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        priorityQueue.add(new State(0, 0, distance[0][0]));

        int[] rowDelta = {-1, 1, 0, 0};
        int[] columnDelta = {0, 0, -1, 1};

        while (!priorityQueue.isEmpty()) {
            State current = priorityQueue.poll();

            if (current.cost != distance[current.row][current.column]) {
                continue;
            }

            if (current.row == rows - 1 && current.column == columns - 1) {
                return current.cost;
            }

            for (int i = 0; i < 4; i++) {
                int neighbourRow = current.row + rowDelta[i];
                int neighbourColumn = current.column + columnDelta[i];

                if (neighbourRow < 0 || neighbourRow >= rows ||
                        neighbourColumn < 0 || neighbourColumn >= columns) {
                    continue;
                }

                int newCost = current.cost + warehouse[neighbourRow][neighbourColumn];

                if (newCost < distance[neighbourRow][neighbourColumn]) {
                    distance[neighbourRow][neighbourColumn] = newCost;
                    priorityQueue.add(new State(neighbourRow, neighbourColumn, newCost));
                }
            }
        }

        return distance[rows - 1][columns - 1];
    }

    private static class State {
        int row, column, cost;

        State(int row, int column, int cost) {
            this.row = row;
            this.column = column;
            this.cost = cost;
        }
    }

    private static int[][] initWarehouse(List<int[]> coordinates) {
        int[][] warehouse = new int[coordinates.size()][coordinates.size()];

        for (int index = 0; index < warehouse.length; index++) {
            warehouse[index] = coordinates.get(index);
        }

        return warehouse;
    }

    public static List<int[]> getInputData() throws IOException {
        String[] input = Files.readString(Path.of("_09_Ninth_Day_Of_Coding/resources/hyperskill-dataset-119149476.txt")).split("\n");

        List<int[]> inputData = new ArrayList<>();

        for (String row : input) {
            int[] rowData = Arrays.stream(row.split(",")).mapToInt(Integer::parseInt).toArray();
            inputData.add(rowData);
        }

        return inputData;
    }
}
