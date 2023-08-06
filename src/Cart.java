import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products = new ArrayList<>();
    private boolean hasFreeShipping = false;

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

        double total = 0;
        boolean hasOnlyBooks = true;

        for (Product product : products) {
            total += product.getPrice();
            if (!product.isBook()) {
                hasOnlyBooks = false;
            }
        }

        if (hasOnlyBooks) {
            total *= 0.9;  // 10% discount for only books
        }

        total *= 1.05;  // 5% tax

        return total;
    }

    public boolean hasFreeShipping() {
        return hasFreeShipping;
    }

    // ... other methods ...
}
