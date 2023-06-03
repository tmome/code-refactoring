package code.refactoring._03_long_function._12_split_loop._18_middle_man._40_replace_subclass_with_delegate;

import java.util.List;

public class Show {

    private List<String> properties;

    private double price;

    public Show(List<String> properties, double price) {
        this.properties = properties;
        this.price = price;
    }

    public boolean hasOwnProperty(String property) {
        return this.properties.contains(property);
    }

    public double getPrice() {
        return price;
    }
}
