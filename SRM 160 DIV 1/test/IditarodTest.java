import org.junit.Test;
import static org.junit.Assert.*;

public class IditarodTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] times = new String[] {"12:00 PM, DAY 1","12:01 PM, DAY 1"};
		assertEquals(241, new Iditarod().avgMinutes(times));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] times = new String[] {"12:00 AM, DAY 2"};
		assertEquals(960, new Iditarod().avgMinutes(times));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] times = new String[] {"02:00 PM, DAY 19","02:00 PM, DAY 20", "01:58 PM, DAY 20"};
		assertEquals(27239, new Iditarod().avgMinutes(times));
	}
}
