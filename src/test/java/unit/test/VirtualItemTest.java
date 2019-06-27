package unit.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void checkVirtualItem() {
        assertEquals("Vista", virtualItem.getName());
        assertEquals(1600, virtualItem.getSizeOnDisk());
        assertEquals(200, virtualItem.getPrice());
    }

    @AfterEach
    void tearDown() {    }
}
