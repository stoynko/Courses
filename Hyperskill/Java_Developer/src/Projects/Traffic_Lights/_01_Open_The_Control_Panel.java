package Projects.Traffic_Lights;

import java.io.IOException;
import java.util.Scanner;

public class _01_Open_The_Control_Panel {

/*Description
Let's output the starting menu that greets users and shows them a list of four possible options. We will use this menu in later stages.

Objectives
As a start, develop a simple program that prints six non-empty lines to the output.

    1. Being a very polite program, it greets users on the first line with the Welcome substring and tells them that they've just started traffic management system.
    2. The following line is the list's title, with Menu substring.
    3. After that, finally, display the list line-by-line in exact order, indexing and substrings:
        1. Add
        2. Delete
        3. System
        0. Quit

In further stages we will control the traffic light system with these actions. */

    public static final String WELCOME_MESSAGE = "Welcome to the traffic management system!";
    public static final String MENU = "Menu:";
    public static final String MENU_ITEM_ONE = "1. Add";
    public static final String MENU_ITEM_TWO = "2. Delete";
    public static final String MENU_ITEM_THREE = "3. System";
    public static final String MENU_ITEM_QUIT = "0. Quit";

    public static void main(String[] args) {

        System.out.println(WELCOME_MESSAGE);
        System.out.println(MENU);
        System.out.println(MENU_ITEM_ONE);
        System.out.println(MENU_ITEM_TWO);
        System.out.println(MENU_ITEM_THREE);
        System.out.println(MENU_ITEM_QUIT);
    }
}

