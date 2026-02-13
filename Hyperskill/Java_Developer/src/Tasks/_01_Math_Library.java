package Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class _01_Math_Library {

/*You are given two 2D vectors. Find the angle (in degrees) between them.

Input data format:
The first line contains two components of the first vector; the second line contains two components of the second vector. Components in one line are separated by space.

Output data format
One double value: an angle between two vectors. The result can have an error of less than 1e-8. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] vectorA = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] vectorB = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int angle = (int) calculateAngle(vectorA, vectorB);
        System.out.println(angle);
    }

    private static double calculateAngle(int[] vectorA, int[] vectorB) {
        double dotProduct = calculateDotProduct(vectorA, vectorB);
        double magnitudeVectorA = calculateMagnitudes(vectorA);
        double magnitudeVectorB = calculateMagnitudes(vectorB);
        double cosValue = dotProduct / (magnitudeVectorA * magnitudeVectorB);
        double angleRadians = Math.acos(cosValue);

        return Math.toDegrees(angleRadians);
    }

    private static double calculateDotProduct(int[] vectorA, int[] vectorB) {
        return vectorA[0] * vectorB[0] + vectorA[1] * vectorB[1];
    }

    private static double calculateMagnitudes(int[] vector) {
        return Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2));
    }

}
