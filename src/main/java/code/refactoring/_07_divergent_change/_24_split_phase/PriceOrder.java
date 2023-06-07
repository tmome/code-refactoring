package code.refactoring._07_divergent_change._24_split_phase;

public class PriceOrder {

    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
        final PriceDate priceDate = calculatePriceData(product, quantity);
        return applyShipping(priceDate, shippingMethod);
    }

    private PriceDate calculatePriceData(Product product, int quantity) {
        final double basePrice = product.basePrice() * quantity;
        final double discount = Math.max(quantity - product.discountThreshold(), 0)
                * product.basePrice() * product.discountRate();
        final PriceDate priceDate = new PriceDate(basePrice, discount, quantity);
        return priceDate;
    }

    private double applyShipping(PriceDate priceDate, ShippingMethod shippingMethod) {
        final double shippingPerCase = (priceDate.basePrice() > shippingMethod.discountThreshold()) ?
                shippingMethod.discountedFee() : shippingMethod.feePerCase();
        final double shippingCost = priceDate.quantity() * shippingPerCase;
        final double price = priceDate.basePrice() - priceDate.discount() + shippingCost;
        return price;
    }
}
