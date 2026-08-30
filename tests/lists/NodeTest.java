package lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void getDataReturnsConstructorValue() {
        Node<Integer> node = new Node<>(null, 5);
        assertEquals(5, (int) node.getData());
        assertNull(node.getNext());
    }

    @Test
    public void setNextLinksNodes() {
        Node<Integer> second = new Node<>(null, 20);
        Node<Integer> first = new Node<>(null, 10);
        first.setNext(second);
        assertEquals(second, first.getNext());
        assertEquals(20, (int) first.getNext().getData());
    }

    @Test
    public void toStringWithNoNext() {
        Node<Integer> node = new Node<>(null, 5);
        assertEquals("LISTS.Node [next=null, data=5]", node.toString());
    }

    @Test
    public void toStringWithNext() {
        Node<Integer> second = new Node<>(null, 20);
        Node<Integer> first = new Node<>(second, 10);
        assertEquals("LISTS.Node [next=20, data=10]", first.toString());
    }
}
