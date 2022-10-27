import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @Test
    void validateInputTest() {
        System.out.println("======ARYAN AGARWAL====== TEST ONE EXECUTED (THAT FAILS)");

        Urinals urinal1 = new Urinals();
        //Testing with 24 characters
        assertEquals(true, urinal1.validateInputLength("101010101010101010101010"));
    }
}