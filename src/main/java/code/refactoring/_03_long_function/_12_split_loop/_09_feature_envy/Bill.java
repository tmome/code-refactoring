package code.refactoring._03_long_function._12_split_loop._09_feature_envy;

public class Bill {

    private ElectricityUsage electricityUsage;

    private GasUsage gasUsage;

    public double calculateBill() {
        var electicityBill = electricityUsage.getAmount() * electricityUsage.getPricePerUnit();
        var gasBill = gasUsage.getAmount() * gasUsage.getPricePerUnit();
        return electicityBill + gasBill;
    }

}
