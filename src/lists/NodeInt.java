package lists;

public class NodeInt {
	private NodeInt next;
	private int data;
	
	
	public NodeInt(NodeInt next, int data) {
		this.next = next;
		this.data = data;
	}
	public NodeInt getNext() {
		return next;
	}
	public void setNext(NodeInt next) {
		this.next = next;
	}
	public int getData() {
		return data;
	}
	@Override
	public String toString() {
		return "LISTS.Node [next=" +( (next!=null) ? next.getData(): "null"  ) + ", data=" + data + "]";
	}
	
}
