package hash;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class studentExample {

    private String address;
    private int id;
    private String fName;
    private String lName;
    public studentExample(String address, int id, String fName, String lName) {
        this.address = address;
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        studentExample that = (studentExample) o;
        return Objects.equals(fName, that.fName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fName, lName);
    }

    public static void main(String[] args) {
        studentExample student1 = new studentExample("123 Main St", 1, "John", "Snow");
        studentExample student2 = new studentExample("456 Elm St", 2, "John", "Snow");
        studentExample student3 = new studentExample("1114567 Elm St", 3, "John", "S");
        studentExample student4 = new studentExample("1114 Elm St", 4, "rob", "S");
//k
        System.out.println("student1.equals(student2): " + student1.equals(student2));
        System.out.println("student1.hashCode(): " + student1.hashCode());
        System.out.println("student2.hashCode(): " + student2.hashCode());
        System.out.println("student3.hashCode(): " + student3.hashCode());
        Set<studentExample> mySet=new HashSet<>();
        mySet.add(student1);
        mySet.add(student2);
        mySet.add(student3);
        mySet.add(student4);
        System.out.println(mySet.size());
    }
}
