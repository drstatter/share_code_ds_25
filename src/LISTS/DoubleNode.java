package LISTS;

public class DoubleNode<T> {
    private DoubleNode<T> next;
    private DoubleNode<T> prev;
    private T data;
    public DoubleNode(DoubleNode<T> next, DoubleNode<T> prev, T data) {
        setNext(next);
        setPrev(prev);
        this.data = data;
    }
    public DoubleNode<T> getNext() {
        return next;
    }
    public void setNext(DoubleNode<T> next) {
        this.next = next;
        if(next!=null) {
            next.prev=this;
        }
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public T getData() {
        return data;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
        if(prev!=null) {
            prev.next=this;
        }
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String back= "DoubleNode{ data=" + data + " next=";
                if (next!=null) {
                    back+= next.getData();
                }
                else {
                    back+="null";
                }
                if (prev!=null) {
                    back+=", prev=" + prev.getData();
                }
                else {
                    back+=", prev=null";
                }
                back+="}";
        return back;
    }

    public static void main(String[] args) {
        DoubleNode<Integer> node1 = new DoubleNode<>(null, null, 1);
        DoubleNode<Integer> node2 = new DoubleNode<>(null, node1, 2);
        node1.setNext(node2);
        System.out.println(node1);
        System.out.println(node2);
    }
}

