package rec;

public class BinSearch {
    public final int NOT_FOUND =-1;
    public int binSearch(int[] data,int valToSearch){
        return binSearchRec(data,valToSearch,0,data.length-1);
    }
    private int binSearchRec(int[] data,int valToSearch,int start,int end){
        if(start>end){
            return NOT_FOUND;
        }else {
            int mid = (start+end)/2;
            if(data[mid]==valToSearch){
                return mid;
            }
            if(data[mid]<valToSearch){
                return binSearchRec(data,valToSearch,mid+1,end);
            }else {
                return binSearchRec(data,valToSearch,start,mid-1);}
        }
    }
    public  int binSearchIter(int[] data,int valToSearch){
        int start=0;
        int end=data.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if(data[mid]==valToSearch){
                return mid;
            }
            if(data[mid]<valToSearch){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return NOT_FOUND;
    }

    public static void main(String[] args) {
        int[] data={4,6,8,12,42,101,999};
        BinSearch binSearch = new BinSearch();
        System.out.println(binSearch.binSearch(data,12));
    }
}
