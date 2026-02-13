package Topics;

import java.util.*;

public class _05_Sports_Class {

/*Suppose there are three boys in a sports class.

You need to write a program that checks if the boys are arranged in ascending or descending order by height.
The program must read three integer numbers h1, h2, h3 and outputs true or false. If boys have the same height,
they are considered as correctly arranged. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();

        if (h1 >= h2 && h2 >= h3) {
            System.out.println(true);
        } else if (h1 <= h2 && h2 <= h3) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
