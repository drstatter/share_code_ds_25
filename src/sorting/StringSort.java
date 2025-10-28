package sorting;

public class StringSort {
    // this function sort a string in alphabetical order but handle capital letters as same as small letters without changing the original string case
    public String sortString(String inputString) {
        char[] chars = inputString.toCharArray();
        // bubble sort
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                if (Character.toLowerCase(chars[j]) > Character.toLowerCase(chars[j + 1])) {
                    // swap
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        StringSort sorter = new StringSort();
        String input = "bAcD";
        String sorted = sorter.sortString(input);
        if (sorted.equals("AbcD")) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
        System.out.println("Original String: " + input);
        System.out.println("Sorted String: " + sorted); // a b c D
        //test 2
        input = "dAcD";
        sorted = sorter.sortString(input);
        System.out.println("Original String: " + input);
        System.out.println("Sorted String: " + sorted);
    }
}
