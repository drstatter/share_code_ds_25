package Itrators;

import java.util.Iterator;

public class IterStringExampleIterOut implements Iterator {
    String data;
    IterStringExampleIterOut(String data) {
        this.data = data;
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
