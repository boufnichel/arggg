import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class CartTest {

  @Test
  void total_price_should_be_zero_when_no_products_is_present_in_the_bag() {
    Cart cart = new Cart();

    assertThat(cart.getTotalPrice()).isZero();
  }
}