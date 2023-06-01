package code.refactoring._04_long_parameter_list._14_replace_parameter_with_query;

public class Order {

    //TODO: 매개변수를 질의 함수로 바꾸기 : 매개변수를 다른 매개변수를 통해 알아낼 수 있다면 이것은 중복된 매개변수라고 볼 수 있다.
    // 매개변수에 값을 전달하는것은 함수를 호출하는 쪽에 책임이다. 가능하면 함수를 호출하는쪽에 책임을 줄이고 함수 내부에서 처리할 수 있도록 해야한다.

    private int quantity;

    private double itemPrice;

    public Order(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double finalPrice() {
        double basePrice = this.quantity * this.itemPrice;
        return this.discountedPrice(basePrice);
    }

    private int discountLevel() {
        return this.quantity > 100 ? 2 : 1;
    }

    private double discountedPrice(double basePrice) {
        return discountLevel() == 2 ? basePrice * 0.90 : basePrice * 0.95;
    }
}
