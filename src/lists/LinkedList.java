package lists;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<Node<T>> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public Node<T> findNode(T data) {
        Iterator<Node<T>> iter = new LinkeListIter<Node<T>>();
        while (iter.hasNext()) {
            Node<T> current = iter.next();
            if (current.getData().equals(data)) {
                return current;
            }
        }
        return null;
    }

    //deletes first occurrence of data assume that data is in the list
    public boolean delete(T data) {
        Node<T> before = getNodeBefore(data);
        if (before == null) { //deleting head
            head = head.getNext();
            size--;
            return true;
        }
        Node<T> toDelete = before.getNext();
        before.setNext(toDelete.getNext());
        size--;
        return true;
    }

    public void addLastNode(T data) {
        if (size == 0) {
            addFirst(data);
        } else {
            Node<T> newNode = new Node<T>(null, data);
            Node<T> last = findLast();
            last.setNext(newNode);
            size++;
        }
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(null, data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    private Node<T> getNodeBefore(Node<T> node) {
        if(head==node){
            return null;
        }
        Iterator<Node<T>> iter = new LinkeListIter();
        Node<T> before = null;
        while (iter.hasNext()) {
            Node<T> current = iter.next();
            if (current.getNext() == node) {
                return current;
            }
        }
        return before;
    }

    //assume Data in the  list
    private Node<T> getNodeBefore(T data) {
        if (head.getData().equals(data)) {
            return null;
        }
        Iterator<Node<T>> iter = new LinkeListIter();
        Node<T> before = null;
        while (iter.hasNext()) {
            Node<T> current = iter.next();
            if (current.getNext().getData() == data) {
                return current;
            }
        }
        return before;
    }

    public boolean hasCycle() {
        Iterator<Node<T>> slowIter = new LinkeListIter<Node<T>>();
        Iterator<Node<T>> fastIter = new LinkeListIter<Node<T>>();
        while (fastIter.hasNext()) {
            Node<T> slowNode = slowIter.next();
            Node<T> fastNode = fastIter.next();
            if (fastIter.hasNext()) {
                fastNode = fastIter.next();
            } else {
                return false;
            }
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

    private Node<T> findLast() {
        Iterator<Node<T>> iter = new LinkeListIter<Node<T>>();
        Node<T> back = null;
        while (iter.hasNext()) {
            back = iter.next();
        }
        return back;
    }

    private Node<T> findLast1() {
        if (head == null) {
            return null;
        }
        Node<T> in = head;
        while (in.getNext() != null) {
            in = in.getNext();
        }
        return in;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Node<T> data : this) {
            buffer.append(data.getData());
            buffer.append(" ");
        }
        return buffer.toString();
    }

    @Override
    public Iterator<Node<T>> iterator() {

        return new LinkeListIter<>();
    }

    private class LinkeListIter<E> implements Iterator<E> {
        private Node<T> inNode;
        private int gone;

        public LinkeListIter() {
            inNode = head;
            gone = 0;
        }

        @Override
        public boolean hasNext() {

            return gone < size;  //can also check if next !=null
        }

        @Override
        public E next() {
            E back = (E) inNode;
            inNode = inNode.getNext();
            gone++;
            return back;
        }

    }


    public static void main(String[] args) {
        LinkedList<Integer> listy = new LinkedList<Integer>();
        listy.addFirst(4);
        listy.addFirst(3);
        System.out.println(listy);
        listy.addLastNode(8);
        System.out.println(listy);
        listy.delete(3);
        System.out.println(listy);

    }

}
