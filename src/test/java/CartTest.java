import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class CartTest {

  @Test
  void total_price_should_be_zero_when_no_products_is_present_in_the_bag() {
    Cart cart = CartTestDataFactory.cartBuilder().build();

    assertThat(cart.getTotalPrice()).isZero();
  }

  @Test
  void should_apply_discount_when_only_books() {
    Cart cart = CartTestDataFactory.cartBuilder().build();
    Product book = CartTestDataFactory.productBuilder()
        .withPrice(100)
        .withStock(1000)
        .withBook(true)
        .build();

    cart.addProduct(book);

    assertThat(cart.getTotalPrice()).isEqualTo(94.5);
  }

  @Test
  void should_not_apply_discount_when_regular_product_is_present() {
    Cart cart = CartTestDataFactory.cartBuilder().build();
    Product regularProduct = CartTestDataFactory.productBuilder()
        .withPrice(100)
        .withStock(1000)
        .build();
    cart.addProduct(regularProduct);

    assertThat(cart.getTotalPrice()).isEqualTo(105.0);
  }


  @Test
  void should_not_apply_discount_when_book_is_in_the_bag_with_regular_product() {
    Cart cart = CartTestDataFactory.cartBuilder().build();

    Product regularProduct = CartTestDataFactory.productBuilder()
        .withPrice(100)
        .withStock(1000)
        .build();

    Product book = CartTestDataFactory.productBuilder()
        .withPrice(100)
        .withStock(1000)
        .build();

    cart.addProduct(regularProduct);
    cart.addProduct(book);

    assertThat(cart.getTotalPrice()).isEqualTo(199.5);
  }

  @Test
  void should_apply_discount_over_100() {
    Cart cart = CartTestDataFactory.cartBuilder().build();
    Product product = CartTestDataFactory.productBuilder()
        .withPrice(200)
        .withStock(1000)
        .build();
    cart.addProduct(product);

    assertThat(cart.getTotalPrice()).isEqualTo(199.5);
  }

  @Test
  void should_add_special_product() {
    Cart cart = CartTestDataFactory.cartBuilder().build();
    Product product = CartTestDataFactory.productBuilder()
        .withPrice(200)
        .withStock(0)
        .withSpecialProduct(true)
        .build();

    cart.addProduct(product);

    assertThat(cart.getTotalPrice()).isEqualTo(199.5);
  }


}