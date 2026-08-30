package lists;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class IterExampleTest {

    private IterExample example;

    @Before
    public void setUp() {
        example = new IterExample();
    }

    @Test
    public void iteratesInInsertionOrder() {
        example.add(3);
        example.add(5);
        example.add(7);

        Iterator<Integer> iter = example.iterator();
        assertEquals(3, (int) iter.next());
        assertEquals(5, (int) iter.next());
        assertEquals(7, (int) iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void growsBeyondInitialCapacity() {
        for (int i = 0; i < 25; i++) {
            example.add(i);
        }
        int count = 0;
        for (Integer value : example) {
            assertEquals(count, (int) value);
            count++;
        }
        assertEquals(25, count);
    }

    @Test
    public void emptyIteratorHasNoNext() {
        assertFalse(example.iterator().hasNext());
    }
}
