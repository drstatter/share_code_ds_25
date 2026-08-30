package rec;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinChooseTest {

    @Test
    public void computesBinomialCoefficient() {
        BinChoose c = new BinChoose();
        assertEquals(10, c.nChooseK(5, 2));
        assertEquals(1, c.nChooseK(5, 0));
        assertEquals(1, c.nChooseK(5, 5));
    }
}
