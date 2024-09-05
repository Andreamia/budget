package final_project.budget.data_management.purchase;

import java.util.Objects;

public class Purchase {
    private PurchaseType purchaseType;
    private String name;
    private Double price;

    public Purchase(PurchaseType purchaseType) {
        this.purchaseType = purchaseType;
    }

    public Purchase(PurchaseType purchaseType, String name, Double price) {
        this.purchaseType = purchaseType;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseType='" + purchaseType + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return purchaseType == purchase.purchaseType && Objects.equals(name, purchase.name)
                && Objects.equals(price, purchase.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseType, name, price);
    }

    public PurchaseType getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(PurchaseType purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
