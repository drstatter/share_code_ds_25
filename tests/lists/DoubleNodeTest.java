package lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleNodeTest {

    @Test
    public void constructorSetsDataAndLinks() {
        DoubleNode<Integer> node = new DoubleNode<>(null, null, 5);
        assertEquals(5, (int) node.getData());
        assertNull(node.getNext());
        assertNull(node.getPrev());
    }

    @Test
    public void setNextLinksBothDirections() {
        DoubleNode<Integer> a = new DoubleNode<>(null, null, 1);
        DoubleNode<Integer> b = new DoubleNode<>(null, null, 2);
        a.setNext(b);
        assertEquals(b, a.getNext());
        assertEquals(a, b.getPrev());
    }

    @Test
    public void setPrevLinksBothDirections() {
        DoubleNode<Integer> a = new DoubleNode<>(null, null, 1);
        DoubleNode<Integer> b = new DoubleNode<>(null, null, 2);
        b.setPrev(a);
        assertEquals(a, b.getPrev());
        assertEquals(b, a.getNext());
    }

    @Test
    public void setDataUpdatesValue() {
        DoubleNode<Integer> node = new DoubleNode<>(null, null, 1);
        node.setData(99);
        assertEquals(99, (int) node.getData());
    }

    @Test
    public void toStringWithNoNeighbors() {
        DoubleNode<Integer> node = new DoubleNode<>(null, null, 5);
        assertEquals("DoubleNode{ data=5 next=null, prev=null}", node.toString());
    }

    @Test
    public void toStringWithNeighbors() {
        DoubleNode<Integer> a = new DoubleNode<>(null, null, 1);
        DoubleNode<Integer> b = new DoubleNode<>(null, a, 2);
        assertEquals("DoubleNode{ data=2 next=null, prev=1}", b.toString());
    }
}
