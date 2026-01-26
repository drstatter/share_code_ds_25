package testEx;

public class FindCommonNodeList<T> {
    public Node findCommonNode(LinkedList<T> list1, LinkedList<T> list2) {
        Node node1 = list1.getHead();
        Node node2 = list2.getHead();
        if (node1 == null || node2 == null) {
            return null;
        }
        int times = list1.getSize() + list2.getSize()+1;
        while (node1 != node2 && times>0) {
            times--;
            if (node1.getNext() == null) {
                node1 = list2.getHead();
            } else {
                node1 = node1.getNext();
            }
            if (node2.getNext() == null) {
                node2 = list1.getHead();
            } else {
                node2 = node2.getNext();
            }
        }
        return node1;
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

        FindCommonNodeList<Integer> finder = new FindCommonNodeList<>();
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
