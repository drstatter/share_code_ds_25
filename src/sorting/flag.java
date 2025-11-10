package sorting;

public class flag {
    //this function will sort an array of 0s, 1s.
    public int[] sort(int[] data) {
        int low = 0;
        int mid = 0;
        int high = data.length - 1;
        while (mid <= high) {
            if (data[mid] == 0) {
                //swap data[low] and data[mid]
                int temp = data[low];
                data[low] = data[mid];
                data[mid] = temp;
                low++;
                mid++;
            } else if (data[mid] == 1) {
                mid++;
            } else {
                //swap data[mid] and data[high]
                int temp = data[mid];
                data[mid] = data[high];
                data[high] = temp;
                high--;
            }
        }
        return data;
    }

    public int[] sort2(int[] data) {
        int count = 0;
        int[] back = new int[data.length];
        for (int num : data) {
            if (num == 0) {
                count++;
            }
        }
        for (int i = count; i < back.length; i++) {
            back[i] = 1;
        }
        return back;
    }
}