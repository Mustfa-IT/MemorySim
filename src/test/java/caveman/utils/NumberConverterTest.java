package caveman.utils;
import org.caveman.utils.NumberConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberConverterTest {

    @Test
    public void testHexToBinary() {
        NumberConverter converter = new NumberConverter();
        assertEquals("0001", converter.hexToBinary("1"));
        assertEquals("1010", converter.hexToBinary("A"));
        assertEquals("11111111", converter.hexToBinary("FF"));
    }

    @Test
    public void testBinaryToHex() {
        NumberConverter converter = new NumberConverter();
        assertEquals("A", converter.binaryToHex("1010"));
        assertEquals("FF", converter.binaryToHex("11111111"));
    }

    @Test
    public void testBinaryToLong() {
        NumberConverter converter = new NumberConverter();
        assertEquals("1", converter.binaryToHex("0001"));
        assertEquals(1L, converter.binaryToLong("1"));
        assertEquals(10L, converter.binaryToLong("1010"));
        assertEquals(255L, converter.binaryToLong("11111111"));
    }

    @Test
    public void testHexToLong() {
        NumberConverter converter = new NumberConverter();
        assertEquals(1L, converter.hexToLong("1"));
        assertEquals(10L, converter.hexToLong("A"));
        assertEquals(255L, converter.hexToLong("FF"));
    }

    @Test
    public void testLongToBinary() {
        NumberConverter converter = new NumberConverter();
        assertEquals("1", converter.longToBinary(1L));
        assertEquals("1010", converter.longToBinary(10L));
        assertEquals("11111111", converter.longToBinary(255L));
    }

    @Test
    public void testLongToHex() {
        NumberConverter converter = new NumberConverter();
        assertEquals("1", converter.longToHex(1L));
        assertEquals("A", converter.longToHex(10L));
        assertEquals("FF", converter.longToHex(255L));
    }
}