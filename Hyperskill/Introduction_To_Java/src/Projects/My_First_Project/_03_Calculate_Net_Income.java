package Projects.My_First_Project;

import java.util.*;

public class _03_Calculate_Net_Income {

/* Description:
In the final stage, let's calculate the shop's net income. To do this, you need to retrieve staff and other expenses from the user
input and subtract them from the income you came up with in the previous stage. You don't need to change the previous functionality of your program,
but to expand it by adding both inputs and calculating the net income.

We've imported the sync-input library that you must use to take input from the user.

Objectives:
In this stage, your program should:
    • Print the item names, what you earned for each of them and total earnings as before;
    • Ask users for staff expenses with the Staff expenses: string and for other expenses with the Other expenses: string;
    • Calculate and print the net income as shown below. Replace 0.0 with the actual net income */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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

        System.out.println("Staff expenses:\n");
        double staffExpenses = Double.parseDouble(scanner.nextLine());
        System.out.println("Other expenses:\n");
        double otherExpenses = Double.parseDouble(scanner.nextLine());
        double netIncome = income - (staffExpenses + otherExpenses);
        System.out.printf("Net income: %.1f\n", netIncome);
    }
}
