package Projects.Coffee_Machine_Simulator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_Estimate_The_Number_Of_Servings {

/* Description
A real coffee machine doesn't have an infinite supply of water, milk, or coffee beans. If you request too many cups of coffee, 
it's almost certain that a real coffee machine wouldn't have enough supplies to fulfill the order.

In this stage, you need to improve the previous stage program. Now you will check amounts of water, milk, and coffee beans available in the coffee machine at the moment.

Please note that the coffee machine won't actually make any coffee in this stage; instead, it will simply compute the required ingredients.

Objective
Write a program that does the following:
    • Requests the amounts of water, milk, and coffee beans available at the moment, and then asks for the number of cups of coffee a user needs.
    • If the coffee machine has enough supplies to make the specified amount of coffee, the program should print "Yes, I can make that amount of coffee".
    • If the coffee machine can make more than the requested amount, 
      the program should output "Yes, I can make that amount of coffee (and even N more than that)", where N is the number of additional cups of coffee that the coffee machine can make.
    • If the available resources are insufficient to make the requested amount of coffee, the program should output "No, I can make only N cup(s) of coffee". 
    
    Like in the previous stage, the coffee machine needs 200 ml of water, 50 ml of milk, and 15 g of coffee beans to make one cup of coffee.*/

    public static final int WATER_REQUIREMENT = 200;
    public static final int MILK_REQUIREMENT = 50;
    public static final int COFFEE_REQUIREMENT = 15;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> machineStock = restockCoffeeMachine(scanner);

        System.out.println("Write how many cups of coffee you will need: ");
        int cupsRequirement = scanner.nextInt();

        processCoffeeRequest(cupsRequirement, machineStock);

    }

    private static Map<String, Integer> restockCoffeeMachine(Scanner scanner) {
        Map<String, Integer> machineStock = new HashMap<>();

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = scanner.nextInt();

        machineStock.put("Water", water);
        machineStock.put("Milk", milk);
        machineStock.put("Coffee", coffee);

        return machineStock;
    }

    private static void processCoffeeRequest(int cupsRequirement, Map<String, Integer> machineStock) {

        int possibleCupsAsPerWater = machineStock.get("Water") / WATER_REQUIREMENT;
        int possibleCupsAsPerMilk = machineStock.get("Milk") / MILK_REQUIREMENT;
        int possibleCupsAsPerCoffee = machineStock.get("Coffee") / COFFEE_REQUIREMENT;

        int totalCups = Math.min(Math.min(possibleCupsAsPerWater, possibleCupsAsPerMilk), possibleCupsAsPerCoffee);

        if (totalCups >= cupsRequirement) {
            if (totalCups - cupsRequirement >= 1) {
                System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", totalCups - cupsRequirement);
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", totalCups);
        }
    }
}
