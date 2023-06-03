package code.refactoring._03_long_function._12_split_loop._18_middle_man._40_replace_subclass_with_delegate;

import java.util.List;

public class PremiumExtra {

    private List<String> properties;

    private double premiumFee;

    public PremiumExtra(List<String> properties, double premiumFee) {
        this.properties = properties;
        this.premiumFee = premiumFee;
    }

    public double getPremiumFee() {
        return premiumFee;
    }

    public boolean hasOwnProperty(String property) {
        return this.properties.contains(property);
    }
}
