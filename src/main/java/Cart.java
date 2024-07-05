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
    }

    if (product.isSpecial()) {
      products.add(product);
      hasFreeShipping = true;
    }
  }

  public double getTotalPrice() {
    if (isBagEmpty()) {
      return 0;
    }

    double total = products.stream().mapToDouble(Product::getPrice).sum();
    total = applyDiscounts(total);
    total = applyTax(total);

    return total;
  }

  private boolean isBagEmpty() {
    return products.isEmpty();
  }

  private double applyTax(double total) {
    total *= 1.05;
    return total;
  }

  private double applyDiscounts(double total) {
    total = applyOnlyBookDiscount(total);
    total = applyOver100TotalDiscount(total);
    return total;
  }

  private double applyOver100TotalDiscount(double total) {
    if (total > 100) {
      total -= total * 0.05;
    }
    return total;
  }

  private double applyOnlyBookDiscount(double total) {
    if (this.products.stream().allMatch(product -> product instanceof Book)) {
      total *= 0.9;
    }
    return total;
  }

  public boolean hasFreeShipping() {
    return hasFreeShipping;
  }

}
