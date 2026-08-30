package Itrators;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class IterStringExampleTest {

    @Test
    public void iteratesOverAllCharacters() {
        IterStringExample example = new IterStringExample("abc");
        Iterator<Character> iter = example.iterator();
        assertEquals(Character.valueOf('a'), iter.next());
        assertEquals(Character.valueOf('b'), iter.next());
        assertEquals(Character.valueOf('c'), iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void enhancedForLoopVisitsAllCharacters() {
        IterStringExample example = new IterStringExample("hi");
        StringBuilder sb = new StringBuilder();
        for (Character ch : example) {
            sb.append(ch);
        }
        assertEquals("hi", sb.toString());
    }

    @Test
    public void emptyStringHasNoNext() {
        IterStringExample example = new IterStringExample("");
        assertFalse(example.iterator().hasNext());
    }
}
