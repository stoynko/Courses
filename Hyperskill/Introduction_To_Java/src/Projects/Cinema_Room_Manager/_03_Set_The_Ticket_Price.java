package Projects.Cinema_Room_Manager;

import java.util.Arrays;
import java.util.Scanner;

public class _03_Set_The_Ticket_Price {

/*Description
When choosing a ticket you are guided not only by your space preference but also by your finances. 
Let's implement the opportunity to check the ticket price and see the reserved seat. 

Objectives
Read two positive integer numbers that represent the number of rows and seats in each row and print the seating arrangement like in the first stage. 
Then, read two integer numbers from the input: a row number and a seat number in that row. 
These numbers represent the coordinates of the seat according to which the program should print the ticket price. 
The ticket price is determined by the same rules as the previous stage:

If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. 
Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the last 5 rows.
After that, the program should print out all the seats in the screen room as shown in the example and mark the chosen seat by the B symbol. 
Finally, it should print the ticket price and stop. Note that in this project, the number of rows and seats won't be greater than 9. */

    public static final String ROW_INPUT_PROMPT = "Enter the number of rows:";
    public static final String ROW_SEATS_INPUT_PROMPT = "Enter the number of seats in each row:";
    public static final String ROW_SELECTION_INPUT_PROMPT = "Enter a row number:";
    public static final String ROW_SEAT_SELECTION_INPUT_PROMPT = "Enter a seat number in that row:";
    public static final int FRONT_ROWS_PRICE = 10;
    public static final int BACK_ROWS_PRICE = 8;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] theater = initTheater(scanner);
        displayTheater(theater);
        bookSeat(scanner, theater);
        displayTheater(theater);
    }
    
    private static void bookSeat(Scanner scanner, char[][] theater) {
        System.out.println(ROW_SELECTION_INPUT_PROMPT);
        int row = Integer.parseInt(scanner.nextLine().trim());

        System.out.println(ROW_SEAT_SELECTION_INPUT_PROMPT);
        int seat = Integer.parseInt(scanner.nextLine().trim());
        
        theater[row - 1][seat - 1] = 'B';
        int ticketPrice = getTicketPrice(row, theater);
        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();
    }
    
    private static int getTicketPrice(int row, char [][] theater) {
        int ticketPrice = 0;
        
        if (theater.length * theater[0].length <= 60) {
            ticketPrice = FRONT_ROWS_PRICE;
        } else {
            int frontHalf = theater.length / 2;
            if (row > frontHalf) {
                ticketPrice = BACK_ROWS_PRICE;
            } else {
                ticketPrice = FRONT_ROWS_PRICE;
            }
        }
        
        return ticketPrice;
    }
    
    private static void displayTheater(char[][] theater) {
        System.out.println("Cinema:");
        System.out.print("  ");
        
        for (int seatIndex = 1; seatIndex <= theater[0].length; seatIndex++) {
            System.out.print(seatIndex + " ");
        }
        System.out.println();
        
        for (int row = 0; row < theater.length ; row++) {
                System.out.print(row + 1 + " ");
            
            for (int seatingIndex = 0; seatingIndex < theater[0].length; seatingIndex++) {
                    System.out.print(theater[row][seatingIndex] + " ");
                }
            System.out.println();
        }
        
        System.out.println();

    }

    private static char[][] initTheater(Scanner scanner) {
        System.out.println(ROW_INPUT_PROMPT);
        int rows = Integer.parseInt(scanner.nextLine());

        System.out.println(ROW_SEATS_INPUT_PROMPT);
        int seats = Integer.parseInt(scanner.nextLine());
        char[][] theater = new char[rows][seats];
        
        for (char[] chars : theater) {
            Arrays.fill(chars, 'S');
        }
        
        return theater;
    }
}
