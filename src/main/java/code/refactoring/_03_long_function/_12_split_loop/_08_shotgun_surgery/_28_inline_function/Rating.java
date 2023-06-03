package code.refactoring._03_long_function._12_split_loop._08_shotgun_surgery._28_inline_function;

public class Rating {

    public int rating(Driver driver) {
        return moreThanFiveLateDeliveries(driver) ? 2 : 1;
    }

    private boolean moreThanFiveLateDeliveries(Driver driver) {
        return driver.getNumberOfLateDeliveries() > 5;
    }
}
