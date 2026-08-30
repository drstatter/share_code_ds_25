package stack.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {

    private ArrayQueue queue;

    @Before
    public void setUp() {
        queue = new ArrayQueue(3);
    }

    @Test
    public void newQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void enqueueIncreasesSizeAndPeekReturnsFront() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        assertEquals(1, queue.peek());
    }

    @Test
    public void dequeueReturnsFrontAndDecreasesSize() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(2, queue.peek());
    }

    @Test(expected = RuntimeException.class)
    public void enqueueOnFullQueueThrows() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
    }

    @Test(expected = RuntimeException.class)
    public void dequeueOnEmptyQueueThrows() {
        queue.dequeue();
    }

    @Test
    public void wrapsAroundCircularBuffer() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
