package trees;


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
}
