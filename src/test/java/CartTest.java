import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class CartTest {

    @Test
    void should_not_add_more_than_100_product(){
        Cart cart = new Cart();
        assertThrows(IllegalStateException.class, ()-> {
            for (int i = 0; i < 101; i++) {
                Product product = Product.builder().stock(1).build();
                cart.addProduct(product);
            }
        });
    }

    @Test
    void should_mark_cart_with_free_shipping(){
        Cart cart = new Cart();
        Product product = Product.builder().isSpecial(true).stock(1).build();
        cart.addProduct(product);

        assertThat(cart.hasFreeShipping()).isTrue();
    }

    @Test
    void should_calculate_total_for_empty_cart(){
        Cart cart = new Cart();
        assertThat(cart.getTotalPrice()).isEqualTo(0d);
    }

    @Test
    void should_calculate_total_no_book_product(){
        Cart cart = new Cart();
        Product product = Product.builder().stock(1).price(100).build();
        cart.addProduct(product);
        assertThat(cart.getTotalPrice()).isEqualTo(105d);
    }

    @Test
    void should_calculate_total_for_book_product(){
        Cart cart = new Cart();
        Product product = Product.builder().stock(1).price(100).isBook(true).build();
        cart.addProduct(product);
        assertThat(cart.getTotalPrice()).isEqualTo(94.5d);
    }

    @Test
    void should_check_has_we_have_a_book_in_the_cart(){
        Product product = Product.builder().isBook(true).stock(1).build();
        Cart cart = new Cart();
        cart.addProduct(product);

        assertThat(cart.hasOnlyBooks()).isTrue();
    }

    @Test
    void should_check_has_we_dont_have_a_book_in_the_cart(){
        Product product = Product.builder().stock(1).build();
        Cart cart = new Cart();
        cart.addProduct(product);

        assertThat(cart.hasOnlyBooks()).isFalse();
    }
}