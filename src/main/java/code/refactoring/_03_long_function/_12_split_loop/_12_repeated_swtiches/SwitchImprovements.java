package code.refactoring._03_long_function._12_split_loop._12_repeated_swtiches;

public class SwitchImprovements {

    public int vacationHours(String type) {
        int result;
        switch (type) {
            case "full-time": result = 120;
            case "part-time": result = 80;
            case "temporal": result = 32;
            default: result = 0;
        }
        return result;
    }
}
