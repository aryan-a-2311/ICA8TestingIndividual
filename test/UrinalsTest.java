import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @Test
    void validateInputTest() {
        System.out.println("======ARYAN AGARWAL====== TEST ONE (THAT FAILS)");

        Urinals urinal1 = new Urinals();

        assertEquals(true, urinal1.validateInput("1010101010"));
    }
}