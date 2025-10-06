package lists;

public class ArrayAsList  {
    private int[] data;
    private int size;
    public ArrayAsList(int size) {
        data = new int[size];
        size=0;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean contains(Object o) {
        return false;
    }


    public boolean add(int num) {
        if (size<data.length){
            data[size++]=num;
            return true ;
        }
        return false;
    }

}
