package trees;

public class SearchTreeNode<T>  {
    private T data;
    private SearchTreeNode<T> left;
    private SearchTreeNode<T> right;

    public SearchTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SearchTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(SearchTreeNode<T> left) {
        this.left = left;
    }

    public SearchTreeNode<T> getRight() {
        return right;
    }

    public void setRight(SearchTreeNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        String back= "SearchTreeNode{ data=" + data + " left=";
                if (left!=null) {
                    back+= left.getData();
                }
                else {
                    back+="null";
                }
                if (right!=null) {
                    back+=", right=" + right.getData();
                }
                else {
                    back+=", right=null";
                }
                back+="}";
        return back;
    }
}
