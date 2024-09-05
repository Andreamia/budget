package final_project.budget.application_menu;

import final_project.budget.data_management.DataReader;
import final_project.budget.data_presentation.DataPrinter;
import final_project.budget.data_storage.DataFile;

import static final_project.budget.Application.*;

public class MenuMain implements Menu {
    Menu menuAddPurchase = new MenuAddPurchase();
    Menu menuPrintPurchases = new MenuPrintPurchases();
    Menu menuSortPurchases = new MenuSortPurchases();
    DataFile dataFile = new DataFile();
    DataReader dataReader = new DataReader();
    DataPrinter dataPrinter = new DataPrinter();

    public void start() {
        Integer menuOption = -1;
        do {
            displayMenuOptions();
            try {
                menuOption = Integer.parseInt(SCANNER.nextLine());
                switch (menuOption) {
                    case 1 -> dataReader.readIncome();
                    case 2 -> menuAddPurchase.start();
                    case 3 -> menuPrintPurchases.start();
                    case 4 -> dataPrinter.printBalance();
                    case 5 -> dataFile.savePurchasesToFile();
                    case 6 -> dataFile.loadPurchasesFromFile();
                    case 7 -> menuSortPurchases.start();
                    case 0 -> System.out.println();
                    default -> System.err.println(WARNING_INCORRECT_INPUT);
                }
            } catch (NumberFormatException e) {
                System.err.println(WARNING_INCORRECT_INPUT);
            }
        } while (!menuOption.equals(0));
        System.out.println("Bye!");
    }

    public void displayMenuOptions() {
        System.out.println("Choose your action: ");
        System.out.println("1) Add Income");
        System.out.println("2) Add Purchase");
        System.out.println("3) Show the list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("7) Analyze (Sort)");
        System.out.println("0) Exit");
    }
}
