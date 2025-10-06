package stack.queue;

public class StuckArray<T> {
    private T[] data;
    private int size;
    private int capacity;

    public StuckArray(int capacity) {
        data = (T[]) new Object[capacity];
        size=0;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean push(T value) {
        if (size < data.length) {
            data[size++] = value;
            return true;
        }
        return false;
    }
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return data[--size];
    }
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return data[size - 1];
    }
    public boolean contains(T findMe) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(findMe)) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            sb.append(" ");
            }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        StuckArray<String> testMe = new StuckArray<>(5);
        testMe.push("1");
        testMe.push("2");
        testMe.push("3");
        System.out.println(testMe);
        System.out.println(testMe.peek());
        System.out.println(testMe.pop());
        testMe.push("6");
        System.out.println(testMe.pop());
        System.out.println(testMe.peek());
        System.out.println(testMe);
        System.out.println(testMe.size());
    }
}
