import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CartTest {

    @Test
    void getTotalPriceWhenProductsEmpty() {
        Cart cart = new Cart();
        double totalPrice = cart.getTotalPrice();
        Assertions.assertEquals(0, totalPrice);
    }

    @Test
    void getTotalPrice_WhenProductsNotEmptyAndNotBookNorSpacial_ShouldReturnSumOfProductsPrices() {
        Cart cart = new Cart();
        Product product1 =  Product.builder().price(10).stock(1).build();
        cart.addProduct(product1);
        double totalPrice = cart.getTotalPrice();
        Assertions.assertEquals(10.5, totalPrice);
    }
    @Test
    void getTotalPrice_WhenCardContainsBooksProductsOnly_ShouldReturnSumOfProductsMultipliedByBooksCoefficient() {
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