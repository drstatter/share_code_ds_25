package rec;

public class printABCDPair {
    public void printABCDPair(int size) {
        printABCDPairRec(size,true,"");
    }

    private void printABCDPairRec(int size, boolean pair, String str) {
        if (size == 1) {
            if(pair) {
                System.out.println(str+"c");
                System.out.println(str+"d");
            } else {
                System.out.println(str + "a");
                System.out.println(str + "b");
            }
        }else {
            printABCDPairRec(size-1,!pair,str+"a");
            printABCDPairRec(size-1,!pair,str+"b");
            printABCDPairRec(size-1,pair,str+"c");
            printABCDPairRec(size-1,pair,str+"d");
        }
    }

    public static void main(String[] args) {
        printABCDPair pair = new printABCDPair();
        pair.printABCDPair(4);
    }
}
