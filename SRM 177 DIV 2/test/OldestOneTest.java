import org.junit.Test;
import static org.junit.Assert.*;

public class OldestOneTest {
	
	@Test
	public void test0() {
		String[] data = new String[] {"DOUG JONES 22 213 ALDEN LANE","   BOB     A SMITH  102 CLARK ST"};
		assertEquals("BOB     A SMITH", new OldestOne().oldest(data));
	}
	
	@Test
	public void test1() {
		String[] data = new String[] {"DOUG JONES 102 213 ALDEN LANE","   BOB     A SMITH  102 CLARK ST",
 "A 1 999ELM"};
		assertEquals("DOUG JONES", new OldestOne().oldest(data));
	}
	
	@Test
	public void test2() {
		String[] data = new String[] {"DOUG JONES 122 213 ALDEN LANE","   BOB     A SMITH  102 CLARK ST",
 "A 199 ELM"};
		assertEquals("A", new OldestOne().oldest(data));
	}
	
	@Test
	public void test3() {
		String[] data = new String[] {"   DOUG                 JONES   122 213 ALDEN LANE",
"   BOB     A SMITH                       102  3",
 " J O H N N Y           199 ELM"};
		assertEquals("J O H N N Y", new OldestOne().oldest(data));
	}
}
