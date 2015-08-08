import org.junit.Test;
import static org.junit.Assert.*;

public class BirthdayOddsTest {
	
	@Test
	public void test0() {
		int minOdds = 75;
		int daysInYear = 5;
		assertEquals(4, new BirthdayOdds().minPeople(minOdds, daysInYear));
	}
	
	@Test
	public void test1() {
		int minOdds = 50;
		int daysInYear = 365;
		assertEquals(23, new BirthdayOdds().minPeople(minOdds, daysInYear));
	}
	
	@Test
	public void test2() {
		int minOdds = 1;
		int daysInYear = 365;
		assertEquals(4, new BirthdayOdds().minPeople(minOdds, daysInYear));
	}
	
	@Test
	public void test3() {
		int minOdds = 84;
		int daysInYear = 9227;
		assertEquals(184, new BirthdayOdds().minPeople(minOdds, daysInYear));
	}
}
