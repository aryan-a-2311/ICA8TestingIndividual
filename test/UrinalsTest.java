import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    Urinals urinal1 = new Urinals();

    @Test
    void validateInputLength() {
        System.out.println("======ARYAN AGARWAL====== TEST ONE EXECUTED");

        assertEquals(true, urinal1.validateInputLength("1010101010"));
    }

    @Test
    void validateInputType() {
        System.out.println("======ARYAN AGARWAL====== TEST TWO EXECUTED");

        assertEquals(true, urinal1.validateInputType("10101010"));
    }
}