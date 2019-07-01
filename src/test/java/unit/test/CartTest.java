package unit.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {

    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart("test-cart");
        RealItem realItem1 = new RealItem();
        RealItem realItem2 = new RealItem();

        realItem1.setPrice(12);
        realItem2.setPrice(15);
        cart.addRealItem(realItem1);
        cart.addRealItem(realItem2);
    }

    @Test
    @Tag("cart_tests")
    void checkTotalPrice() {
        assertEquals(32.4, cart.getTotalPrice(), "Cart total price is incorrect.");
    }

    @AfterEach
    void tearDown() {    }
}
