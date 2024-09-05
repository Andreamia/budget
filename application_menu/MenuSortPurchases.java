package final_project.budget.application_menu;

import final_project.budget.data_presentation.DataPrinter;
import final_project.budget.data_presentation.DataSorter;

import static final_project.budget.Application.*;
import static final_project.budget.data_management.purchase.PurchaseType.*;

public class MenuSortPurchases implements Menu {

    Menu menuSortPurchasesOfCertainType = new MenuSortPurchasesOfCertainType();
    DataPrinter dataPrinter = new DataPrinter();
    DataSorter dataSorter = new DataSorter();

    public MenuSortPurchases() {
    }

    public void start() {
        Integer menuOption = -1;
        System.out.println();
        do {
            displayMenuOptions();
            try {
                menuOption = Integer.parseInt(SCANNER.nextLine());
                switch (menuOption) {
                    case 1 -> dataPrinter.printPurchases(dataSorter.sortPurchases(ALL), ALL);
                    case 2 -> dataPrinter.printPurchasesTypes(dataSorter.sortPurchasesTypes());
                    case 3 -> menuSortPurchasesOfCertainType.start();
                    case 4 -> System.out.println();
                    default -> System.err.println(WARNING_INCORRECT_INPUT);
                }
            } catch (NumberFormatException e) {
                System.err.println(WARNING_INCORRECT_INPUT);
            }
        } while (!menuOption.equals(4));
    }

    public void displayMenuOptions() {
        System.out.println("How do you want to sort?");
        System.out.println("1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort certain type");
        System.out.println("4) Back");
    }

}

