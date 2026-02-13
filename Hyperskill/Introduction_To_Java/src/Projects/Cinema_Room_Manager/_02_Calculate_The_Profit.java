package Projects.Cinema_Room_Manager;

import java.util.Scanner;

public class _02_Calculate_The_Profit {

/* Description
Good job: our friends really liked your program! Now they want to expand their theater and add screen rooms with more seats. 
However, this is expensive, so they want to make sure this will pay off. 
Help them calculate the profit from all the sold tickets depending on the number of available seats.

Objectives
In this stage, you need to read two positive integer numbers from the input: the number of rows and the number of seats in each row. 
The ticket price is determined by the following rules:

If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. 
Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the other 5 rows.
Calculate the profit from the sold tickets depending on the number of seats and print the result as shown in the examples below. 
After that, your program should stop. Note that in this project, the number of rows and seats won't be greater than 9. */    
    
    public static final String ROW_INPUT_PROMPT = "Enter the number of rows:";
    public static final String ROW_SEATS_INPUT_PROMPT = "Enter the number of seats in each row:";
    public static final String TOTAL_OUTPUT = "Total income:";
    public static final int FRONT_ROWS_PRICE = 10;
    public static final int BACK_ROWS_PRICE = 8;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println(ROW_INPUT_PROMPT);
        int rows = Integer.parseInt(scanner.nextLine());
        
        System.out.println(ROW_SEATS_INPUT_PROMPT);
        int seats = Integer.parseInt(scanner.nextLine());
        
        int totalIncome = 0;

        if (rows * seats <= 60) {
            totalIncome = FRONT_ROWS_PRICE * (rows * seats);
        } else {
            int frontHalf = rows / 2;
            int secondHalf = rows - frontHalf;
            totalIncome = (frontHalf * seats) * FRONT_ROWS_PRICE  + (secondHalf * seats) * BACK_ROWS_PRICE;
        }
        
        System.out.println(TOTAL_OUTPUT + " $" + totalIncome);
    }
}
