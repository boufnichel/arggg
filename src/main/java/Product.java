import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private double price;
    private int stock ;
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

