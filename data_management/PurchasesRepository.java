package final_project.budget.data_management;

import java.util.*;

import final_project.budget.data_management.purchase.*;

public class PurchasesRepository {
    private static List<Purchase> allPurchases = new ArrayList<>();

    public PurchasesRepository() {
    }

    public void addPurchaseToList(Purchase purchase) {
        allPurchases.add(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return allPurchases;
    }


}
