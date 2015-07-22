import org.junit.Test;
import static org.junit.Assert.*;

public class BadClockTest {
	
	@Test
	public void test0() {
		String trueTime = "07:07:07";
		String skewTime = "07:07:07";
		int hourlyGain = 1776;
		assertEquals(0.0, new BadClock().nextAgreement(trueTime, skewTime, hourlyGain), 1e-9);
	}
	
	@Test
	public void test1() {
		String trueTime = "11:59:58";
		String skewTime = "12:03:28";
		int hourlyGain = -3;
		assertEquals(70.0, new BadClock().nextAgreement(trueTime, skewTime, hourlyGain), 1e-9);
	}
	
	@Test
	public void test2() {
		String trueTime = "12:03:28";
		String skewTime = "11:59:58";
		int hourlyGain = 3;
		assertEquals(70.0, new BadClock().nextAgreement(trueTime, skewTime, hourlyGain), 1e-9);
	}
	
	@Test
	public void test3() {
		String trueTime = "03:03:02";
		String skewTime = "03:01:47";
		int hourlyGain = 5;
		assertEquals(15.0, new BadClock().nextAgreement(trueTime, skewTime, hourlyGain), 1e-9);
	}
	
	@Test
	public void test4() {
		String trueTime = "03:03:02";
		String skewTime = "03:01:47";
		int hourlyGain = -5;
		assertEquals(8625.0, new BadClock().nextAgreement(trueTime, skewTime, hourlyGain), 1e-9);
	}
	
	@Test
	public void test5() {
		String trueTime = "07:08:09";
		String skewTime = "09:08:07";
		int hourlyGain = -321;
		assertEquals(22.42367601246106, new BadClock().nextAgreement(trueTime, skewTime, hourlyGain), 1e-9);
	}
}
