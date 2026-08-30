package stack.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StuckArrayTest {

    private StuckArray<String> stack;

    @Before
    public void setUp() {
        stack = new StuckArray<>(3);
    }

    @Test
    public void newStackIsEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void pushUpToCapacitySucceeds() {
        assertTrue(stack.push("1"));
        assertTrue(stack.push("2"));
        assertTrue(stack.push("3"));
        assertEquals(3, stack.size());
    }

    @Test
    public void pushBeyondCapacityFails() {
        stack.push("1");
        stack.push("2");
        stack.push("3");
        assertFalse(stack.push("4"));
        assertEquals(3, stack.size());
    }

    @Test
    public void popReturnsLastPushed() {
        stack.push("1");
        stack.push("2");
        assertEquals("2", stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    public void popOnEmptyStackReturnsNull() {
        assertNull(stack.pop());
    }

    @Test
    public void peekOnEmptyStackReturnsNull() {
        assertNull(stack.peek());
    }

    @Test
    public void containsFindsPushedElement() {
        stack.push("1");
        stack.push("2");
        assertTrue(stack.contains("2"));
        assertFalse(stack.contains("99"));
    }

    @Test
    public void toStringReflectsCurrentElements() {
        stack.push("1");
        stack.push("2");
        assertEquals("[1 2 ]", stack.toString());
    }
}
