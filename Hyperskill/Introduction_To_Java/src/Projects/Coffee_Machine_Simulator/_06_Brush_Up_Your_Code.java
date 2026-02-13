package Projects.Coffee_Machine_Simulator;

import java.util.Scanner;

public class _06_Brush_Up_Your_Code {

/* Description
In this stage, let's improve the design of our program by organizing it into classes that represent different parts of the coffee machine. 
For instance, we can create one class for the coffee machine itself and another class to represent each type of coffee with its ingredients and cost. 
This approach helps structure the code better, allowing for easier reuse and extension. 
Each class should have methods that handle specific tasks, working together to process the user input and manage the coffee machine's operations.

Your program should handle the user's input through methods in these classes. Every time the user inputs something, 
it will be processed by these methods to update the state of the machine. This setup simulates how real-world machines operate, where each part has a defined role.

As the coffee machine operates, it will keep track of its resources, including water, milk, coffee beans, disposable cups, and the cash collected. 
Each action taken by the user should be processed in the context of the machine's current state, which reflects the available resources.

Additionally, we'll introduce a new action: cleaning. The coffee machine will monitor how many coffees have been made. 
After producing 10 cups, it will require cleaning. During this action, the machine will not be able to make any more coffee until it is cleaned by the user typing "clean". 
After cleaning, the machine resumes its normal operations.

Remember, that:
    • For a cup of espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
    • For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
    • And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.

Objectives
Your final task is to refactor the program to ensure you can interact with the coffee machine through methods in the classes you created. 
Implement the cleaning action, where the machine requires cleaning after 10 cups of coffee are made. Once cleaned, the machine can make coffee again. */

    public static final int INITIAL_WATER_STOCK = 400;
    public static final int INITIAL_MILK_STOCK = 540;
    public static final int INITIAL_COFFEE_STOCK = 120;
    public static final int INITIAL_CUPS_STOCK = 9;
    public static final int INITIAL_MONEY_STOCK = 550;
    public static final int INITIAL_ORDERS_PROCESSED = 0;

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

                    if (coffeeMachine.isCleaningNeeded) {
                        System.out.println("I need cleaning!\n");
                        break;
                    }

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
                case "clean" -> coffeeMachine.clean();
                case "remaining" -> coffeeMachine.displayStock();
            }

            userInput = getUserInput(scanner);
        }

    }

    private static String getUserInput(Scanner scanner) {
        System.out.println("Write action (buy, fill, take, clean, remaining, exit): ");
        String input = scanner.nextLine();
        return input;
    }

    private static class CoffeeMachine {

        private int waterStock;
        private int milkStock;
        private int coffeeStock;
        private int cupsStock;
        private int moneyStock;
        private int processedOrders;
        private boolean isCleaningNeeded;

        public CoffeeMachine() {
            this.waterStock = INITIAL_WATER_STOCK;
            this.milkStock = INITIAL_MILK_STOCK;
            this.coffeeStock = INITIAL_COFFEE_STOCK;
            this.cupsStock = INITIAL_CUPS_STOCK;
            this.moneyStock = INITIAL_MONEY_STOCK;
            this.processedOrders = INITIAL_ORDERS_PROCESSED;
            this.isCleaningNeeded = false;
        }

        public void processOrder(Coffee coffee) {
            int currentWaterStock = getWaterStock();
            int currentMilkStock = getMilkStock();
            int currentCoffeeStock = getCoffeeStock();
            int currentCupsStock = getCupsStock();
            int currentMoneyStock = getMoneyStock();

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

            processedOrders += 1;
            if (processedOrders % 10 == 0) {
                isCleaningNeeded = true;
            }
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

        public void clean() {
            isCleaningNeeded = false;
            System.out.println("I have been cleaned!\n");
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