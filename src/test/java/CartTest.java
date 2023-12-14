import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;


class CartTest {

    @Test
    void price_should_zero_when_the_bag_is_empty() {
        Cart cart = new Cart();
        double totalPrice = cart.getTotalPrice();
        Assertions.assertEquals(0, totalPrice);
    }

    @Test
    void normal_price_should_be_applied_when_no_book_is_ordered() {

        Cart cart = new Cart();
        Product product1 =  Product.builder().price(10).stock(1).build();
        cart.addProduct(product1);
        double totalPrice = cart.getTotalPrice();
        Assertions.assertEquals(10.5, totalPrice);
    }
    @Test
    void discounted_price_should_be_applied_when_a_book_is_ordered() {
        double productPrice = 10;
        double genericCoefficient = 1.05;
        double booksCoefficient = 0.9;
        Cart cart = new Cart();
        Product product1 =  Product.builder().isBook(true).price(10).stock(1).build();
        cart.addProduct(product1);
        double totalPrice = cart.getTotalPrice();
        Assertions.assertEquals(productPrice * genericCoefficient * booksCoefficient, totalPrice);
    }
}