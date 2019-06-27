package unit.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

class RealItemTest {

    private RealItem realitem;

    @BeforeEach
    void setUp() {
        realitem = new RealItem();
        realitem.setName("Volvo");
        realitem.setPrice(1520);
        realitem.setWeight(1200);
    }

    @Test
    void checkRealItem() {
        assertAll("realItem",
                () -> assertEquals("Volvo", realitem.getName()),
                () -> assertEquals(1520, realitem.getPrice()),
                () -> assertEquals(1200, realitem.getWeight())
        );
    }

    @AfterEach
    void tearDown() {    }
}
