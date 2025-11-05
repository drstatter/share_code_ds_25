package rec;

public class reverseNumber {
    //this function will reverse a number using recation
    public int reverse(int number) {
        return reverseRec(number, 0);
    }
    private int reverseRec(int number, int rev) {
        if (number == 0) {
            return rev;
        } else {
            rev = rev * 10 + number % 10;
            return reverseRec(number / 10, rev);
        }
    }
    public static void main(String[] args) {
        reverseNumber reverseNumber = new reverseNumber();
        System.out.println(reverseNumber.reverse(123));
        System.out.println(reverseNumber.reverse(-123));


    }
}
