package code.refactoring._03_long_function._12_split_loop._06_mutable_data._19_separate_query_from_modifier;

import java.util.List;

public class Customer {

    private String name;

    private List<Invoice> invoices;

    public Customer(String name, List<Invoice> invoices) {
        this.name = name;
        this.invoices = invoices;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public String getName() {
        return name;
    }
}
