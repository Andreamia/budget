package final_project.budget.data_presentation;

import java.util.*;
import java.util.stream.Collectors;

import final_project.budget.data_management.purchase.*;

public class DataSorter {

    DataFilter dataFilter = new DataFilter();

    public DataSorter() {
    }

    public List<Purchase> sortPurchases(PurchaseType purchaseType) {
        List<Purchase> purchases = dataFilter.filterPurchases(purchaseType);
        return purchases.stream()
                .sorted(Comparator.comparing(Purchase::getPrice).reversed())
                .toList();
    }

    public Map<String, Double> sortPurchasesTypes() {
        Map<String, Double> mapTypes = new HashMap<>();
        for (int i = 0; i < PurchaseType.values().length - 1; i++) {
            PurchaseType purchaseType = PurchaseType.values()[i];
            mapTypes.put(purchaseType.getLabel(), dataFilter.getPurchasesTotal(purchaseType));
        }
        return mapTypes.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }
}
