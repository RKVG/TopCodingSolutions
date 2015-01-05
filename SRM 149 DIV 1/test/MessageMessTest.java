import org.junit.Test;
import static org.junit.Assert.*;

public class MessageMessTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] dictionary = new String[] {"HI", "YOU", "SAY"};
		String message = "HIYOUSAYHI";
		assertEquals("HI YOU SAY HI", new MessageMess().restore(dictionary, message));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] dictionary = new String[] {"ABC", "BCD", "CD", "ABCB"};
		String message = "ABCBCD";
		assertEquals("AMBIGUOUS!", new MessageMess().restore(dictionary, message));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] dictionary = new String[] {"IMPOSS", "SIBLE", "S"};
		String message = "IMPOSSIBLE";
		assertEquals("IMPOSSIBLE!", new MessageMess().restore(dictionary, message));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] dictionary = new String[] {"IMPOSS", "SIBLE", "S", "IMPOSSIBLE"};
		String message = "IMPOSSIBLE";
		assertEquals("IMPOSSIBLE", new MessageMess().restore(dictionary, message));
	}
}
