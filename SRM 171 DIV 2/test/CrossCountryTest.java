import org.junit.Test;
import static org.junit.Assert.*;

public class CrossCountryTest {
	
	@Test
	public void test0() {
		int numTeams = 2;
		String finishOrder = "AABBABBABBA";
		assertEquals("AB", new CrossCountry().scoreMeet(numTeams, finishOrder));
	}
	
	@Test
	public void test1() {
		int numTeams = 3;
		String finishOrder = "CCCBBBBBAAACC";
		assertEquals("BC", new CrossCountry().scoreMeet(numTeams, finishOrder));
	}
	
	@Test
	public void test2() {
		int numTeams = 4;
		String finishOrder = "ABDCBADBDCCDBCDBCAAAC";
		assertEquals("BDCA", new CrossCountry().scoreMeet(numTeams, finishOrder));
	}
	
	@Test
	public void test3() {
		int numTeams = 10;
		String finishOrder = "BDHCEAJBIDBCCHGCBDJEBAAHEGAGGADHGIECJEHAEBDADJCDHG";
		assertEquals("BCDAHEG", new CrossCountry().scoreMeet(numTeams, finishOrder));
	}
	
	@Test
	public void test4() {
		int numTeams = 3;
		String finishOrder = "BABCAABABAB";
		assertEquals("AB", new CrossCountry().scoreMeet(numTeams, finishOrder));
	}
}
