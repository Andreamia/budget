package final_project.budget.data_management.purchase;

public enum PurchaseType {
    FOOD("Food"),
    CLOTHES("Clothes"),
    ENTERTAINMENT("Entertainment"),
    OTHER("Other"),
    ALL("All");

    private final String label;

    PurchaseType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
