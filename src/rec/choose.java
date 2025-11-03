package rec;

public class choose {
    //this function will calclate n chose k using recation
    public int nChooseK(int n,int k) {
        if(n==k || k==0){
            return 1;
        }
        else {
            return nChooseK(n - 1, k - 1) + nChooseK(n - 1, k);
        }
    }







}
