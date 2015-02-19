import org.junit.Test;
import static org.junit.Assert.*;

public class SalaryTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] arrival = new String[] {"08:00:00","13:00:00","19:27:32"};
		String[] departure = new String[] {"12:00:00","17:00:00","20:48:10"};
		int wage = 1000;
		assertEquals(10015, new Salary().howMuch(arrival, departure, wage));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] arrival = new String[] {"01:05:47","16:48:12"};
		String[] departure = new String[] {"09:27:30","21:17:59"};
		int wage = 2000;
		assertEquals(33920, new Salary().howMuch(arrival, departure, wage));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] arrival = new String[] {"00:00:00"};
		String[] departure = new String[] {"23:59:59"};
		int wage = 10000;
		assertEquals(299995, new Salary().howMuch(arrival, departure, wage));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] arrival = new String[] {"10:00:00"};
		String[] departure = new String[] {"18:00:00"};
		int wage = 10000;
		assertEquals(80000, new Salary().howMuch(arrival, departure, wage));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] arrival = new String[] {"22:19:46"};
		String[] departure = new String[] {"23:12:46"};
		int wage = 5320;
		assertEquals(7049, new Salary().howMuch(arrival, departure, wage));
	}
}
