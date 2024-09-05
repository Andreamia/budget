package final_project.budget.application_menu;

import final_project.budget.data_management.PurchasesRepository;
import final_project.budget.data_presentation.DataFilter;
import final_project.budget.data_presentation.DataPrinter;

import static final_project.budget.Application.*;
import static final_project.budget.data_management.purchase.PurchaseType.*;

public class MenuPrintPurchases implements Menu {

    DataPrinter dataPrinter = new DataPrinter();
    DataFilter dataFilter = new DataFilter();
    PurchasesRepository repository = new PurchasesRepository();

    public MenuPrintPurchases() {
    }

    public void start() {
        Integer menuOption = -1;
        System.out.println();
        do {
            displayMenuOptions();
            try {
                menuOption = Integer.parseInt(SCANNER.nextLine());
                switch (menuOption) {
                    case 1 -> dataPrinter.printPurchases(dataFilter.filterPurchases(FOOD), FOOD);
                    case 2 -> dataPrinter.printPurchases(dataFilter.filterPurchases(CLOTHES), CLOTHES);
                    case 3 -> dataPrinter.printPurchases(dataFilter.filterPurchases(ENTERTAINMENT), ENTERTAINMENT);
                    case 4 -> dataPrinter.printPurchases(dataFilter.filterPurchases(OTHER), OTHER);
                    case 5 -> dataPrinter.printPurchases(repository.getAllPurchases(), ALL);
                    case 6 -> System.out.println();
                    default -> System.err.println(WARNING_INCORRECT_INPUT);
                }
            } catch (NumberFormatException e) {
                System.err.println(WARNING_INCORRECT_INPUT);
            }
        } while (!menuOption.equals(6));
    }

    public void displayMenuOptions() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) " + FOOD.getLabel());
        System.out.println("2) " + CLOTHES.getLabel());
        System.out.println("3) " + ENTERTAINMENT.getLabel());
        System.out.println("4) " + OTHER.getLabel());
        System.out.println("5) " + ALL.getLabel());
        System.out.println("6) Back");
    }
}
