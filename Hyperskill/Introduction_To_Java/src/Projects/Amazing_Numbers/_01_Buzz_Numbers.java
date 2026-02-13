package Projects.Amazing_Numbers;

import java.util.Scanner;

public class _01_Buzz_Numbers {

/* Description
Integers can be even or odd. All numbers that end with 0, 2, 4, 6, or 8 are even; the rest are odd.
However, numbers have many other properties, you will learn about some of them in this project.

First, let's talk about Buzz numbers. They are numbers that are either divisible by 7 or end with 7.
For example, the number 14 is a buzz number, since it is divisible by 7 without a remainder; the number 17 ends with 7,
so it is also a buzz number. However, the number 75 is not a Buzz number, since it is neither divisible by 7 nor does it end with 7.
The number 7 is a Buzz number too.

Your task at this stage is to write a program that prints the natural number parity and determines whether this number is a Buzz.
The program should print why this number is a Buzz number.

Do you know how to determine whether a number is divisible by 7 or not? We have a great tip:
    1. Remove the last digit;
    2. Multiply the removed digit by 2 and subtract it from the remaining number.
    3. If the result of the subtraction can be divided by 7, then the initial number is divisible by 7.
    You can apply the whole sequence multiple times until you get a relatively small/easy-to-interpret subtraction result.

For example, take 196. We remove the last digit and get 19. We subtract 12 (the removed digit multiplied by 2) to get 7.
Since the last left digit is 7, the number is multiple of 7. So 196 is a Buzz number! You can use any solution you want, the tests won't check it.

Objectives
Your program should check whether the given natural number is a buzz number.

    1. Ask a user to enter a natural number.
    2. If the number is not natural, print an error message.
    3. Calculate and print the parity of the number.
    4. Check whether is the number is a Buzz number and print the explanation.
    5. Finish the program after printing the message.

Natural numbers are whole numbers starting from 1. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        String userInput = scanner.nextLine();
        int userInputDigit = Integer.parseInt(userInput);

        if (userInputDigit < 1) {
            System.out.println("This number is not natural!");
            return;
        }

        System.out.println("This number is " + (userInputDigit % 2 == 0 ? "Even." : "Odd."));

        boolean isDivisibleBySeven = userInputDigit % 7 == 0;
        boolean endsWithSeven = userInputDigit % 10 == 7;
        boolean isBuzz = isDivisibleBySeven || endsWithSeven;

        System.out.println(isBuzz ? "It is a Buzz number." : "It is not a Buzz number.");
        System.out.println("Explanation:");

        if (isDivisibleBySeven && endsWithSeven) {
            System.out.println(userInputDigit + " is divisible by 7 and ends with 7.");
        } else if (isDivisibleBySeven) {
            System.out.println(userInputDigit + " is divisible by 7.");
        } else if (endsWithSeven) {
            System.out.println(userInputDigit + " ends with 7.");
        } else {
            System.out.println(userInputDigit + " is neither divisible by 7 nor does it end with 7.");
        }
    }
}
