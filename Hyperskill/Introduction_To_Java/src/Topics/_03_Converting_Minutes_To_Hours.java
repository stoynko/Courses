package Topics;

import java.util.*;

public class _03_Converting_Minutes_To_Hours {

/*Write a Java program that reads a positive integer from the user, representing a duration in minutes.
The program should calculate and print the equivalent time duration in hours and minutes. If the input is 367 for example,
the output should be '6 hours and 7 minutes'.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        int hours = input / 60;
        int minutes = input % 60;
        System.out.printf("%d hours and %d minutes", hours, minutes);
    }
}
