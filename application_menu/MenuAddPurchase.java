package final_project.budget.application_menu;

import final_project.budget.data_management.DataReader;

import static final_project.budget.Application.*;
import static final_project.budget.data_management.purchase.PurchaseType.*;

public class MenuAddPurchase implements Menu{
    DataReader dataReader = new DataReader();

    public MenuAddPurchase() {}

    public void start() {
        Integer menuOption = -1;
        System.out.println();
        do {
            displayMenuOptions();
            try {
                menuOption = Integer.parseInt(SCANNER.nextLine());
                switch (menuOption) {
                    case 1 -> dataReader.readPurchase(FOOD);
                    case 2 -> dataReader.readPurchase(CLOTHES);
                    case 3 -> dataReader.readPurchase(ENTERTAINMENT);
                    case 4 -> dataReader.readPurchase(OTHER);
                    case 5 -> System.out.println();
                    default -> System.err.println(WARNING_INCORRECT_INPUT);
                }
            } catch (NumberFormatException e) {
                System.err.println(WARNING_INCORRECT_INPUT);
            }
        } while (!menuOption.equals(5));

    }

    public void displayMenuOptions() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) " + FOOD.getLabel());
        System.out.println("2) " + CLOTHES.getLabel());
        System.out.println("3) " + ENTERTAINMENT.getLabel());
        System.out.println("4) " + OTHER.getLabel());
        System.out.println("5) Back");
    }

}
