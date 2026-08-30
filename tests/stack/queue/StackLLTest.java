package stack.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackLLTest {

    private StackLL<String> stack;

    @Before
    public void setUp() {
        stack = new StackLL<>();
    }

    @Test
    public void newStackIsEmpty() {
        assertTrue(stack.isEempty());
        assertEquals(0, stack.size());
    }

    @Test
    public void pushIncreasesSize() {
        stack.push("1");
        stack.push("2");
        assertEquals(2, stack.size());
        assertFalse(stack.isEempty());
    }

    @Test
    public void peekReturnsLastPushedWithoutRemoving() {
        stack.push("1");
        stack.push("2");
        assertEquals("2", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void popReturnsAndRemovesLastPushed() {
        stack.push("1");
        stack.push("2");
        assertEquals("2", stack.pop());
        assertEquals(1, stack.size());
        assertEquals("1", stack.peek());
    }

    @Test
    public void toStringReflectsUnderlyingList() {
        stack.push("1");
        stack.push("2");
        assertEquals("[1, 2]", stack.toString());
    }
}
