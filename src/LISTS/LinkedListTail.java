package LISTS;

public class LinkedListTail<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListTail() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    //Add to the end of the list
    public boolean add(T data) {
        Node<T> newNode = new Node<T>(null, data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        return true;
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedData;
        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
            if (head == null) { // List became empty
                tail = null;
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node<T> nodeToRemove = current.getNext();
            removedData = nodeToRemove.getData();
            current.setNext(nodeToRemove.getNext());
            if (nodeToRemove == tail) { // Removed the tail
                tail = current;
            }
        }
        size--;
        return removedData;
    }
    public T removeData(T data) {
        Node<T> current = head;
        T back=null;
        if(current == null) {
            return null; // List is empty
        }
        if (current.getData().equals(data)) {
            head = head.getNext();
            back = current.getData();
            size--;
            if (head == null) { // List became empty
                tail = null;
            }
        }
        while (current.getNext() != null) {
            back = current.getNext().getData();
            if(data.equals(back)) {
                current.setNext(current.getNext().getNext());
                size--;
                if (current.getNext() == null) { // Removed the tail
                    tail = current;
                }
                return back; // Data found and removed
            }
            current = current.getNext();
        }
        return null; // Data not found
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData()).append(" -> ");
            current = current.getNext();
        }
        sb.append("null");
        sb.append(" \n");
        sb.append(head.toString());
        sb.append(" \n");
        sb.append(tail.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListTail<Integer> list = new LinkedListTail<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list); // 1 -> 2 -> 3 -> null
        System.out.println("Size: " + list.size()); // Size: 3
        System.out.println("Element at index 1: " + list.get(1)); // Element at index 1: 2
      //  System.out.println("Removed element: " + list.remove(2));
        System.out.println(list);// Removed element: 2
        System.out.println("Size after removal: " + list.size()); // Size after removal: 2
        System.out.println("Removed data 3: " + list.removeData(1)); // Removed data 3: 3
        System.out.println("Size after removing data 3: " + list.size());
        // Size after removing data 3: 1
        System.out.println(list);
    }

}
