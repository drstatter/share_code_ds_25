package heap;
import java.util.Arrays;

public class IntMaxHeap {
    private int[] heap;
    private int size;

    public IntMaxHeap(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("capacity must be >= 1");
        this.heap = new int[capacity];
        this.size = 0;
    }

    //
    public static IntMaxHeap fromArray(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("arr is null");
        IntMaxHeap h = new IntMaxHeap(Math.max(1, arr.length));
        h.heap = Arrays.copyOf(arr, arr.length);
        h.size = arr.length;
        h.buildHeap();
        return h;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException("heap is empty");
        return heap[0];
    }

    public void insert(int value) {
        ensureCapacity(size + 1);
        heap[size] = value;
        heapyUp(size);
        size++;
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException("heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        if (size > 0) heapyDown(0);
        return max;
    }


    // ---- Private helpers ----

    private void buildHeap() {

        for (int i = parent(size - 1); i >= 0; i--) {
            heapyDown(i);
        }
    }

    private void heapyUp(int i) {
        while (i > 0) {
            int p = parent(i);
            if (heap[p] >= heap[i]) break;
            swap(p, i);
            i = p;
        }
    }

    private void heapyDown(int i) {
        while (true) {
            int left = left(i);
            int right = right(i);
            int largest = i;

            if (left < size && heap[left] > heap[largest]) largest = left;
            if (right < size && heap[right] > heap[largest]) largest = right;

            if (largest == i) break;
            swap(i, largest);
            i = largest;
        }
    }

    private void ensureCapacity(int needed) {
        if (needed <= heap.length) return;
        int newCap = Math.max(needed, heap.length * 2);
        heap = Arrays.copyOf(heap, newCap);
    }

    private static int parent(int i) { return (i - 1) / 2; }
    private static int left(int i) { return 2 * i + 1; }
    private static int right(int i) { return 2 * i + 2; }

    private void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(heap, size));
    }


    public static void main(String[] args) {
        int[] arr = {3, 10, 5, 6, 2, 8, 1};
        IntMaxHeap h = IntMaxHeap.fromArray(arr);
        System.out.println("heap = " + h);
        System.out.println("max = " + h.peek());
        System.out.println("extractMax = " + h.extractMax());
        System.out.println("heap after extract = " + h);

        h.insert(42);
        System.out.println("after insert 42 = " + h);


    }
}
