package hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class studentExampleTest {

    @Test
    public void equalsOnlyComparesFirstName() {
        studentExample s1 = new studentExample("123 Main St", 1, "John", "Snow");
        studentExample s2 = new studentExample("456 Elm St", 2, "John", "Doe");
        assertTrue(s1.equals(s2));
    }

    @Test
    public void equalsReturnsFalseForDifferentFirstName() {
        studentExample s1 = new studentExample("123 Main St", 1, "John", "Snow");
        studentExample s2 = new studentExample("456 Elm St", 2, "Rob", "Snow");
        assertFalse(s1.equals(s2));
    }

    @Test
    public void hashCodeUsesFirstAndLastName() {
        studentExample s1 = new studentExample("123 Main St", 1, "John", "Snow");
        studentExample s2 = new studentExample("456 Elm St", 2, "John", "Snow");
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void hashCodeDiffersForDifferentLastName() {
        studentExample s1 = new studentExample("123 Main St", 1, "John", "Snow");
        studentExample s3 = new studentExample("789 Elm St", 3, "John", "S");
        assertNotEquals(s1.hashCode(), s3.hashCode());
    }

    @Test
    public void equalsReturnsFalseForNullOrDifferentClass() {
        studentExample s1 = new studentExample("123 Main St", 1, "John", "Snow");
        assertFalse(s1.equals(null));
        assertFalse(s1.equals("not a student"));
    }
}
