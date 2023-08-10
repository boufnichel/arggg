import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void should_decrease_stock(){
        Product product = new Product( 0, 1, false, false);
        product.decreaseStock();

        assertThat(product.getStock()).isZero();
    }

    @Test
    void should_trigger_exception_if_stock_is_zero(){
        Product product = new Product( 0, 0, false, false);

        assertThrows(IllegalStateException.class, product::decreaseStock);
    }

    @Test
    void should_trigger_exception_if_stock_is_zero_with_the_excpected_message(){
        Product product = new Product( 0, 0, false, false);

        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, product::decreaseStock);
        assertThat(illegalStateException.getMessage()).isEqualTo("Product is out of stock");
    }



}