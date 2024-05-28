package javaHigh.exp8.second;

public class Transaction {
    private String buyer;
    private String seller;
    private double amount;

    public Transaction(String buyer, String seller, double amount) {
        this.buyer = buyer;
        this.seller = seller;
        this.amount = amount;
    }

    public String getBuyer() {
        return buyer;
    }

    public double getAmount() {
        return amount;
    }
}
