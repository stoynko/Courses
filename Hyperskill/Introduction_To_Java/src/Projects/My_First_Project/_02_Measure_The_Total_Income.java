package Projects.My_First_Project;

public class _02_Measure_The_Total_Income {

/*Description:

A month has passed since the opening of your shop. Let's calculate the total earnings for this period! You know the total earned amount for each item:
┌───────────────────┬───────────────┐
│ Item name         │ Earned amount │
├───────────────────┼───────────────┤
│ Bubblegum         │ $202          │
├───────────────────┼───────────────┤
│ Toffee            │ $118          │
├───────────────────┼───────────────┤
│ Ice cream         │ $2250         │
├───────────────────┼───────────────┤
│ Milk chocolate    │ $1680         │
├───────────────────┼───────────────┤
│ Doughnut          │ $1075         │
├───────────────────┼───────────────┤
│ Pancake           │ $80           │
└───────────────────┴───────────────┘

Use the above data to find the total income for the first month and log the results as shown below.
Objectives:

In this stage, your program should:
    • Print the Earned amount: line.
    • Print the item names and the earned amount for each of them;
    • Print the total earnings as shown below. Replace 0.0 with the actual total sum. */

    public static void main(String[] args) {

        double income = 0;
        System.out.println("Earned amount:");
        System.out.println("Bubblegum: $202");
        income += 202;
        System.out.println("Toffee: $118");
        income += 118;
        System.out.println("Ice cream: $2250");
        income += 2250;
        System.out.println("Milk chocolate: $1680");
        income += 1680;
        System.out.println("Doughnut: $1075");
        income += 1075;
        System.out.println("Pancake: $80");
        income += 80;
        System.out.printf("Income: $%.1f", income);
    }
}
