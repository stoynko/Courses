package Projects.Cinema_Room_Manager;

import java.util.Arrays;
import java.util.Scanner;

public class _04_Add_Menu_To_Application {

/*Description
The theatre is getting popular, and the customers started complaining that it's not practical that the program stops after buying one ticket. 
Let's add a menu that will allow them to buy tickets and display the current state of the seating arrangement when needed.

Objectives
At the start, your program should read two positive integer numbers that represent the number of rows and seats in each row. 
Then, it should print a menu with the following three items:

    • Show the seats should print the current seating arrangement. The empty seats should be marked with an S symbol, and taken seats are marked with a B symbol.
    • Buy a ticket should read the seat coordinates from the input and print the ticket price like in the previous stage. 
      After that, the chosen seat should be marked with a B when the item Show the seats is called.
    • Exit should stop the program. */

    public static final String ROW_INPUT_PROMPT = "Enter the number of rows:";
    public static final String ROW_SEATS_INPUT_PROMPT = "Enter the number of seats in each row:";
    public static final String ROW_SELECTION_INPUT_PROMPT = "Enter a row number:";
    public static final String ROW_SEAT_SELECTION_INPUT_PROMPT = "Enter a seat number in that row:";
    public static final int FRONT_ROWS_PRICE = 10;
    public static final int BACK_ROWS_PRICE = 8;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] theater = initTheater(scanner);
        
        displayMenu();
        
        int selection = Integer.parseInt(scanner.nextLine().trim());
        while (selection != 0) {
            switch (selection) {
                case 1 -> displayTheater(theater);
                case 2 -> bookSeat(scanner, theater);
                case 0 -> {
                    return;
                }
            }

            displayMenu();
            selection = Integer.parseInt(scanner.nextLine().trim());
        }
    }

    private static void displayMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
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
        System.out.println();
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
