package code.refactoring._03_long_function._12_split_loop._06_mutable_data._22_combine_functions_into_transform;

import java.time.Month;
import java.time.Year;

public record Reading(String customer, double quantity, Month month, Year year) {
}
