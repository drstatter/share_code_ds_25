package LISTS;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<Node<T>> {
	
		private Node<T> head;
		private int size;
		public LinkedList() {
			head=null;
			size=0;
		}
		public void addLastNode(T data) {
			if (size==0) {
				addFirst(data);
			}
			Node<T> newNode=new Node<T>(null,data);
			Node<T> last=findLast();
			last.setNext(newNode);
			size++;
		}
		public void addFirst(T data) {
			Node<T> newNode=new Node<T>(null,data);
			if (head!=null){
				newNode.setNext(head);
			}
			head=newNode;
			size++;
		}
		private Node<T>findLast(){
			Iterator<Node<T>> iter=new LinkeListIter<Node<T>>();
			Node<T> back = null;
			while (iter.hasNext()) {
				back= iter.next();
            }
			return back;
		}
		private Node<T> findLast1() {
			Node<T> in=head;
			while (in.getNext()!=null) {
				in=in.getNext();
			}
			return in;
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
		private class LinkeListIter<E> implements Iterator<E>{
			private Node<T> inNode;
			private int gone;
			
			public LinkeListIter() {
				inNode =  head;
				gone = 0;
			}
			@Override
			public boolean hasNext() {
				
				return gone<size;  //can also check if next !=null 
			}
			@Override
			public E next() {
                E back= (E) inNode;
				inNode=inNode.getNext();
				gone++;
				return back;
			}
			
		}
			

		public static void main(String[] args) {
			LinkedList<Integer> listy=new LinkedList<Integer>();
			listy.addFirst(4);
			listy.addFirst(3);
			System.out.println(listy);
			listy.addLastNode(8);
			System.out.println(listy);

        }

}
