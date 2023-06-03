package code.refactoring._03_long_function._12_split_loop._23_refused_bequest;

public class Employee {

    protected Quota quota;

    protected Quota getQuota() {
        return new Quota();
    }

}
