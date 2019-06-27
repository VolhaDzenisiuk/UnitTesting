package unit.test;

import org.json.JSONException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    private Parser parser;
    private Cart cart;
    private File file;

    @BeforeEach
    void setUp() {
        file = new File("src/main/resources/test-cart2.json");
        cart = new Cart("test-cart2");

        RealItem realItem = new RealItem();
        realItem.setName("Volvo");
        realItem.setPrice(1520);
        realItem.setWeight(1200);

        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName("Vista");
        virtualItem.setPrice(1600);
        virtualItem.setSizeOnDisk(200);

        cart.addRealItem(realItem);
        cart.addVirtualItem(virtualItem);

        parser = new JsonParser();
    }

    @Test
    void checkFileExists() {
        parser.writeToFile(cart);
        assertTrue(file.exists());
    }

    @Test
    void checkFileContent() throws JSONException, IOException {
        parser.writeToFile(cart);
        BufferedReader bf = Files.newBufferedReader(Paths.get("src/main/resources/test-cart2.json"));
        String actual = bf.readLine();
        String expected = "{\"cartName\":\"test-cart2\",\"realItems\":[{\"weight\":1200.0,\"name\":\"Volvo\",\"price\":1520.0}],\"virtualItems\":[{\"sizeOnDisk\":200.0,\"name\":\"Vista\",\"price\":1600.0}],\"total\":3744.0}";
        JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"testFile1.json", "testFile2.json", "testFile3.json", "testFile4.json", "testFile5.json"})
    void checkNoSuchFileException(String string) {
        Assertions.assertThrows(NoSuchFileException.class, () -> parser.readFromFile(new File("src/main/resources/"+string)));
    }

    @Test
    void checkExceptionMessage() {
        File testFile = new File("src/main/resources/xxxxx");
        Exception exception = assertThrows(NoSuchFileException.class, () -> parser.readFromFile(testFile));
        assertEquals("File src\\main\\resources\\xxxxx.json not found!", exception.getMessage());
    }

    @Test
    @Disabled("Disabled test")
    void disabledTest() {
    }

    @AfterEach
    void tearDown() {
        file.delete();
    }
}
