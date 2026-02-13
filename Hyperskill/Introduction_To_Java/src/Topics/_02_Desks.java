package Topics;

import java.util.*;

public class _02_Desks {

/* A university has decided to open math courses and equip classrooms for 3 groups with new special desks.
The faculty agreed that for the sake of productivity, only two students may share one desk.
The enrollment has ended and the university knows how many students are in each group.
Now the task is to count the number of desks. Of course, the university is short of money,
so you need to calculate the minimum number of desks required for each group.
But don’t forget that each group will sit in its own classroom!

Input data format:
    • The program receives the input of three non-negative integers: the number of students in each of the three groups (the numbers are not bigger than 1000). */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int desksNeeded = 0;
        for (int i = 0; i < 3; i++) {
            int input = Integer.parseInt(scanner.nextLine());

            if (input % 2 != 0) {
                desksNeeded += input / 2 + (input % 2);
            } else {
                desksNeeded += input / 2;
            }
        }

        System.out.println(desksNeeded);
    }
}
