package rec;

public class No2A {
    //this function will print all the string over a.b without two consecutive As
    public void printWithout2A(int size){
        printWithout2ARec(size,"");
    }
    private void printWithout2ARec(int size,String str){
        if(size==0){
            System.out.println(str);
        }else {
            printWithout2ARec(size-1,str+"b");
            if(str.length()==0 || str.charAt(str.length()-1)!='a'){
                printWithout2ARec(size-1,str+"a");
            }
        }
    }

    public static void main(String[] args) {
        No2A no2A = new No2A();
        no2A.printWithout2A(4);
    }
}
