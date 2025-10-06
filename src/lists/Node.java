package lists;

public class Node<T> {
	private Node<T> next;
	private T data;
	
	
	public Node(Node<T> next, T data) {
		this.next = next;
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public T getData() {
		return data;
	}
	@Override
	public String toString() {
		return "LISTS.Node [next=" +( (next!=null) ? next.getData(): "null"  ) + ", data=" + data + "]";
	}
	
}


