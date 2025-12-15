package lists;

public class ListReversEx<T> {
    public LinkedList<T> rev(LinkedList<T> list) {
        return null;
    }
    public void revInPlace(LinkedList<T> list) {}
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
