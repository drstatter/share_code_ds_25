package lists;

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


    }
    private Node<T> sortedMerge(Node<T> a, Node<T> b){
        Node<T> result=null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        //Assuming T implements Comparable
        Comparable<T> compA=(Comparable<T>) a.getData();
        if(compA.compareTo(b.getData())<=0){
            result=a;
            result.setNext(sortedMerge(a.getNext(), b));
        }else{
            result=b;
            result.setNext(sortedMerge(a, b.getNext()));
        }
        return result;
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
}
