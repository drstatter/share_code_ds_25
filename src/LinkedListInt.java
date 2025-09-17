import java.util.Arrays;

public class LinkedListInt {
	private NodeInt head;
	private int size;
	public LinkedListInt() {
		head=null;
		size=0;
	}
	public void addLastNode(int data) {
		if (size==0) {
			addFirst(data);
		}
		NodeInt newNode=new NodeInt(null,data);
		NodeInt last=findLast();
		last.setNext(newNode);
		size++;
	}
	public void addFirst(int data) {
		NodeInt newNode=new NodeInt(null,data);
		if (head!=null){
			newNode.setNext(head);
		}
		head=newNode;
		size++;
	}
	private NodeInt findLast() {
		NodeInt in=head;
		while (in.getNext()!=null) {
			in=in.getNext();
		}
		return in;
	}
	private int[] toArray() {
		int[] back=new int[size];
		NodeInt in=head;
		int i=0;
		while (in!=null) {
			back[i]=in.getData();
			i++;
			in=in.getNext();
		}
		return back;
	}
	public String toString() {
		int[] allData=toArray();
		return Arrays.toString(allData);
	}
	public static void main(String[] args) {
		LinkedListInt listy=new LinkedListInt();
		listy.addFirst(4);
		listy.addFirst(3);
		System.out.println(listy);
		listy.addLastNode(8);
		System.out.println(listy);
	}
}
