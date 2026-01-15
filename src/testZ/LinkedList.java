package testZ;

import lists.Node;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<Node<T>> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }



    public void addLastNode(T data) {

    }


    public void addFirst(T data) {


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
        System.out.println(listy+" need to be 4");
        listy.addFirst(3);
        System.out.println(listy +"  need to be 3 4");
        listy.addLastNode(8);
        System.out.println(listy+"  need to be 3 4 8 ");
        System.out.println(listy.size+ " need to be  3 ");
    }

}
