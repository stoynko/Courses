package Projects.Tic_Tac_Toe;

public class _01_Welcome_To_The_Battlefield {

/* Tic-tac-toe is a game known all over the world. Each country may have its own version of the name, sometimes the rules are different,
but the essence of the game remains the same. Below are the main rules that may be familiar to you since childhood.

Tic-tac-toe is played by two players on a 3x3 grid. One of the players is 'X', and the other player is 'O'.
X plays first, then O takes the next turn, and so on. The players write 'X' and 'O' on a 3x3 field.
The first player that puts 3 X's or 3 O's in a straight line (including diagonals) wins the game.

Objectives:
Your first task in this project is to print the game grid in the console output.
Use what you’ve learned about the print() function to print three lines, each containing three characters (X’s and O’s) to represent a
game of tic-tac-toe where all fields of the grid have been filled in. */

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j % 2 == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
