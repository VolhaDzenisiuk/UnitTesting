package unit.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VirtualItemTest {

   private VirtualItem virtualItem;

    @BeforeEach
    void setUp() {
        virtualItem = new VirtualItem();
        virtualItem.setName("Vista");
        virtualItem.setSizeOnDisk(1600);
        virtualItem.setPrice(200);
    }

    @Test
    @Tag("virtual_item_tests")
    void checkToStringMethod() {
        String toString = virtualItem.toString();
        assertTrue(toString.contains("Size on disk: " + virtualItem.getSizeOnDisk()), "toString() method failed.");
    }

    @AfterEach
    void tearDown() {    }
}
