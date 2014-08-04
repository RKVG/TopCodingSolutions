import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageMessTest {

	@Test
	public void test0() {
		String[] dictionary = new String[] {"HI", "YOU", "SAY"};
		String message = "HIYOUSAYHI";
		assertEquals("HI YOU SAY HI", new MessageMess().restore(dictionary,
                message));
	}

	@Test
	public void test1() {
		String[] dictionary = new String[] {"ABC", "BCD", "CD", "ABCB"};
		String message = "ABCBCD";
		assertEquals("AMBIGUOUS!", new MessageMess().restore(dictionary,
                message));
	}

	@Test
	public void test2() {
		String[] dictionary = new String[] {"IMPOSS", "SIBLE", "S"};
		String message = "IMPOSSIBLE";
		assertEquals("IMPOSSIBLE!", new MessageMess().restore(dictionary,
                message));
	}

	@Test
	public void test3() {
		String[] dictionary = new String[] {"IMPOSS", "SIBLE", "S", "IMPOSSIBLE"};
		String message = "IMPOSSIBLE";
		assertEquals("IMPOSSIBLE", new MessageMess2().restore(dictionary,
                message));
	}

    @Ignore
    @Test
    public void test27()  {
        String[] dictionary = new String[] {"H", "HH", "HHCH"};
        String message = "HHHHHHHHHHHHHHHHHHHHHHHHHHHCHHHHHHHHHHHHHHHHHHHHC";
        assertEquals("IMPOSSIBLE!", new MessageMess().restore(dictionary,
                message));
    }

    @Test
    public void test27b()  {
        String[] dictionary = new String[] {"H", "HH", "HHCH"};
        String message = "HHHHHHHCHHHHHC";
        assertEquals("IMPOSSIBLE!", new MessageMess().restore(dictionary,
                message));
    }

}
