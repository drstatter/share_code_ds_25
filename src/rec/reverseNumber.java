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
    public int reverse2(int number) {
        if (number < 10) {
            return number;
        } else {
            return reverse2(number / 10) * 10 + number % 10;

        }
    }
    public static void main(String[] args) {
        reverseNumber reverseNumber = new reverseNumber();
        System.out.println(reverseNumber.reverse2(123));


    }
}
