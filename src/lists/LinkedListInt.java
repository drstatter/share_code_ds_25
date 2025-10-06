package lists;

import java.util.Arrays;

public class LinkedListInt {
	private NodeInt head;
	private int size;
    public static final int NO_FOUND=-1;
	public LinkedListInt() {
		head=null;
		size=0;
	}
	public boolean addLastNode(int data) {
		if (size==0) {
			addFirst(data);
            //whiteout this line it would add twice the first element
            return true;
		}
		NodeInt newNode=new NodeInt(null,data);
		NodeInt last=findLast();
		last.setNext(newNode);
		size++;
        return true;
	}
	public void addFirst(int data) {
		NodeInt newNode=new NodeInt(null,data);
        // no need to check this
		if (head!=null){
			newNode.setNext(head);
		}
		head=newNode;
		size++;
	}
	private NodeInt findLast() {
        // using iterator would be better
        // can head be null here ?
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
     public int deleteData(int data) {
        if (size==0) {
            return NO_FOUND; // list is empty
        }
        if (head.getData()==data) {
            head=head.getNext();
            size--;
            return data;
        }
        NodeInt current=head;
        while(current.getNext()!=null) {
            if (current.getNext().getData()==data) {
                int back= current.getNext().getData();
                current.setNext(current.getNext().getNext());
                size--;
                return back;
            }
            else {
                current = current.getNext();
            }
        }
        return NO_FOUND;
     }


//
//        NodeInt current=head;
//        while (current.getNext()!=null && current.getNext().getData()!=data) {
//            current=current.getNext();
//        }
//        if (current.getNext()==null) {
//            return -1; // data not found
//        }
//        current.setNext(current.getNext().getNext());
//        size--;
//        return data;
	public static void main(String[] args) {
		LinkedListInt listy=new LinkedListInt();
        listy.addLastNode(7);
		listy.addFirst(4);
		listy.addFirst(3);

		listy.addLastNode(8);
		System.out.println(listy);
        System.out.println(listy.deleteData(31));
        System.out.println(listy.deleteData(3));
        System.out.println(listy);

	}
}
