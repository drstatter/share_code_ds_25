import java.util.Iterator;

public class MyDS implements Iterable<Object> {
    private int first=3;
    private  int sec=5;

    public static void main(String[] args) {
        MyDS myDS = new MyDS();
        for (Object obj : myDS) {
            System.out.println(obj);
        }
    }
    Iterator iter;


    @Override
    public Iterator<Object> iterator() {
        return null;
    }
}
