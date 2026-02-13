package Projects.Coffee_Machine_Simulator;

import java.util.Scanner;

public class _05_Keep_Track_Of_Supplies {

/* Description
Handling only a single action at a time is quite limited, so let's improve the program to handle multiple actions, one after another. 
The program should repeatedly ask a user what they want to do. If the user types "buy", "fill" or "take", then the program should behave exactly 
as it did in the previous stage. But unlike the previous stage, where the state of the coffee machine was displayed before and after each action 
("buy", "fill" or "take"), the state of the coffee machine should now be shown only when the user types "remaining". 
Additionally, if the user wants to switch off the coffee machine, they should type "exit" to stop the program. 
In total, the program should now five actions: "buy", "fill", "take", "remaining", and "exit".

Remember, that:
    • For a cup of espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
    • For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
    • And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.

Objectives
Write a program that continuously processes user actions until the "exit" command is given. Additionally, introduce two new options:
    • "remaining": to display the current state of the coffee machine
    • "exit": to switch off the coffee machine

Remember, the coffee machine can run out of resources. If it doesn't have enough resources to make coffee, 
the program should output a message that says it can't make a cup of coffee and indicate which resource is missing.

And the last improvement to the program in this stage — if the user types "buy" to buy a cup of coffee but then changes their mind, 
they should be able to type "back" to return into the main menu. */

    public static final int INITIAL_WATER_STOCK = 400;
    public static final int INITIAL_MILK_STOCK = 540;
    public static final int INITIAL_COFFEE_STOCK = 120;
    public static final int INITIAL_CUPS_STOCK = 9;
    public static final int INITIAL_MONEY_STOCK = 550;

    public static final int ESPRESSO_WATER_REQUIREMENT = 250;
    public static final int ESPRESSO_MILK_REQUIREMENT = 0;
    public static final int ESPRESSO_COFFEE_REQUIREMENT = 16;
    public static final int ESPRESSO_COST = 4;

    public static final int LATTE_WATER_REQUIREMENT = 350;
    public static final int LATTE_MILK_REQUIREMENT = 75;
    public static final int LATTE_COFFEE_REQUIREMENT = 20;
    public static final int LATTE_COST = 7;

    public static final int CAPPUCCINO_WATER_REQUIREMENT = 200;
    public static final int CAPPUCCINO_MILK_REQUIREMENT = 100;
    public static final int CAPPUCCINO_COFFEE_REQUIREMENT = 12;
    public static final int CAPPUCCINO_COST = 6;
    public static final int CUPS_REQUIREMENT = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String userInput = getUserInput(scanner);

        while (!"exit".equals(userInput)) {
            switch (userInput) {
                case "buy" -> {
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String beverageSelection = scanner.nextLine();
                    Coffee coffee = null;

                    switch (beverageSelection) {
                        case "1" -> coffee = new Coffee();
                        case "2" -> coffee = new Latte();
                        case "3" -> coffee = new Cappuccino();
                        case "back" -> {
                            userInput = getUserInput(scanner);
                            continue;
                        }
                    }

                    coffeeMachine.processOrder(coffee);

                }
                case "fill" -> coffeeMachine.restock(scanner);
                case "take" -> coffeeMachine.getAccumulatedCash();
                case "remaining" -> coffeeMachine.displayStock();
            }

            userInput = getUserInput(scanner);
        }

    }

    private static String getUserInput(Scanner scanner) {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String input = scanner.nextLine();
        return input;
    }

    private static class CoffeeMachine {

        private int waterStock;
        private int milkStock;
        private int coffeeStock;
        private int cupsStock;
        private int moneyStock;

        public CoffeeMachine() {
            this.waterStock = INITIAL_WATER_STOCK;
            this.milkStock = INITIAL_MILK_STOCK;
            this.coffeeStock = INITIAL_COFFEE_STOCK;
            this.cupsStock = INITIAL_CUPS_STOCK;
            this.moneyStock = INITIAL_MONEY_STOCK;
        }


        public void processOrder(Coffee coffee) {
            int currentWaterStock = getWaterStock();
            int currentMilkStock = getMilkStock();
            int currentCoffeeStock = getCoffeeStock();
            int currentCupsStock = getCupsStock();
            int currentMoneyStock = getMoneyStock();

            String output = null;

            if (currentWaterStock < coffee.waterRequirement) {
                System.out.println("Sorry, not enough water!\n");
                return;
            } else if (currentMilkStock < coffee.milkRequirement) {
                System.out.println("Sorry, not enough milk!\n");
                return;
            } else if (currentCoffeeStock < coffee.coffeeRequirement) {
                System.out.println("Sorry, not enough coffee beans!\n");
                return;
            } else if (currentCupsStock < CUPS_REQUIREMENT) {
                System.out.println("Sorry, not enough cups!\n");
                return;
            }

            System.out.println("I have enough resources, making you a coffee!\n");

            setWaterStock(currentWaterStock - coffee.waterRequirement);
            setMilkStock(currentMilkStock - coffee.milkRequirement);
            setCoffeeStock(currentCoffeeStock - coffee.coffeeRequirement);
            setCupsStock(currentCupsStock - CUPS_REQUIREMENT);
            setMoneyStock(currentMoneyStock + coffee.cost);
        }

        public void displayStock() {
            System.out.println();
            System.out.println("The coffee machine has:");
            System.out.printf("%d ml of water\n", getWaterStock());
            System.out.printf("%d ml of milk\n", getMilkStock());
            System.out.printf("%d g of coffee beans\n", getCoffeeStock());
            System.out.printf("%d disposable cups\n", getCupsStock());
            System.out.printf("$%d of money\n\n", getMoneyStock());
        }

        public void restock(Scanner scanner) {
            System.out.println("\nWrite how many ml of water you want to add: ");
            int waterRestock = scanner.nextInt();

            System.out.println("Write how many ml of milk you want to add: ");
            int milkRestock = scanner.nextInt();

            System.out.println("Write how many grams of coffee beans you want to add: ");
            int coffeeRestock = scanner.nextInt();

            System.out.println("Write how many disposable cups you want to add: ");
            int cupsRestock = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            int currentWaterStock = getWaterStock();
            int currentMilkStock = getMilkStock();
            int currentCoffeeStock = getCoffeeStock();
            int currentCupsStock = getCupsStock();

            setWaterStock(waterRestock + currentWaterStock);
            setMilkStock(milkRestock + currentMilkStock);
            setCoffeeStock(coffeeRestock + currentCoffeeStock);
            setCupsStock(cupsRestock + currentCupsStock);
        }

        public void getAccumulatedCash() {
            int currentBalance = getMoneyStock();
            setMoneyStock(getMoneyStock() - currentBalance);
            System.out.println();
            System.out.printf("I gave you $%d", currentBalance);
            System.out.println();
        }

        public int getWaterStock() {
            return waterStock;
        }

        private void setWaterStock(int waterStock) {
            this.waterStock = waterStock;
        }

        public int getMilkStock() {
            return milkStock;
        }

        private void setMilkStock(int milkStock) {
            this.milkStock = milkStock;
        }

        public int getCoffeeStock() {
            return coffeeStock;
        }

        private void setCoffeeStock(int coffeeStock) {
            this.coffeeStock = coffeeStock;
        }

        public int getCupsStock() {
            return cupsStock;
        }

        private void setCupsStock(int cupsStock) {
            this.cupsStock = cupsStock;
        }

        public int getMoneyStock() {
            return moneyStock;
        }

        private void setMoneyStock(int moneyStock) {
            this.moneyStock = moneyStock;
        }
    }

    private static class Coffee {

        protected int waterRequirement;
        protected int milkRequirement;
        protected int coffeeRequirement;
        protected int cost;

        private Coffee() {
            this.waterRequirement = ESPRESSO_WATER_REQUIREMENT;
            this.milkRequirement = ESPRESSO_MILK_REQUIREMENT;
            this.coffeeRequirement = ESPRESSO_COFFEE_REQUIREMENT;
            this.cost = ESPRESSO_COST;
        }

        public int getWaterRequirement() {
            return waterRequirement;
        }

        public int getMilkRequirement() {
            return milkRequirement;
        }

        public int getCoffeeRequirement() {
            return coffeeRequirement;
        }

        public int getCost() {
            return cost;
        }
    }

    private static class Cappuccino extends Coffee {
        private Cappuccino() {
            super.waterRequirement = CAPPUCCINO_WATER_REQUIREMENT;
            super.milkRequirement = CAPPUCCINO_MILK_REQUIREMENT;
            super.coffeeRequirement = CAPPUCCINO_COFFEE_REQUIREMENT;
            super.cost = CAPPUCCINO_COST;
        }
    }

    private static class Latte extends Coffee {
        private Latte() {
            super.waterRequirement = LATTE_WATER_REQUIREMENT;
            super.milkRequirement = LATTE_MILK_REQUIREMENT;
            super.coffeeRequirement = LATTE_COFFEE_REQUIREMENT;
            super.cost = LATTE_COST;
        }
    }
}