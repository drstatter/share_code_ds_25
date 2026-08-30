package heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class intMaxHeapExTest {

    @Test
    public void capacityConstructorStartsEmpty() {
        intMaxHeapEx heap = new intMaxHeapEx(5);
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void capacityBelowOneThrows() {
        try {
            new intMaxHeapEx(0);
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
        }
    }

    @Test
    public void peekOnEmptyHeapThrows() {
        intMaxHeapEx heap = new intMaxHeapEx(5);
        try {
            heap.peek();
            fail("expected IllegalStateException");
        } catch (IllegalStateException expected) {
        }
    }

    @Test
    public void insertDoesNotReorderSinceHeapyUpIsAStub() {
        intMaxHeapEx heap = new intMaxHeapEx(5);
        heap.insert(5);
        heap.insert(9);
        heap.insert(3);
        assertEquals(3, heap.size());
        assertEquals(5, heap.peek());
    }

    @Test
    public void arrayConstructorDoesNotHeapifySinceBuildHeapIsAStub() {
        intMaxHeapEx heap = new intMaxHeapEx(new int[]{3, 10, 5, 6, 2, 8, 1});
        assertEquals(6, heap.size());
        assertEquals(3, heap.peek());
    }

    @Test
    public void extractMaxOnlyPartiallyReordersRemainingElements() {
        intMaxHeapEx heap = new intMaxHeapEx(5);
        heap.insert(5);
        heap.insert(9);
        heap.insert(3);

        assertEquals(5, heap.extractMax());
        assertEquals(2, heap.size());
        assertEquals(9, heap.peek());
    }
}
