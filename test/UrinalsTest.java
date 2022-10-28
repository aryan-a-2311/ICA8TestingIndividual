import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @Test
    void testvalidateInputLength() {
        System.out.println("======ARYAN AGARWAL====== TEST ONE EXECUTED (0 < Length <= 20)");

        assertEquals(1, Urinals.validateInputLength("1010101010"));
    }

    @Test
    void testvalidateInputType() {
        System.out.println("======ARYAN AGARWAL====== TEST TWO EXECUTED (Only 0's and 1's)");

        assertEquals(1, Urinals.validateInputType("10101010"));
    }

    @Test
    void testfindAvailability() {
        System.out.println("======ARYAN AGARWAL====== TEST THREE EXECUTED (One bit String)");
        assertEquals(1, Urinals.findAvailability("0"));

        System.out.println("======ARYAN AGARWAL====== TEST FOUR EXECUTED (String containing two consecutive 1's)");
        assertEquals(-1, Urinals.findAvailability("01011100010"));

        System.out.println("======ARYAN AGARWAL====== TEST FIVE EXECUTED (A valid string that should return the maximum number of more stalls that can be occupied )");
        assertEquals(3, Urinals.findAvailability("00100010100010"));
    }

    @Test
    void testfileExists() {
        System.out.println("======ARYAN AGARWAL====== TEST SIX EXECUTED (File found or not)");
        assertEquals(1, Urinals.fileExists());
    }

    @Test
    void testfileReader() throws IOException {
        System.out.println("======ARYAN AGARWAL====== TEST SEVEN EXECUTED (File Empty or Not)");
        assertEquals(1, Urinals.fileReader());
    }

    @Test
    void createWriteFile() {
        System.out.println("======ARYAN AGARWAL====== TEST EIGHT EXECUTED (No IO Exceptions)");
        ArrayList<Integer> available = new ArrayList<>();
        available.add(10010000);
        available.add(100010000);
        available.add(1000100001);
        assertEquals(1, Urinals.createWriteFile(available));
    }
}