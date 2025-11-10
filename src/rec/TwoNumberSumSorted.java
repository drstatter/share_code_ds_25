package rec;

public class TwoNumberSumSorted {
    //This function will check if there are 2 numbers small and big in a sorted array data , in such a way that small+ big equals sum
    public boolean subsetSumSorted(int[] data, int sum) {
        return subsetSumSortedRec(data, sum, 0, data.length - 1);
    }

    private boolean subsetSumSortedRec(int[] data, int sum, int start, int end) {
        if (data == null || start >= end) {
            return false;
        } else {
            int currentSum = data[start] + data[end];
            if (currentSum == sum) {
                return true;
            }
            if (currentSum < sum) {
                return subsetSumSortedRec(data, sum, start + 1, end);
            } else {
                return subsetSumSortedRec(data, sum, start, end - 1);
            }
        }
    }
    public boolean SubsetSumSortedIter(int[] data, int sum) {
        int start = 0;
        int end = data.length - 1;
        while (start < end) {
            int currentSum = data[start] + data[end];
            if (currentSum == sum) {
                return true;
            }
            if (currentSum < sum) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 6, 8, 9, 11, 15, 20};
        TwoNumberSumSorted twoNumberSumSorted = new TwoNumberSumSorted();
        System.out.println(twoNumberSumSorted.subsetSumSorted(data, 14));
        System.out.println(twoNumberSumSorted.SubsetSumSortedIter(data, 14));
        System.out.println(twoNumberSumSorted.subsetSumSorted(data, 30));
        System.out.println(twoNumberSumSorted.SubsetSumSortedIter(data, 30));

    }
}
