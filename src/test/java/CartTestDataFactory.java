import java.util.ArrayList;
import java.util.List;

public class CartTestDataFactory {

  public static ProductBuilder productBuilder() {
    return new ProductBuilder();
  }

  public static CartBuilder cartBuilder() {
    return new CartBuilder();
  }

  public static class ProductBuilder {
    private double price;
    private int stock;
    private boolean specialProduct = false;
    private boolean book = false;

    public ProductBuilder withPrice(double price) {
      this.price = price;
      return this;
    }

    public ProductBuilder withStock(int stock) {
      this.stock = stock;
      return this;
    }

    public ProductBuilder withSpecialProduct(boolean specialProduct) {
      this.specialProduct = specialProduct;
      return this;
    }

    public ProductBuilder withBook(boolean book) {
      this.book = book;
      return this;
    }

    public Product build() {
      if (book) {
        return new Book(price, stock, specialProduct);
      }
      return new Product(price, stock, specialProduct);
    }
  }

  public static class CartBuilder {
    private List<Product> products = new ArrayList<>();

    public CartBuilder addProduct(Product product) {
      this.products.add(product);
      return this;
    }

    public Cart build() {
      Cart cart = new Cart();
      for (Product product : products) {
        cart.addProduct(product);
      }
      return cart;
    }
  }
}

