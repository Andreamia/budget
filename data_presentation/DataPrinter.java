package final_project.budget.data_presentation;

import java.util.List;
import java.util.Map;

import final_project.budget.data_management.BalanceManager;
import final_project.budget.data_management.purchase.*;

import static final_project.budget.data_management.purchase.PurchaseType.ALL;

public class DataPrinter {

    BalanceManager balanceManager = new BalanceManager();
    DataFilter dataFilter = new DataFilter();

    public DataPrinter() {
    }

    public void printPurchases(List<Purchase> purchases, PurchaseType purchaseType) {
        DataPrinter dataPrinter = new DataPrinter();
        System.out.println();
        if (!purchases.isEmpty()) {
            System.out.println(purchaseType.getLabel() + ":");
            purchases
                    .forEach(dataPrinter::printPurchase);
            printPurchasesTotal(purchaseType);
        } else {
            System.out.println("The purchase list is empty");
        }
        System.out.println();
    }

    public void printPurchase(Purchase purchase) {
        System.out.printf("%s $%.2f%n", purchase.getName(), purchase.getPrice());
    }

    public void printPurchasesTypes(Map<String, Double> mapPurchasesTypes) {
        System.out.println();
        System.out.println("Types:");
        mapPurchasesTypes
                .forEach((key, value) -> System.out.printf("%s - $%.2f%n", key, value));
        printPurchasesTotal(ALL);
        System.out.println();
    }

    public void printPurchasesTotal(PurchaseType purchaseType) {
        System.out.printf("Total sum: $%.2f%n", dataFilter.getPurchasesTotal(purchaseType));
    }

    public void printBalance() {
        System.out.println();
        System.out.printf("Balance: $%.2f%n", balanceManager.getBalance());
        System.out.println();
    }
}
