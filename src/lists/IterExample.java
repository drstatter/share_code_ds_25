package lists;

import java.util.Iterator;

public class IterExample implements Iterable<Integer> {
    private Integer[] data;
    private int size;

    public IterExample() {
        data=new Integer[10];
        size=0;
    }
    public void add(Integer value) {
        if (size==data.length) {
            Integer[] newData=new Integer[data.length*2];
            for (int i = 0; i < data.length; i++) {
                newData[i]=data[i];
            }
            data=newData;
        }
        data[size]=value;
        size++;
    }

    @Override
    public java.util.Iterator<Integer> iterator() {

        return new IterExampleIter();
    }
    private class IterExampleIter implements java.util.Iterator<Integer>{
        private int currentIndex;

        public IterExampleIter() {
            currentIndex=0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex<size;
        }

        @Override
        public Integer next() {
            Integer value=data[currentIndex];
            currentIndex++;
            return value;
        }

    }
    public static void main(String[] args) {
        IterExample example=new IterExample();
        example.add(3);
        example.add(5);
        example.add(7);
        Iterator iter= example.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next()+" ");
        }
        System.out.println();
        for (Integer value : example) {
            System.out.print(value+" ");
        }
    }
}
