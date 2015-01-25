import org.junit.Test;
import static org.junit.Assert.*;

public class CalendarRecycleTest {
	
	@Test
	public void test0() {
		int year = 2002;
		assertEquals(2013, new CalendarRecycle().useAgain(year));
	}
	
	@Test
	public void test1() {
		int year = 2013;
		assertEquals(2019, new CalendarRecycle().useAgain(year));
	}
	
	@Test
	public void test2() {
		int year = 2008;
		assertEquals(2036, new CalendarRecycle().useAgain(year));
	}
	
	@Test
	public void test3() {
		int year = 9999;
		assertEquals(10010, new CalendarRecycle().useAgain(year));
	}
	
	@Test
	public void test4() {
		int year = 2525;
		assertEquals(2531, new CalendarRecycle().useAgain(year));
	}
}
