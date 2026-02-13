package Topics;

import java.util.*;

public class _04_Groundhogs_At_Party {

/* Groundhogs like to throw fun parties, and at their parties, they like to eat Reese's peanut butter cups.
But not too many of them, or they feel sick! A successful groundhog party will have between 10 and 20 Reese's peanut butter cups, inclusive,
unless it is the weekend, in which case they will need 15 to 25 Reese's peanut butter cups, inclusive.

Write a Java program that reads two values:
    • the first is the number of Reese's peanut butter cups;
    • the second is a boolean representing whether it is the weekend.

The program must print a boolean value that indicates whether the party was successful. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int cups = Integer.parseInt(input[0]);
        boolean weekend = Boolean.parseBoolean(input[1]);

        if (weekend) {
            System.out.println(cups >= 15 && cups <= 25);
        } else {
            System.out.println(cups >= 10 && cups <= 20);
        }
    }
}
