package Projects.Coffee_Machine_Simulator;

import java.util.Scanner;

public class _04_Add_Functions_To_The_Machine {

/* Description
Now, let's simulate an actual coffee machine! This coffee machine will have a limited supply of water, milk, coffee beans, and disposable cups.
Additionally, it will track how much money it earns from selling coffee.

The coffee machine will have three main functions:
    • It can sell different types of coffee: espresso, latte, and cappuccino.
      Of course, each variety would require a different amount of supplies, however, in any case, would need only one disposable cup for a drink.
    • A special worker should be able to replenish the machine's supplies.
    • Another special worker should be able to collect the money earned by the machine.

Objective
Write a program that offers three actions: buying coffee, refilling supplies, or taking its money out.
Note that the program is supposed to perform only one of the mentioned actions at a time for each input.
It should update the coffee machine's state accordingly i.e. calculate the amounts of remaining ingredients and the total money collected; and display them before and after each action.
    • First, your program reads one option from the standard input, which can be "buy", "fill", "take". If a user wants to buy some coffee, the input is "buy".
      If a special worker thinks that it is time to fill out all the supplies for the coffee machine, the input line will be "fill".
      If another special worker decides that it is time to take out the money from the coffee machine, you'll get the input "take".
    • If the user writes "buy" then they must choose one of three types of coffee that the coffee machine can make: espresso, latte, or cappuccino.
      - For a cup of espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
      - For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
      - And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
    • If the user writes "fill", the program should ask them how much water, milk, coffee beans, and how many disposable cups they want to add into the coffee machine.
    • If the user writes "take" the program should give all the money that it earned from selling coffee.

    In summary, your program should display the coffee machine's current state, process one user action, and then display the updated state. Aim to implement each action using separate functions.

    Note:
    • When the user writes "buy", they will be prompted to choose a coffee type by entering a number: 1 for espresso, 2 for latte, 3 for cappuccino.
    • Initially, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups. */

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
        coffeeMachine.displayStock();
        System.out.println("Write action (buy, fill, take): ");
        String actionSelection = scanner.nextLine();

        switch (actionSelection) {
            case "buy" -> {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                String beverageSelection = scanner.nextLine();

                Coffee coffee = null;

                switch (beverageSelection) {
                    case "1" -> coffee = new Coffee();
                    case "2" -> coffee = new Latte();
                    case "3" -> coffee = new Cappuccino();
                }

                coffeeMachine.processRequest(coffee);
            }
            case "fill" -> coffeeMachine.restock(scanner);
            case "take" -> coffeeMachine.getAccumulatedCash();
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

        public void processRequest(Coffee coffee) {
            int currentWaterStock = getWaterStock();
            int currentMilkStock = getMilkStock();
            int currentCoffeeStock = getCoffeeStock();
            int currentCupsStock = getCupsStock();
            int currentMoneyStock = getMoneyStock();

            setWaterStock(currentWaterStock - coffee.waterRequirement);
            setMilkStock(currentMilkStock - coffee.milkRequirement);
            setCoffeeStock(currentCoffeeStock - coffee.coffeeRequirement);
            setCupsStock(currentCupsStock - CUPS_REQUIREMENT);
            setMoneyStock(currentMoneyStock + coffee.cost);
            displayStock();
        }

        public void displayStock() {
            System.out.println("The coffee machine has:");
            System.out.printf("%d ml of water\n", getWaterStock());
            System.out.printf("%d ml of milk\n", getMilkStock());
            System.out.printf("%d g of coffee beans\n", getCoffeeStock());
            System.out.printf("%d disposable cups\n", getCupsStock());
            System.out.printf("$%d of money\n", getMoneyStock());
            System.out.println();
        }

        public void restock(Scanner scanner) {
            System.out.println("Write how many ml of water you want to add: ");
            int waterRestock = scanner.nextInt();

            System.out.println("Write how many ml of milk you want to add: ");
            int milkRestock = scanner.nextInt();

            System.out.println("Write how many grams of coffee beans you want to add: ");
            int coffeeRestock = scanner.nextInt();

            System.out.println("Write how many disposable cups you want to add: ");
            int cupsRestock = scanner.nextInt();

            int currentWaterStock = getWaterStock();
            int currentMilkStock = getMilkStock();
            int currentCoffeeStock = getCoffeeStock();
            int currentCupsStock = getCupsStock();

            setWaterStock(waterRestock + currentWaterStock);
            setMilkStock(milkRestock + currentMilkStock);
            setCoffeeStock(coffeeRestock + currentCoffeeStock);
            setCupsStock(cupsRestock + currentCupsStock);

            displayStock();
        }

        public void getAccumulatedCash() {
            int currentBalance = getMoneyStock();
            setMoneyStock(getMoneyStock() - currentBalance);
            System.out.printf("I gave you $%d\n", currentBalance);
            System.out.println();
            displayStock();
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
}