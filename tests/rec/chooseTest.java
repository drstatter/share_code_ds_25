package rec;

import org.junit.Test;

import static org.junit.Assert.*;

public class chooseTest {

    @Test
    public void computesBinomialCoefficient() {
        choose c = new choose();
        assertEquals(10, c.nChooseK(5, 2));
        assertEquals(1, c.nChooseK(5, 0));
        assertEquals(1, c.nChooseK(5, 5));
        assertEquals(6, c.nChooseK(4, 2));
    }
}
