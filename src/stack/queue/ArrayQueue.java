package stack.queue;

public class ArrayQueue {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    public void enqueue(int value) {
        if (size == capacity) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear +1) % capacity;
        data[rear] = value;
        size++;
    }
    public int dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        int value = data[front];
        front = (front +1) % capacity;
        size--;
        return value;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int peek() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return data[front];

    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
