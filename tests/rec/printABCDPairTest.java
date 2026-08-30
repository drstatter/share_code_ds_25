package rec;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class printABCDPairTest {

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
    public void baseCasePairPrintsCAndD() {
        printABCDPair pair = new printABCDPair();
        pair.printABCDPair(1);
        String[] lines = capturedOut.toString().split("\\r?\\n");
        assertArrayEquals(new String[]{"c", "d"}, lines);
    }
}
