import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    Urinals urinal1 = new Urinals();

    @Test
    void testvalidateInputLength() {
        System.out.println("======ARYAN AGARWAL====== TEST ONE EXECUTED (Length < 20)");

        assertEquals(true, urinal1.validateInputLength("1010101010"));
    }

    @Test
    void testvalidateInputType() {
        System.out.println("======ARYAN AGARWAL====== TEST TWO EXECUTED (Only 0's and 1's)");

        assertEquals(true, urinal1.validateInputType("10101010"));
    }

    @Test
    void testfindAvailability() {
        System.out.println("======ARYAN AGARWAL====== TEST THREE EXECUTED (One bit String)");
        assertEquals(1, urinal1.findAvailability("0"));
    }
}