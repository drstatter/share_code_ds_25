package Itrators;

import org.junit.Test;

import static org.junit.Assert.*;

public class IterStringExampleIterOutTest {

    @Test
    public void hasNextAlwaysFalse() {
        IterStringExampleIterOut iter = new IterStringExampleIterOut("abc");
        assertFalse(iter.hasNext());
    }

    @Test
    public void nextAlwaysReturnsNull() {
        IterStringExampleIterOut iter = new IterStringExampleIterOut("abc");
        assertNull(iter.next());
    }
}
