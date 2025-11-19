package Itrators;

import java.util.Iterator;

public class IterStringExample implements Iterable<Character> {
    private String data;

    public IterStringExample(String str) {
        this.data = str;
    }
    public Iterator<Character> iterator() {
        return new IterStringExampleIterOut();
    }
    private class IterStringExampleIterOut implements Iterator<Character> {
        private int currentIndex;

        IterStringExampleIterOut() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < data.length();
        }

        @Override
        public Character next() {
            return data.charAt(currentIndex++);
        }
    }

    public static void main(String[] args) {
        IterStringExample example = new IterStringExample("Koala");
        Iterator<Character> iter = example.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

}
