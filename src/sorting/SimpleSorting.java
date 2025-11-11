package sorting;

public class SimpleSorting {
    public Comparable[] bubbleSort(Comparable[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    // swap data[j] and data[j+1]
                    Comparable temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }
    public Comparable[] selectionSort(Comparable[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // swap data[i] and data[minIndex]
            Comparable temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        return data;
    }

    public Comparable [] insertionSort(Comparable[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            Comparable key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j].compareTo(key) > 0) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
        return data;
    }

    public static void main(String[] args) {
        SimpleSorting sorter = new SimpleSorting();
        Integer[] data = {5, 2, 9, 1, 5, 6};

        Comparable[] bubbleSorted = sorter.bubbleSort(data.clone());
        System.out.println("Bubble Sorted:");
        for (Comparable num : bubbleSorted) {
            System.out.print(num + " ");
        }
        System.out.println();

        Comparable[] selectionSorted = sorter.selectionSort(data.clone());
        System.out.println("Selection Sorted:");
        for (Comparable num : selectionSorted) {
            System.out.print(num + " ");
        }
        System.out.println();

        Comparable[] insertionSorted = sorter.insertionSort(data.clone());
        System.out.println("Insertion Sorted:");
        for (Comparable num : insertionSorted) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
