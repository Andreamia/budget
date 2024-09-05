package final_project.budget;

import java.util.Scanner;

import final_project.budget.application_menu.MenuMain;

public class Application {

    public static final String WARNING_INCORRECT_INPUT = "\n Incorrect input. Try again!\n";
    public static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        new MenuMain().start();
    }
}
