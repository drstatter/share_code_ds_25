
package trees;
import java.util.List;

public class SearchTree<T extends Comparable<T>> {
    private SearchTreeNode<T> root;

    public SearchTree() {
        this.root = null;

    }

    public SearchTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(SearchTreeNode<T> root) {
        this.root = root;
    }
    public boolean add(T data) {
        if (root == null) {
            root = new SearchTreeNode<T>(data);
            return true;
        }
        return addRecursive(root, data);
    }

    private boolean addRecursive(SearchTreeNode<T> current, T data) {
        if (data.compareTo(current.getData()) < 0) {
            if (current.getLeft() == null) {
                current.setLeft(new SearchTreeNode<T>(data));
                return true;
            } else {
                return addRecursive(current.getLeft(), data);
            }
        } else {
            if (data.compareTo(current.getData()) > 0) {
                if (current.getRight() == null) {
                    current.setRight(new SearchTreeNode<T>(data));
                    return true;
                } else {
                    return addRecursive(current.getRight(), data);
                }
            } else {
                // value already exists
                return false;
            }
        }
    }
    public SearchTreeNode<T> findParent(T data) {
        if (root == null) {
            return null;
        }
        SearchTreeNode<T> current = root;
        SearchTreeNode<T> parent = null;
        while (current != null) {
            if (data.equals(current.getData())) {
                return parent;
            }
            parent = current;
            if (data.compareTo(current.getData()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null; // Not found
    }
    public SearchTreeNode<T> find(T data) {
        return findRecursive(root, data);
    }
    private SearchTreeNode<T> findRecursive(SearchTreeNode<T> current, T data) {
        if (current == null) {
            return null;
        }
        if (data.equals(current.getData())) {
            return current;
        }
        if (data.compareTo(current.getData()) < 0) {
            return findRecursive(current.getLeft(), data);
        } else {
            return findRecursive(current.getRight(), data);
        }
    }
    public SearchTreeNode<T> successor(SearchTreeNode<T> node) {
        if (node == null){
            return null;
        }
        if (node.getRight() == null) {
            return findLeftParent(node);
        }
        SearchTreeNode<T> current = node.getRight();
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    private SearchTreeNode<T> findLeftParent(SearchTreeNode<T> node) {
        SearchTreeNode<T> current = root;
        SearchTreeNode<T> back = null;
        while (current != null) {
            if (node.getData().compareTo(current.getData()) < 0) {
                back = current;
                current = current.getLeft();
            } else if (node.getData().compareTo(current.getData()) > 0) {
                current = current.getRight();
            } else {
                break;
            }
        }
        return back;
    }
    public SearchTreeNode<T> findRightParent(SearchTreeNode<T> node) {
        SearchTreeNode<T> current = root;
        SearchTreeNode<T> back = null;
        while (current != null) {
            if (node.getData().compareTo(current.getData()) < 0) {
                current = current.getLeft();
            } else if (node.getData().compareTo(current.getData()) > 0) {
                back = current;
                current = current.getRight();
            } else {
                break;
            }
        }
        return back;
    }

    public boolean remove(SearchTreeNode killMe) {
        if (killMe == null || root == null) {
            return false;
        }
        SearchTreeNode<T> parent = findParent((T) killMe.getData());
        // Case 1: Node to be deleted is a leaf node
        if (killMe.getLeft() == null && killMe.getRight() == null) {
            if (parent == null) { // Node to be deleted is root
                root = null;
            } else if (parent.getLeft() == killMe) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            return true;
        }
        // Case 2: Node to be deleted has one child
        else if (killMe.getLeft() == null || killMe.getRight() == null) {
            SearchTreeNode<T> child = (killMe.getLeft() != null) ? killMe.getLeft() : killMe.getRight();
            if (parent == null) { // Node to be deleted is root
                root = child;
            } else if (parent.getLeft() == killMe) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
            return true;
        }
        // Case 3: Node to be deleted has two children
        else {
            SearchTreeNode<T> successor = successor(killMe);
            T successorValue = successor.getData();
            remove(successor); // Remove the successor node
            killMe.setData(successorValue); // Replace value
            return true;
        }

    }



    public static void main(String[] args) {
        SearchTree<Integer> tree = new SearchTree<>();
        tree.add(11);
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);
        tree.add(13);

        System.out.println("Root: " + tree.getRoot());
        System.out.println("Find 7: " + tree.find(7));
        System.out.println("Find 20: " + tree.find(20));
        System.out.println("Parent of 7: " + tree.findParent(7));
        System.out.println("Parent of 10: " + tree.findParent(10));
        System.out.println("Successor of 10: " + tree.successor(tree.find(10)));
        System.out.println("Successor of 15: " + tree.successor(tree.find(15)));
        System.out.println("Successor of 11: " + tree.successor(tree.find(11)));
        System.out.println("Successor of 7: " + tree.successor(tree.find(7)));
    }


    public void inOrderTraversal(SearchTreeNode<T> node, List<T> back) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), back);
            back.add(node.getData());
            inOrderTraversal(node.getRight(), back);
        }
    }
}
