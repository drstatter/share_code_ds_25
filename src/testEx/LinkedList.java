package testEx;

public class LinkedList<T>  {

    private Node<T> head;


    public LinkedList() {
        head = null;

    }

    public void addLastNode(T data) {
        if (head == null) {
            addFirst(data);
        } else {
            Node<T> newNode = new Node<T>(null, data);
            Node<T> last = findLast1();
            last.setNext(newNode);
        }
    }

    public void addLastNode(Node<T> data) {
        data.setNext(null);
        if (head == null) {
            head = data;
        } else {
            Node<T> last = findLast1();
            last.setNext(data);
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
    public int getSize(){
        Node<T> pos = head;
        int count = 0;
        while (pos != null) {
            pos = pos.getNext();
            count++;
        }
        return count;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(null, data);
        newNode.setNext(head);
        head = newNode;
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



