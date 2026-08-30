package rec;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class No2ATest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream capturedOut;

    @Before
    public void setUp() {
        capturedOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOut));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void printsAllCombinationsWithoutTwoConsecutiveAs() {
        No2A no2A = new No2A();
        no2A.printWithout2A(2);
        String[] lines = capturedOut.toString().split("\\r?\\n");
        assertArrayEquals(new String[]{"bb", "ba", "ab"}, lines);
    }
}
