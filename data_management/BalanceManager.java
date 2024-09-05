package final_project.budget.data_management;

public class BalanceManager {

    private static Double balance = 0.0;

    public BalanceManager() {
    }

    public void addIncome(Double amount) {
        balance += amount;
    }

    public void subtractExpense(Double amount) {
        balance -= amount;
    }

    public Double getBalance() {
        return balance;
    }
}
