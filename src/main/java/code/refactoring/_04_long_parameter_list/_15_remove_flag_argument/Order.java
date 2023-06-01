package code.refactoring._04_long_parameter_list._15_remove_flag_argument;

import java.time.LocalDate;

public class Order {

    //TODO : flag 인수 제거하기

    private LocalDate placedOn;
    private String deliveryState;

    public Order(LocalDate placedOn, String deliveryState) {
        this.placedOn = placedOn;
        this.deliveryState = deliveryState;
    }

    public LocalDate getPlacedOn() {
        return placedOn;
    }

    public String getDeliveryState() {
        return deliveryState;
    }
}
