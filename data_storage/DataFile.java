package final_project.budget.data_storage;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import final_project.budget.data_management.BalanceManager;
import final_project.budget.data_management.PurchasesRepository;
import final_project.budget.data_management.purchase.Purchase;
import final_project.budget.data_management.purchase.PurchaseType;


public class DataFile {

    static final Path FILE = Path.of("src", "final_project",
            "budget", "files", "purchases.txt");

    BalanceManager balanceManager = new BalanceManager();
    PurchasesRepository repository = new PurchasesRepository();

    public DataFile() {
    }

    public void savePurchasesToFile() {

        try(var bw = Files.newBufferedWriter(FILE)) {

            String balanceString = balanceManager.getBalance().toString();
            bw.write(balanceString); bw.newLine(); //write balance

            List<Purchase> purchases = repository.getAllPurchases();
            for (Purchase purchase : purchases) {
                String purchaseString = String.format("%s, %s, $%.2f", purchase.getPurchaseType().getLabel(), purchase.getName(), purchase.getPrice());
                bw.write(purchaseString); bw.newLine(); //write purchases
            }

            System.out.println("\nPurchases were saved!\n");

        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }

    public void loadPurchasesFromFile() {
        try(var br = Files.newBufferedReader(FILE)) {

            String[] lines = br.lines().toArray(String[]::new); //read file

            balanceManager.addIncome(Double.parseDouble(lines[0])); //add balance

            for (int i = 1; i < lines.length ; i++) {
                Purchase purchase = parsePurchaseFromFile(lines[i]);
                repository.addPurchaseToList(purchase); //add purchases
            }

            System.out.println("\nPurchases were loaded!\n");

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public Purchase parsePurchaseFromFile(String line) {
        String[] parts = line.split(",");
        PurchaseType purchaseType = PurchaseType.valueOf(parts[0].trim().toUpperCase());
        String name = parts[1].trim();
        parts[2] = parts[2].trim();
        parts[2] = parts[2].substring(1).trim();
        Double price = Double.parseDouble(parts[2]);
        return new Purchase(purchaseType, name, price);
    }
}
