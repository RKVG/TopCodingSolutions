import org.junit.Test;
import static org.junit.Assert.*;

public class JustifierTest {
	
	@Test
	public void test0() {
		String[] textIn = new String[] {"BOB","TOMMY","JIM"};
		assertArrayEquals(new String[] { "  BOB",  "TOMMY",  "  JIM" }, new Justifier().justify(textIn));
	}
	
	@Test
	public void test1() {
		String[] textIn = new String[] {"JOHN","JAKE","ALAN","BLUE"};
		assertArrayEquals(new String[] { "JOHN",  "JAKE",  "ALAN",  "BLUE" }, new Justifier().justify(textIn));
	}
	
	@Test
	public void test2() {
		String[] textIn = new String[] {"LONGEST","A","LONGER","SHORT"};
		assertArrayEquals(new String[] { "LONGEST",  "      A",  " LONGER",  "  SHORT" }, new Justifier().justify(textIn));
	}
}
