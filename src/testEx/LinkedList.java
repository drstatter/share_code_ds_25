package testEx;


public class LinkedList<T>  {

    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addLastNode(T data) {
        if (size == 0) {
            addFirst(data);
        } else {
            Node<T> newNode = new Node<T>(null, data);
            Node<T> last = findLast1();
            last.setNext(newNode);
            size++;
        }
    }

    public void addLastNode(Node<T> data) {
        data.setNext(null);
        if (size == 0) {
            head = data;
            size = 1;

        } else {
            Node<T> last = findLast1();
            last.setNext(data);
            size++;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
    public int getSize(){ return size;}

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(null, data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }



    public String toString() {
        StringBuilder buffer = new StringBuilder();
        Node data=head;
        while (data!=null) {
            buffer.append(data.getData());
            buffer.append(" ");
            data=data.getNext();
        }
        return buffer.toString();
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
}



