package Projects.Coffee_Machine_Simulator;

import java.util.Scanner;

public class _02_Calculate_The_Ingredients {

/* Description
Now let's consider a scenario where you need a lot of coffee—perhaps you're hosting a party with many guests! In such cases, it's better to make preparations in advance.
In this stage, you will ask the user to enter the desired number of coffee cups. Based on this input, you will calculate the necessary amounts of water, 
coffee, and milk needed to prepare the specified quantity of coffee.

Please note that the coffee machine won't actually make any coffee in this stage; instead, it will simply compute the required ingredients.

Objective
    • Read the number of coffee cups from the input.
    • Calculate the amount of each ingredient needed. One cup of coffee requires:
        - 200 ml of water
        - 50 ml of milk
        - 15 g of coffee beans 
    • Output the required ingredient amounts back to the user. */

    public static final int WATER_REQUIREMENT = 200;
    public static final int MILK_REQUIREMENT = 50;
    public static final int COFFEE_REQUIREMENT = 15;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = scanner.nextInt();

        System.out.println("For 25 cups of coffee you will need:");
        System.out.println(cups * WATER_REQUIREMENT + " ml of water");
        System.out.println(cups * MILK_REQUIREMENT + " ml of milk");
        System.out.println(cups * COFFEE_REQUIREMENT + " g of coffee beans");

    }
}
