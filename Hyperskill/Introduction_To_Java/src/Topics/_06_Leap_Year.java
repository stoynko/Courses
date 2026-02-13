package Topics;

import java.util.*;

public class _06_Leap_Year {

/*F ind whether a given year is a leap year.
Just a reminder: a leap year is divisible by 4 AND NOT divisible by 100 OR divisible by 400 (for example, the year 2000 is a leap year,
but the year 2100 will not be a leap year). The program should work correctly for the years 1900 ≤ n ≤ 3000.
Output "Leap" (case-sensitive) if the given year is a leap year, and "Regular" otherwise. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.nextLine());

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("Leap");
        } else {
            System.out.println("Regular");
        }
    }
}
