package testZ;
import java.util.Stack;
import java.util.Arrays;

public class NearestSmallerToLeftSol {

    public  int[] nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8,40,3};
        NearestSmallerToLeftSol solver = new NearestSmallerToLeftSol();
        System.out.println(Arrays.toString(solver.nearestSmallerToLeft(arr)));
    }
}

