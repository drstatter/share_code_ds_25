package lists;

import java.util.Iterator;

public class LinkedListEx2<T> implements Iterable<Node<T>> {

    private Node<T> head;

    public LinkedListEx2() {
        head=null;
    }
    public void addFirst(T data) {
        Node<T> newNode=new Node<T>(null,data);
        if (head!=null){
            newNode.setNext(head);
        }
        head=newNode;
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
        return new LinkedListEx2Iter<>();
    }
    private class LinkedListEx2Iter<E> implements Iterator<E>{
        private Node<T> inNode;

        public LinkedListEx2Iter() {
            inNode =  head;
        }
        @Override
        public boolean hasNext() {

            return (inNode!=null);  //can also check if next !=null
        }
        @Override
        public E next() {
            E back= (E) inNode;
            inNode=inNode.getNext();
            return back;
        }

    }


    public static void main(String[] args) {
        lists.LinkedListEx2<Integer> listy=new lists.LinkedListEx2<Integer>();
        listy.addFirst(4);
        listy.addFirst(3);
        Iterator<Node<Integer>> iter=listy.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().getData());
        }
    }
}


