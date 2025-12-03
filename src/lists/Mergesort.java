package lists;

import java.util.Iterator;

public class Mergesort<T> {
    //This method will sort the linked list using merge sort algorithm
    public void mergeSort(LinkedList<T> data){
        if(data.getHead()==null || data.getHead().getNext()==null){
            return; //size<=1 list is already sorted
        }
        //split the list into two halves
        Node<T> middle=getMiddle(data.getHead());
        Node<T> nextOfMiddle=middle.getNext();
        middle.setNext(null); //split the list into two halves

        LinkedList<T> left=new LinkedList<T>();
        left.setHead(data.getHead());
        LinkedList<T> right=new LinkedList<T>();
        right.setHead(nextOfMiddle);

        //recursively sort the two halves
        mergeSort(left);
        mergeSort(right);

        //merge the sorted halves
        data.setHead(sortedMerge(left.getHead(), right.getHead()));
        //data.setHead(sortedMergeIter(left, right));


    }
    private Node<T> sortedMerge(Node<T> node1, Node<T> node2){
        Node<T> result=null;
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        //Assuming T implements Comparable
        Comparable<T> compA=(Comparable<T>) node1.getData();
        if(compA.compareTo(node2.getData())<=0){
            result=node1;
            result.setNext(sortedMerge(node1.getNext(), node2));
        }else{
            result=node2;
            result.setNext(sortedMerge(node1, node2.getNext()));
        }
        return result;
    }
    private Node<T> sortedMergeIter(LinkedList<T> list1, LinkedList<T> list2){
        Node<T> dummy=new Node<T>(null, null);
        Iterator<Node<T>> iterator1=list1.iterator();
        Iterator<Node<T>> iterator2=list2.iterator();
        Node<T> tail=dummy;
        while(iterator2.hasNext() && iterator1.hasNext()){
            Node<T> node1=iterator1.next();
            Node<T> node2=iterator2.next();
            Comparable<T> compA=(Comparable<T>) node1.getData();
            T compB=node2.getData();
            if(compA.compareTo(compB)<=0){
                tail.setNext(node1);
            }else{
                tail.setNext(node2);

            }
            tail=tail.getNext();
        }
        //append the remaining nodes
        if(iterator1.hasNext()){
            tail.setNext(iterator1.next());
        }
        if(iterator2.hasNext()) {
            tail.setNext(iterator2.next());
        }
        return dummy.getNext();

    }
    private Node<T> getMiddle(Node<T> head){
        if(head==null){
            return head;
        }
        Node<T> slow=head;
        Node<T> fast=head.getNext();
        while(fast!=null){
            fast=fast.getNext();
            if(fast!=null){
                slow=slow.getNext();
                fast=fast.getNext();
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedList<Integer> listy = new LinkedList<Integer>();
        listy.addFirst(4);
        listy.addFirst(2);
        listy.addFirst(5);
        listy.addFirst(1);
        listy.addFirst(3);
        System.out.println("Unsorted List: " + listy);
        Mergesort<Integer> sorter = new Mergesort<Integer>();
        sorter.mergeSort(listy);
        System.out.println("Sorted List: " + listy);
    }
}
