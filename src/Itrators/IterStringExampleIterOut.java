package Itrators;

import java.util.Iterator;

public class IterStringExampleIterOut implements Iterator {
    private String data;
    private int currentIndex;

    IterStringExampleIterOut(String data) {
        this.data = data;
        currentIndex = 0;
    }
    @Override
    public boolean hasNext() {
        return currentIndex < data.length();
    }

    @Override
    public Object next() {

        return data.charAt(currentIndex++);
    }
}
