package lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeIntTest {

    @Test
    public void singleArgConstructorHasNoNext() {
        NodeInt node = new NodeInt(5);
        assertEquals(5, node.getData());
        assertNull(node.getNext());
    }

    @Test
    public void setNextLinksNodes() {
        NodeInt second = new NodeInt(null, 20);
        NodeInt first = new NodeInt(null, 10);
        first.setNext(second);
        assertEquals(second, first.getNext());
        assertEquals(20, first.getNext().getData());
    }

    @Test
    public void toStringWithNoNext() {
        NodeInt node = new NodeInt(5);
        assertEquals("LISTS.Node [next=null, data=5]", node.toString());
    }

    @Test
    public void toStringWithNext() {
        NodeInt second = new NodeInt(null, 20);
        NodeInt first = new NodeInt(second, 10);
        assertEquals("LISTS.Node [next=20, data=10]", first.toString());
    }
}
