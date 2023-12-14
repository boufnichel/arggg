import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int CART_MAX_CAPACITY = 100;
    private final List<Product> products = new ArrayList<>();
    private static final double BOOKS_DISCOUNT_COEFFICIENT = 10;
    public static final double TVA = 5;

    public void addProduct(Product product) {
        if (products.size() >= CART_MAX_CAPACITY) {
            throw new IllegalStateException("Cart can't contain more than 100 items");
        }

        if (product.getStock() > 0) {
            products.add(product);
            product.decreaseStock();
        }
    }

    public double getTotalPrice() {
        double total = getSumPrice();

        if (hasOnlyBooks()) {
            total = applyDiscount(total);
        }
        return applyTaxes(total);
    }

    private double applyTaxes(double total) {
        return total + (total * TVA) / 100;
    }
    private double applyDiscount(double total) {
        return total - (total * BOOKS_DISCOUNT_COEFFICIENT) / 100;
    }
    private boolean hasOnlyBooks() {
        return products.stream().allMatch(Product::isBook);
    }

    public double getSumPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

}
