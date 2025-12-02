package lists;

public class ListRevs<T> {
    //this function will reverse a linked list
    public LinkedList<T> reverse(LinkedList<T> list){
        LinkedList<T> revList=new LinkedList<T>();
        for (Node<T> data : list) {
            revList.addFirst(data.getData());
        }
        return revList;
    }

    //this function will reverse a linked list in place
    public void reverseInPlace(LinkedList<T> list) {
        Node<T> prev = null;
        Node<T> current = list.getHead();
        Node<T> next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        list.setHead(prev);

    }
    public static void main(String[] args) {
        ListRevs<Integer> listRevs = new ListRevs<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        System.out.println("Original List:");
        for (Node<Integer> node : list) {
            System.out.print(node.getData() + " ");
        }
        System.out.println();

        LinkedList<Integer> revList = listRevs.reverse(list);
        System.out.println("Reversed List (new list):");
        for (Node<Integer> node : revList) {
            System.out.print(node.getData() + " ");
        }
        System.out.println();

        listRevs.reverseInPlace(list);
        System.out.println("Reversed List (in place):");
        for (Node<Integer> node : list) {
            System.out.print(node.getData() + " ");
        }
        System.out.println();
    }

}
