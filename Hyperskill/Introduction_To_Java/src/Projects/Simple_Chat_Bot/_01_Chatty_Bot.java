package Projects.Simple_Chat_Bot;

import java.util.*;

public class _01_Chatty_Bot {

/* Description:
Digital personal assistants help people to drive cars, plan their day, buy something online.
In a sense, they are simplified versions of artificial intelligence with whom you can talk.
In this project, you will develop step by step a simple bot that will help you study programming.

Objective:
    • For the first stage, you will write a bot who displays a greeting,
      its name, and the year it was created. First impressions count!

Your program should print the following lines:
    Hello! My name is {bot_name}.
    I was created in {birth_year}.

Instead of {botName}, print any name you choose and replace {birthYear} with the current year (four digits).
You don't need to take any input at this stage. */

    public static void main(String[] args) {

        String botName = "Robby";
        int birthYear = java.time.Year.now().getValue();
        System.out.printf("Hello! My name is %s.\n", botName);
        System.out.printf("I was created in %d.\n", birthYear);
   }
}
