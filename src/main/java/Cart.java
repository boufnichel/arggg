import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products = new ArrayList<>();
    private boolean hasFreeShipping = false;

    private static final double BOOKS_DISCOUNT_COEFFICIENT = 10;
    public static final double TVA = 5;

    public void addProduct(Product product) {
        if (products.size() >= 100) {
            throw new IllegalStateException("Cart can't contain more than 100 items");
        }

        if (product.getStock() > 0) {
            products.add(product);
            product.decreaseStock();

            if (product.isSpecial()) {
                hasFreeShipping = true;
            }
        }
    }

    public double getTotalPrice() {
        if (products.isEmpty()) {
            return 0;
        }

        double total = getSumPrice();

        if (hasOnlyBooks()) {
            total = total - (total * BOOKS_DISCOUNT_COEFFICIENT) / 100;
        }

        total = total + (total * TVA) / 100;

        return total;
    }

    private boolean hasOnlyBooks() {
        return products.stream().allMatch(Product::isBook);
    }

    public double getSumPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public boolean hasFreeShipping() {
        return hasFreeShipping;
    }

}
