package _05_Fifth_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Fifth_Day_Of_Coding {

/*On the fifth day of coding my team lead sent to me... Five-pointed star,

Mr. Frost walks in holding a sheet of graph paper covered in coordinate points.
 "We're decorating the office for the winter festival. I've been designing 5-pointed stars to hang from the ceiling,
 but I need to order the right amount of golden fabric to cover them. Each star is defined by 10 points - 5 outer points
 (the tips) and 5 inner points (where the edges meet). I need you to calculate the total area so I know how much material to buy."

He hands you a file with coordinates.

Input format: 10 lines, each containing a coordinate pair in format x,y (the points alternate between outer (tip) and inner points as you traverse the star's perimeter)
Output: The area of the star, rounded to 2 decimal places*/
    public static void main(String[] args) throws IOException {

        List<Object> coordinates = getInputData();
        double upwardProduct = 0.0;
        double downwardProduct = 0.0;

        for (int index = 0; index < coordinates.size(); index++) {
            double[] currentPoint = (double[]) coordinates.get(index);
            double[] nextPoint = null;
            if (index == coordinates.size() - 1) {
                nextPoint = (double[]) coordinates.get(0);
            } else {
                nextPoint = (double[]) coordinates.get(index + 1);
            }

            downwardProduct += currentPoint[0] * nextPoint[1];
            upwardProduct += currentPoint[1] * nextPoint[0];
        }

        double result = Math.abs(downwardProduct - upwardProduct) / 2;
        System.out.printf("%.2f", result);
    }

    public static List<Object> getInputData() throws IOException {

        String[] input = Files.readString(Path.of("_05_Fifth_Day_Of_Coding/resources/hyperskill-dataset-119064212.txt")).split("\n");
        List<Object> coordinates = new ArrayList<>();

        for (String coordinate : input) {
            double[] pointCoordinates = new double[2];
            pointCoordinates[0] = Double.parseDouble(coordinate.split(",")[0]);
            pointCoordinates[1]= Double.parseDouble(coordinate.split(",")[1]);
            coordinates.add(pointCoordinates);
        }
        return coordinates;
    }
}
