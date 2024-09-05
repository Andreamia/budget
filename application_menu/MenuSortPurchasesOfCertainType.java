package final_project.budget.application_menu;

import final_project.budget.data_presentation.DataPrinter;
import final_project.budget.data_presentation.DataSorter;

import static final_project.budget.Application.*;
import static final_project.budget.data_management.purchase.PurchaseType.*;

public class MenuSortPurchasesOfCertainType implements Menu {

    DataPrinter dataPrinter = new DataPrinter();
    DataSorter dataSorter = new DataSorter();

    public MenuSortPurchasesOfCertainType() {
    }

    public void start() {
        System.out.println();
        displayMenuOptions();
        try {
            Integer menuOption = Integer.valueOf(SCANNER.nextLine());
            switch (menuOption) {
                case 1 -> dataPrinter.printPurchases(dataSorter.sortPurchases(FOOD), FOOD);
                case 2 -> dataPrinter.printPurchases(dataSorter.sortPurchases(CLOTHES), CLOTHES);
                case 3 -> dataPrinter.printPurchases(dataSorter.sortPurchases(ENTERTAINMENT), ENTERTAINMENT);
                case 4 -> dataPrinter.printPurchases(dataSorter.sortPurchases(OTHER), OTHER);
                default -> System.err.println(WARNING_INCORRECT_INPUT);
            }
        } catch (NumberFormatException e) {
            System.err.println(WARNING_INCORRECT_INPUT);
        }
    }

    public void displayMenuOptions() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) " + FOOD.getLabel());
        System.out.println("2) " + CLOTHES.getLabel());
        System.out.println("3) " + ENTERTAINMENT.getLabel());
        System.out.println("4) " + OTHER.getLabel());
    }
}
