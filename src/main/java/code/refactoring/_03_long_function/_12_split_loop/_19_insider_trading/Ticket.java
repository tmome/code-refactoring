package code.refactoring._03_long_function._12_split_loop._19_insider_trading;

import java.time.LocalDate;

public class Ticket {

    private LocalDate purchasedDate;

    private boolean prime;

    public Ticket(LocalDate purchasedDate, boolean prime) {
        this.purchasedDate = purchasedDate;
        this.prime = prime;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public boolean isPrime() {
        return prime;
    }
}
