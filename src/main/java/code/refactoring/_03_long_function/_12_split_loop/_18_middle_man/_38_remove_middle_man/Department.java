package code.refactoring._03_long_function._12_split_loop._18_middle_man._38_remove_middle_man;

public class Department {

    private Person manager;

    public Department(Person manager) {
        this.manager = manager;
    }

    public Person getManager() {
        return manager;
    }
}
