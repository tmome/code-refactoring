package code.refactoring._03_long_function._12_split_loop._19_insider_trading;

import java.time.LocalDate;

public class CheckIn {

    public boolean isFastPass(Ticket ticket) {
        LocalDate earlyBirdDate = LocalDate.of(2022, 1, 1);
        return ticket.isPrime() && ticket.getPurchasedDate().isBefore(earlyBirdDate);
    }
}
