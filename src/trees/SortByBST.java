package trees;

import java.util.ArrayList;
import java.util.List;

public class SortByBST<T extends Comparable<T>> {
    private SearchTree<T> bst;
    public SortByBST() {
        bst = new SearchTree<>();
    }

    public  void addArr(T[] array) {

        for (T item : array) {
            bst.add(item);
        }

    }
    public List<T> sortArr(T[] array) {
        addArr(array);
        List<T> back = new ArrayList<>();
        bst.inOrderTraversal(bst.getRoot(), back);
        return back;
    }

    public static void main(String[] args) {
        SortByBST<Integer> sorter = new SortByBST<>();
        Integer[] array = {5, 3, 8, 1, 4, 7, 9};
        List<Integer> sortedList = sorter.sortArr(array);
        System.out.println("Sorted List: " + sortedList);
    }
}
