package rec;

public class BinChoose {
    //this function will calclate n choose  k using recation
    public int nChooseK(int n,int k) {
        if(n==k || k==0){
            return 1;
        }
        else {
            return nChooseK(n - 1, k - 1) + nChooseK(n - 1, k);
        }
    }

    public static void main(String[] args) {
        BinChoose binChoose = new BinChoose();
        System.out.println(binChoose.nChooseK(5,1));
    }
}
