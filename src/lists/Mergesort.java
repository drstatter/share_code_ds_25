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
        //data.setHead(sortedMerge(left.getHead(), right.getHead()));
        data.setHead(sortedMergeIter(left, right));


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
        Node<T> head1=list1.getHead();
        Node<T> head2=list2.getHead();
        Node<T> dummy=new Node<T>(null, null);
        Node<T> tail=dummy;

        while(head1!=null && head2!=null){
            Comparable<T> compA=(Comparable<T>) head1.getData();
            if(compA.compareTo(head2.getData())<=0){
                tail.setNext(head1);
                head1=head1.getNext();
            }else{
                tail.setNext(head2);
                head2=head2.getNext();
            }
            tail=tail.getNext();
        }
        if(head1!=null){
            tail.setNext(head1);
        }else{
            tail.setNext(head2);
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
