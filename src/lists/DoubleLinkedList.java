package lists;
import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<DoubleNode<T>> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;
    public DoubleLinkedList() {
        head = null;
        tail = null;
        size=0;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public boolean delete(T data) {
        DoubleNode<T> toDelete = findNode(data);
        return remove(toDelete);
    }

    public boolean addLast(T data) {
        DoubleNode<T> newNode = new DoubleNode<T>(null, tail, data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail=newNode;
        }
        size++;
        return true;
    }
    public boolean addFirst(T data) {
        DoubleNode<T> newNode = new DoubleNode<T>( head,null, data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        }
        else{
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
        return true;
    }
    public boolean addIn(DoubleNode<T> inNode, T data) {
        DoubleNode<T> newNode = new DoubleNode<T>(inNode.getNext(),inNode, data);
        inNode.setNext(newNode);
        newNode.setPrev(inNode);
        size++;
        return true;
    }
    public DoubleNode<T> findNode(T data) {
        DoubleNode<T> curr = head;
        while (curr != null) {
            if (curr.getData().equals(data)) {
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }
    public boolean remove(DoubleNode<T> killMe) {
        if (killMe == null || size == 0) {
            return false;
        }
        if (killMe == head) {
            head = killMe.getNext();
            size--;
            if (head != null) {
                head.setPrev(null);
            }

            return  true;
        }
        if (killMe == tail) {
            tail = killMe.getPrev();
            if(tail!=null) {
                tail.setNext(null);
            }
            if(size!=0) {
                size--;
            }
            return  true;
        }
        DoubleNode<T> prev=killMe.getPrev();
        DoubleNode<T> next=killMe.getNext();
        prev.setNext(next);//setPrev happen inside setNext
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        Iterator<DoubleNode<T>> iter = iterator();
        while (iter.hasNext()) {
            buffer.append(iter.next().getData() + " ");
        }
        return buffer.toString();
    }
    public Iterator<DoubleNode<T>> iterator() {
        return new DoubleListIter();
    }
    private class DoubleListIter implements Iterator<DoubleNode<T>> {
        private DoubleNode<T> inNode;
        private int gone;

        public DoubleListIter() {
            inNode = head;
            gone = 0;
        }

        @Override
        public boolean hasNext() {
            return inNode != null;
        }

        @Override
        public DoubleNode next() {
            DoubleNode<T> back = inNode;
            inNode = inNode.getNext();
            gone++;
            return back;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.println("List after adding 10, 20, 30 at the end: "+list);
        DoubleNode<Integer> node20 = list.findNode(20);
        System.out.println("Found node: " + node20);
        list.addFirst(3);
        System.out.println("List after adding 3 at the beginning:" +list);
        DoubleNode<Integer> node10 = list.findNode(10);
        System.out.println("Found node: " + node10);
        list.addIn(node20, 25);
        System.out.println("List after adding 25 after 20:"+list);
        list.remove(node20);
        System.out.println("List after removing node with data 20:"+list);
    }
}
