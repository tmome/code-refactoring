package code.refactoring._03_long_function._12_split_loop._06_mutable_data._19_separate_query_from_modifier;

public class Invoice {

    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
