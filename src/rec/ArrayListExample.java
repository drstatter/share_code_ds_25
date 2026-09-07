package rec;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List myList = new ArrayList<String>();// שימו לוב להצהרה על INTERFACE  ולשימוש בGenerics
        myList.add("Koala");
        myList.add("are");
        myList.add("the");
        myList.add("best");//add without index will add at the end
        System.out.println(myList);

        myList.addFirst("cat and ");
        System.out.println(myList); // I dont like cats
        myList.removeFirst();
        System.out.println(myList); // was every thing removed the cat add 2 words

        myList.add(3,"fox");  // fox are smart they try to hide them self
        System.out.println(myList);
        myList.remove(3);
        System.out.println(myList);
    }
}
