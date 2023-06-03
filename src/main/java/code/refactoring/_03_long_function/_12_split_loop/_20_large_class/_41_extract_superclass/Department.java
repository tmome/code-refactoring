package code.refactoring._03_long_function._12_split_loop._20_large_class._41_extract_superclass;

import java.util.List;

public class Department {

    private String name;

    private List<Employee> staff;

    public String getName() {
        return name;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public double totalMonthlyCost() {
        return this.staff.stream().mapToDouble(e -> e.getMonthlyCost()).sum();
    }

    public double totalAnnualCost() {
        return this.totalMonthlyCost() * 12;
    }

    public int headCount() {
        return this.staff.size();
    }
}
