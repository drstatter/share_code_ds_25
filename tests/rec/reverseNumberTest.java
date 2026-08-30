package rec;

import org.junit.Test;

import static org.junit.Assert.*;

public class reverseNumberTest {

    @Test
    public void reversesMultiDigitNumber() {
        reverseNumber r = new reverseNumber();
        assertEquals(321, r.reverse(123));
    }

    @Test
    public void reversesNumberWithTrailingZero() {
        reverseNumber r = new reverseNumber();
        assertEquals(1, r.reverse(100));
    }

    @Test
    public void reversesSingleDigit() {
        reverseNumber r = new reverseNumber();
        assertEquals(7, r.reverse(7));
    }

    @Test
    public void reversesZero() {
        reverseNumber r = new reverseNumber();
        assertEquals(0, r.reverse(0));
    }
}
