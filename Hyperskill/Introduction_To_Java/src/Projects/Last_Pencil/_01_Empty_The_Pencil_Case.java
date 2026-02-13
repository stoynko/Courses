package Projects.Last_Pencil;

import java.util.Random;

public class _01_Empty_The_Pencil_Case {

/*Description
You and your friend decided to play a simple pen-and-paper game.
There's one catch — you have only pencils but no paper; the last piece of paper is gone for your beautiful drawings.
As a joke, your friend pulls all the pencils out of the case onto the table and says: "Your turn!"

Objectives
In this stage, your program should print two lines: one line with several vertical bar symbols representing pencils
(for example, ||| or |||||||) and one Your turn! string.

Examples

    Example 1:

        ||||||||
        Your turn!

    Example 2:

        |||
        Your turn! */

    public static void main(String[] args) {
        Random rand = new Random();
        int randomNum = rand.nextInt(0, 5);

        StringBuilder output = new StringBuilder();
        for (int index = 0; index < randomNum; index++) {
            output.append("|");
        }

        System.out.println(output);
        System.out.println("Your turn!");
    }
}
