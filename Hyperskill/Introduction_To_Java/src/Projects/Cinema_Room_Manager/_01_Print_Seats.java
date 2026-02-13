package Projects.Cinema_Room_Manager;

public class _01_Print_Seats {

/* There are many enjoyable activities on this funny little planet Earth, and still, the happiest, simplest, and most fulfilling one is probably going to the movies. 
Going with friends, going with loved ones, experiencing a whole new adventure from the safety of a cinema seat, surrounded by like-minded fellow travelers.

As a beginner developer, you can contribute to creating this wonderful cinema experience. 
Your good friends asked you to help them create an application for a cinema theatre where people can get tickets, reserve seats, and enjoy their movie night. 

Objectives
There is not a lot of space in our new cinema theatre, so you need to take into account the restrictions on the number of seats. 
Your friends said that the room would fit 7 rows of 8 seats. Your task is to help them visualize the seating arrangement by printing the scheme to the console.

Your output should be like in the example below and should contain 9 lines, the title "Cinema:" - 1 line and room size - 8 lines. */    
    
    public static final int THEATER_ROWS = 7;
    public static final int THEATER_ROW_SEATING = 8;
    
    public static void main(String[] args) {

        System.out.println("Cinema:");
        
        for (int row = 0; row <= THEATER_ROWS; row++) {

            if (row == 0) {
                System.out.print("  ");
            } else {
                System.out.print(row + " ");
            }

            for (int seatingIndex = 1; seatingIndex <= THEATER_ROW_SEATING; seatingIndex++) {
                if (row == 0) {
                    System.out.print(seatingIndex + " ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }
}
