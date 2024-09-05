package final_project.budget.data_management;

import final_project.budget.data_management.purchase.*;

import static final_project.budget.Application.*;

public class DataReader {
    BalanceManager balanceManager = new BalanceManager();
    PurchasesRepository repository = new PurchasesRepository();

    public DataReader() {
    }

    public void readIncome() {
        System.out.println();
        System.out.println("Enter income: ");
        Double amount = Double.parseDouble(SCANNER.nextLine());
        balanceManager.addIncome(amount);
        System.out.println("Income was added!\n");
    }

    public void readPurchase(PurchaseType purchaseType) {
        Purchase purchase = new Purchase(purchaseType);
        System.out.println();
        purchase.setName(readPurchaseName());
        purchase.setPrice(readPurchasePrice());
        repository.addPurchaseToList(purchase);
        balanceManager.subtractExpense(purchase.getPrice());
        System.out.println("Purchase was added!\n");
    }

    public String readPurchaseName() {
        System.out.println("Enter purchase name:");
        return SCANNER.nextLine();
    }

    public Double readPurchasePrice() {
        System.out.println("Enter its price:");
        return Double.parseDouble(SCANNER.nextLine());
    }
}
