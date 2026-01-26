package testEx;

public class FindCommonNodeListSk<T> {
    public Node findCommonNode(LinkedList<T> l1, LinkedList<T> l2) {
        return null;
    }
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.addLastNode(1);
        l1.addLastNode(2);
        Node<Integer> common = new Node<>(null, 4);
        l1.addLastNode(common);
        l1.addLastNode(3);
        l1.addFirst(5);
        l2.addLastNode(6);
        l2.addLastNode(common);
        l2.addLastNode(7);

        FindCommonNodeListSk<Integer> finder = new FindCommonNodeListSk<>();
        Node commonNode = finder.findCommonNode(l1, l2);
        if (commonNode != null) {
            System.out.println("Common node data: " + commonNode.getData());
        } else {
            System.out.println("No common node found.");
        }
        System.out.println(l1);
        System.out.println(l2);
    }

}

