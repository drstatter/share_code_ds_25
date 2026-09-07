package Itrators;

import java.util.Iterator;

public class ArrayIterExample implements Iterable<Integer> {
     private Integer[] data;
     private  int size;
     ArrayIterExample(){
        this.data = new Integer[1];

     }
     public boolean add(Integer num){
         if(size == data.length){
             Integer[] temp = new Integer[size*2];
             System.arraycopy(data,0,temp,0,size);
             data = temp;
         }
         data[size] = num;
         size++;
         return true;
     }

    @Override
    public Iterator<Integer> iterator() {
        return new ArrayIterExampleItrator();
    }

    private class ArrayIterExampleItrator implements Iterator<Integer>{
        private int index;
        public ArrayIterExampleItrator(){
            this.index = 0;
        }
         @Override
         public boolean hasNext() {
             return index<size;
         }

         @Override
         public Integer next() {
             return data[index++];
         }
     }

    public static void main(String[] args) {
        ArrayIterExample arrayIterExample = new ArrayIterExample();
        arrayIterExample.add(new Integer(1));
        arrayIterExample.add(new Integer(2));
        arrayIterExample.add(new Integer(3));
        System.out.println(arrayIterExample.data.length);
        for(Integer num : arrayIterExample){
            System.out.println(num);
        }
        Iterator<Integer> iterator = arrayIterExample.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
