package Projects.Cinema_Room_Manager;

import java.util.Arrays;
import java.util.Scanner;

public class _05_Manage_Stats_And_Errors {

/*Description
Running a cinema theatre is no easy business. To help our friends, let's add statistics to your program. 
The stats will show the current income, total income, the number of available seats, and the percentage of occupancy.

In addition, our friends asked you to take care of a small inconvenience: it's not good when a user can buy a ticket that has already been purchased by another user. Let's fix this!

Objectives

Now your menu should look like this:
    1. Show the seats
    2. Buy a ticket
    3. Statistics
    0. Exit

When the item Statistics is chosen, your program should print the following information:
    • The number of purchased tickets;
    • The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
    • Current income;
    •  total income that shows how much money the theatre will get if all the tickets are sold.

The rest of the menu items should work the same way as before, except the item Buy a ticket shouldn't allow a user to buy a ticket that has already been purchased.
If a user chooses an already taken seat, print That ticket has already been purchased! and ask them to enter different seat coordinates until they pick an available seat. 
Of course, you shouldn't allow coordinates that are out of bounds. 
If this happens, print Wrong input! and ask to enter different seat coordinates until the user picks an available seat. */

    public static final String ROW_INPUT_PROMPT = "Enter the number of rows:";
    public static final String ROW_SEATS_INPUT_PROMPT = "Enter the number of seats in each row:";
    public static final String ROW_SELECTION_INPUT_PROMPT = "Enter a row number:";
    public static final String ROW_SEAT_SELECTION_INPUT_PROMPT = "Enter a seat number in that row:";
    public static final String TOTAL_OUTPUT = "Total income: $";
    public static final String TICKET_BOOKED = "That ticket has already been purchased!";
    public static final int FRONT_ROWS_PRICE = 10;
    public static final int BACK_ROWS_PRICE = 8;
    public static int TOTAL_INCOME = 0;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] theater = initTheater(scanner);
        
        displayMenu();
        
        int selection = Integer.parseInt(scanner.nextLine().trim());
        while (selection != 0) {
            switch (selection) {
                case 1 -> displayTheater(theater);
                case 2 -> bookSeat(scanner, theater);
                case 3 -> getStatistics(theater);
                case 0 -> {
                    return;
                }
            }

            displayMenu();
            selection = Integer.parseInt(scanner.nextLine().trim());
        }
    }

    private static void getStatistics(char[][] theater) {
        int totalSeats = theater.length * theater[0].length;
        
        int purchasedTickets = getTotalPurchasedTickets(theater);
        double purchasedPercentage = purchasedTickets * 100.0 / totalSeats;
        int getTotalIncome = getTotalIncome(theater);

        System.out.println();
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%% \n", purchasedPercentage);
        System.out.printf("Current income: $%d\n", TOTAL_INCOME);
        System.out.println(TOTAL_OUTPUT + getTotalIncome);
        System.out.println();
    }
    
    private static int getTotalIncome(char[][] theater) {
        
        int rows =  theater.length;
        int seats =  theater[0].length;
        
        if (rows *  seats <= 60) {
            return rows * seats * FRONT_ROWS_PRICE;
        }

        int numFrontRows = rows / 2;
        int numBackRows =  rows - numFrontRows;

        int seatsInFrontRow = numFrontRows * seats;
        int seatsInBackRow = numBackRows * seats;
        
        return (seatsInFrontRow * FRONT_ROWS_PRICE) + (seatsInBackRow * BACK_ROWS_PRICE);
    }

    private static int getTotalPurchasedTickets(char[][] theater) {
        int count = 0;

        for (int row = 0; row < theater.length; row++) {
            for (int column = 0; column < theater[0].length; column++) {
                if (theater[row][column] == 'B') {
                   count++;
                }
            }
        }
        
        return count;
    }

    private static void displayMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    private static void bookSeat(Scanner scanner, char[][] theater) {
        boolean ticketBooked = false;
        
        do {
            System.out.println();
            System.out.println(ROW_SELECTION_INPUT_PROMPT);
            int row = Integer.parseInt(scanner.nextLine().trim()) - 1;

            System.out.println(ROW_SEAT_SELECTION_INPUT_PROMPT);
            int seat = Integer.parseInt(scanner.nextLine().trim()) - 1;

            if (row <0 || row >= theater.length ||  seat < 0 || seat >= theater[0].length) {
                System.out.println("Wrong input!");
                continue;
            }
            
            if (theater[row][seat] == 'S') {
                theater[row][seat] = 'B';
                int ticketPrice = getTicketPrice(row, theater);
                TOTAL_INCOME +=  ticketPrice;
                System.out.println();
                System.out.println("Ticket price: $" + ticketPrice);
                System.out.println();
                break;
            } else {
                System.out.println();
                System.out.println(TICKET_BOOKED);
                continue;
            }
        } while (!ticketBooked);
    }
    
    private static int getTicketPrice(int row, char [][] theater) {
        
        int rows = theater.length;
        int seats = theater[0].length;
        int ticketPrice = 0;
        
        if (rows * seats <= 60) {
            ticketPrice = FRONT_ROWS_PRICE;
        } else {
            int frontHalf = rows / 2;
            if (row >= frontHalf) {
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
