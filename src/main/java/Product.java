import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Product {
    private double price;
    @Builder.Default
    private int stock = 0;
    @Builder.Default
    private boolean isSpecial = false;
    @Builder.Default
    private boolean isBook = false ;

    public void decreaseStock() {
        if (stock > 0) {
            stock--;
        } else {
            throw new IllegalStateException("Product is out of stock");
        }
    }
}

