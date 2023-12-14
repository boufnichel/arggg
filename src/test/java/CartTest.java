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
        Product product1 =  TestDataBuilder.getProduct(10);
        cart.addProduct(product1);
        double totalPrice = cart.getTotalPrice();
        Assertions.assertEquals(10.5, totalPrice);
    }
    @Test
    void discounted_price_should_be_applied_when_a_book_is_ordered() {

        Cart cart = new Cart();
        Product product1 =  TestDataBuilder.getBook(10);
        cart.addProduct(product1);
        double totalPrice = cart.getTotalPrice();
        Assertions.assertEquals(9.45, totalPrice);
    }

    @Test
    void discount_should_be_applied_when_a_total_over_or_equals_one_hundred() {

        Cart cart = new Cart();
        Product product1 =  TestDataBuilder.getProduct(100);
        cart.addProduct(product1);
        double totalPrice = cart.getTotalPrice();
        Assertions.assertEquals(100, totalPrice);
    }
}