package Topics;

import java.util.*;

public class _01_Determining_Life_Stage_Based_On_Age {

/* Your task is to write a complete Java program that takes in a single line with an integer between 0-100 (inclusive) as input. This integer represents a person's age.
The program should then print a message that tells the person which life stage they are in based on the following conditions:
    • If the person's age is less than 12 (inclusive), print 'Child'.
    • If the age is between 13 and 17 (both inclusive), print 'Teenager'.
    • If the age is between 18 and 59 (both inclusive), print 'Adult'.
    •  Lastly, if the person's age is 60 (inclusive) or above, print 'Senior Citizen'. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());

        if (age <= 12) {
            System.out.println("Child");
        } else if (age >= 12 && age <= 17) {
            System.out.println("Teenager");
        } else if (age >= 18 && age <= 59) {
            System.out.println("Adult");
        } else {
            System.out.println("Senior Citizen");
        }
    }


}
