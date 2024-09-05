package final_project.budget.data_presentation;

import java.util.List;

import final_project.budget.data_management.PurchasesRepository;
import final_project.budget.data_management.purchase.*;

import static final_project.budget.data_management.purchase.PurchaseType.ALL;

public class DataFilter {

    PurchasesRepository repository = new PurchasesRepository();

    public DataFilter() {
    }

    public List<Purchase> filterPurchases(PurchaseType purchaseType) {
        List<Purchase> purchases = repository.getAllPurchases();
        List<Purchase> filteredPurchases = repository.getAllPurchases();
        boolean isAll = purchaseType.equals(ALL);
        if (!isAll) {
            filteredPurchases = purchases.stream()
                    .filter(p -> p.getPurchaseType().equals(purchaseType))
                    .toList();
        }
        return filteredPurchases;
    }

    public Double getPurchasesTotal(PurchaseType purchaseType) {
        List<Purchase> purchases = filterPurchases(purchaseType);
        return purchases.stream()
                .reduce(0.0, (sum, p) -> sum += p.getPrice(), Double::sum);
    }

}
