import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Product {
    private double price;
    private int stock;
    private boolean isSpecial;
    private boolean isBook;

    public void decreaseStock() {
        if (stock > 0) {
            stock--;
        } else {
            throw new IllegalStateException("Product is out of stock");
        }
    }
}

