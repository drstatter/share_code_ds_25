package testX;
public class VPLGrader {
    static int score = 0;

    public static void main(String[] args) {
        try {
            // --- GROUP 1: BASIC EDGE CASES (25 pts) ---

            // 1. Delete from Empty (5 pts)
            DoubleLinkedList<Integer> empty = new DoubleLinkedList<>();
            boolean res1 = empty.delete(10);
            if (!res1 && empty.size() == 0) {
                System.out.println("Comment :=>> [PASS] Delete from empty list handled correctly.");
                score += 5;
            } else {
                System.out.println("Comment :=>> [FAIL] Delete from empty list should return false.");
            }
        }catch (Exception e) {
            System.out.println("Comment :=>> Fatal Error: " + e);
        }


        try {

            // 1. simple use case (20 pts)
            DoubleLinkedList<Integer> listy = new DoubleLinkedList<>();
            listy.addFirst(10);
            listy.addFirst(20);
            listy.addFirst(30);
            boolean res=listy.delete(20);
            if (res && listy.size() == 2) {
                System.out.println("Comment :=>> [PASS] main test.");
                score += 20;
            } else {
                System.out.println("Comment :=>> [FAIL] Delete from list should return true and size 2 .");
            }
        }catch (Exception e) {
            System.out.println("Comment :=>> Fatal Error: " + e);
        }




        try {

            // 2. Delete Only Element (10 pts)
            DoubleLinkedList<Integer> single = new DoubleLinkedList<>();
            single.addFirst(10);
            boolean res2 = single.delete(10);
            if (res2 && single.size() == 0 && single.getHead() == null && single.getTail() == null) {
                System.out.println("Comment :=>> [PASS] Delete unique element (Head/Tail cleared).");
                score += 10;
            } else {
                System.out.println("Comment :=>> [FAIL] Delete unique element failed (Head/Tail not null).");
            }
        }catch (Exception e) {
            System.out.println("Comment :=>> Fatal Error: " + e);
        }
        try {

            // 3. Delete Non-Existent (10 pts)
            DoubleLinkedList<Integer> none = new DoubleLinkedList<>();
            none.addFirst(1);
            if (!none.delete(999) && none.size() == 1) {
                System.out.println("Comment :=>> [PASS] Delete non-existing returns false.");
                score += 10;
            } else {
                System.out.println("Comment :=>> [FAIL] Delete non-existing returned true.");
            }
        }catch (Exception e) {
            System.out.println("Comment :=>> Fatal Error: " + e);
        }
        try {
            // --- GROUP 2: POSITION TESTS (30 pts) ---

            // 4. Delete Head (8 pts)
            DoubleLinkedList<Integer> headTest = new DoubleLinkedList<>();
            headTest.addFirst(10);
            headTest.addFirst(20); // 20 <-> 10
            headTest.delete(20);
            if (headTest.size() == 1 && headTest.getHead().getData() == 10 && headTest.getHead().getPrev() == null) {
                System.out.println("Comment :=>> [PASS] Delete Head logic correct.");
                score += 8;
            } else {
                System.out.println("Comment :=>> [FAIL] Delete Head logic incorrect (Check head.prev).");
            }
        }catch (Exception e) {
            System.out.println("Comment :=>> Fatal Error: " + e);
        }
        try {
            // 5. Delete Tail (7 pts)
            DoubleLinkedList<Integer> tailTest = new DoubleLinkedList<>();
            tailTest.addFirst(10);
            tailTest.addFirst(20); // 20 <-> 10
            tailTest.delete(10);
            if (tailTest.size() == 1 && tailTest.getTail().getData() == 20 && tailTest.getTail().getNext() == null) {
                System.out.println("Comment :=>> [PASS] Delete Tail logic correct.");
                score +=7;
            } else {
                System.out.println("Comment :=>> [FAIL] Delete Tail logic incorrect (Check tail.next).");
            }
        }catch (Exception e) {
            System.out.println("Comment :=>> Fatal Error: " + e);
        }
        try {
            // 6. Delete Middle (10 pts)
            DoubleLinkedList<Integer> midTest = new DoubleLinkedList<>();
            midTest.addFirst(30);
            midTest.addFirst(20);
            midTest.addFirst(10); // 10 <-> 20 <-> 30
            midTest.delete(20); // Expected: 10 <-> 30

            DoubleNode<Integer> h = midTest.getHead();
            if (h.getData() == 10 && h.getNext().getData() == 30 && h.getNext().getPrev() == h) {
                System.out.println("Comment :=>> [PASS] Delete Middle integrity correct.");
                score += 10;
            } else {
                System.out.println("Comment :=>> [FAIL] Delete Middle broken links.");
            }
        }catch (Exception e) {
            System.out.println("Comment :=>> Fatal Error: " + e);
        }
        try {


            // --- GROUP 3: COMPLEX SCENARIOS (45 pts) ---


            // 8. Sequential Clear (15 pts)
            // Add 3 items, delete them one by one until empty
            DoubleLinkedList<Integer> seq = new DoubleLinkedList<>();
            seq.addFirst(1);
            seq.addFirst(2);
            seq.addFirst(3);
            seq.delete(2);
            seq.delete(1);
            seq.delete(3);

            if (seq.isEmpty() && seq.getHead() == null && seq.getTail() == null) {
                System.out.println("Comment :=>> [PASS] Sequential Clear (Empty state reached cleanly).");
                score += 15;
            } else {
                System.out.println("Comment :=>> [FAIL] Sequential Clear failed. List not empty/clean.");
            }
        }catch (Exception e) {
            System.out.println("Comment :=>> Fatal Error: " + e);
        }
        try {
            // 9. Interleaved/Scattered Deletion (15 pts)
            // 1 <-> 2 <-> 3 <-> 4 <-> 5
            DoubleLinkedList<Integer> scat = new DoubleLinkedList<>();
            scat.addFirst(5);
            scat.addFirst(4);
            scat.addFirst(3);
            scat.addFirst(2);
            scat.addFirst(1);

            scat.delete(2); // 1, 3, 4, 5
            scat.delete(4); // 1, 3, 5

            boolean linkCheck = true;
            DoubleNode<Integer> n1 = scat.getHead();
            DoubleNode<Integer> n3 = n1.getNext();
            DoubleNode<Integer> n5 = n3.getNext();

            if (n1.getData() != 1 || n3.getData() != 3 || n5.getData() != 5) linkCheck = false;
            if (n3.getPrev() != n1 || n5.getPrev() != n3) linkCheck = false;

            if (linkCheck && scat.size() == 3) {
                System.out.println("Comment :=>> [PASS] Scattered Deletion (Links verified).");
                score += 15;
            } else {
                System.out.println("Comment :=>> [FAIL] Scattered Deletion broken links.");
            }
        }catch (Exception e) {
            System.out.println("Comment :=>> Fatal Error: " + e);
        }

        System.out.println("Grade :=>> " + score);
    }

}
