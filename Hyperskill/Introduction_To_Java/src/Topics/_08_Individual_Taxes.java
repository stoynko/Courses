package Topics;

import java.util.Arrays;
import java.util.Scanner;

public class _08_Individual_Taxes {

/*In some country, there are N companies, and the law of that country says that the taxes of each company are individual and
appointed by the president. The president wants to know which company pays the most taxes.
But sadly, none of the president's proxies know math very well, so this work is transferred to you. Can you solve this problem?

The first line of the input contains N which is the number of companies in the country.
The second line contains the yearly incomes of each company. All numbers are non-negative integers.
The third line contains individual taxes for each company in percent of the company's income.
All numbers are integers from 0 to 100 inclusive.

You should output the number of the company that pays the most taxes. Keep in mind that the enumeration of the companies starts
with number 1. If there are several companies with the same payment sizes, output the number of the company with the lowest number.

Note: be careful not to lose fractional parts while performing your calculations. All input and output numbers are integers,
but you may have to use a different type for storing intermediate values. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int companies = Integer.parseInt(scanner.nextLine());
        int[] yearlyIncomes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] taxesToIncome = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double highestTax = Double.MIN_VALUE;
        int companyWithHighestTax = 0;

        for (int i = 0; i < companies; i++) {
            double taxPaid = yearlyIncomes[i] * ((double) taxesToIncome[i] / 100);
            if (taxPaid > highestTax) {
                highestTax = taxPaid;
                companyWithHighestTax = i + 1;
            }
        }
        System.out.println(companyWithHighestTax);
    }
}
