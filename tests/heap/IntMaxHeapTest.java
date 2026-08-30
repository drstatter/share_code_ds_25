package heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntMaxHeapTest {

    @Test
    public void capacityConstructorStartsEmpty() {
        IntMaxHeap heap = new IntMaxHeap(5);
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void capacityBelowOneThrows() {
        try {
            new IntMaxHeap(0);
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
        }
    }

    @Test
    public void peekOnEmptyHeapThrows() {
        IntMaxHeap heap = new IntMaxHeap(5);
        try {
            heap.peek();
            fail("expected IllegalStateException");
        } catch (IllegalStateException expected) {
        }
    }

    @Test
    public void insertMaintainsMaxAtRoot() {
        IntMaxHeap heap = new IntMaxHeap(5);
        heap.insert(3);
        heap.insert(10);
        heap.insert(5);
        assertEquals(10, heap.peek());
        assertEquals(3, heap.size());
    }

    @Test
    public void extractMaxRemovesLargestFirst() {
        IntMaxHeap heap = new IntMaxHeap(5);
        heap.insert(3);
        heap.insert(10);
        heap.insert(5);
        heap.insert(1);

        assertEquals(10, heap.extractMax());
        assertEquals(5, heap.extractMax());
        assertEquals(3, heap.extractMax());
        assertEquals(1, heap.extractMax());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void growsBeyondInitialCapacity() {
        IntMaxHeap heap = new IntMaxHeap(2);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        assertEquals(3, heap.size());
        assertEquals(3, heap.peek());
    }

    @Test
    public void arrayConstructorBuildsValidHeapExcludingLastElement() {
        IntMaxHeap heap = new IntMaxHeap(new int[]{3, 10, 5, 6, 2, 8, 1});
        assertEquals(6, heap.size());
        assertEquals(10, heap.peek());
    }
}
