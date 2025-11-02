package sorting;

public class CountingSort {

    public int[] sort(int[] data ,int maxSize){
        int[] back=new int[data.length];
        int[] counts = new int[maxSize];
        for( int num : data ){
            counts[num]++;
        }
        for(int i=1;i<counts.length;i++){
            counts[i]+=counts[i-1];
        }
        for(int i=data.length-1;i>=0 ;i--){
            back[counts[data[i]]-1]=data[i];
            counts[data[i]]--;
        }
        return back;
    }

    public static void main(String[] args) {
        int[] test={4,3,2,1,4,4,4,3,4};
        CountingSort cs = new CountingSort();
        int[] res=cs.sort(test,5);
        for (int num : res) {
            System.out.print(num+" ");
        }
    }
}
