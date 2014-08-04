import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CeyKapsTest {

    @Test
    public void test0() {
        String typed = "AAAAA";
        String[] switches = new String[]{"A:B", "B:C", "A:D"};
        assertEquals("CCCCC", new CeyKaps().decipher(typed, switches));
    }

    @Test
    public void test1() {
        String typed = "ABCDE";
        String[] switches = new String[]{"A:B", "B:C", "C:D", "D:E", "E:A"};
        assertEquals("AEBCD", new CeyKaps().decipher(typed, switches));
    }

    @Test
    public void test2() {
        String typed = "IHWSIOTCHEDMYKEYCAPSARWUND";
        String[] switches = new String[]{"W:O", "W:I"};
        assertEquals("WHOSWITCHEDMYKEYCAPSAROUND",
                new CeyKaps().decipher(typed, switches));
    }
}
