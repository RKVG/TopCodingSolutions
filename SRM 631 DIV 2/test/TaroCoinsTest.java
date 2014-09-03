import org.junit.Test;
import static org.junit.Assert.*;

public class TaroCoinsTest {
	
	@Test(timeout=2000)
	public void test0() {
		long N = 1L;
		assertEquals(1L, new TaroCoins().getNumber(N));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long N = 6L;
		assertEquals(3L, new TaroCoins().getNumber(N));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long N = 47L;
		assertEquals(2L, new TaroCoins().getNumber(N));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long N = 256L;
		assertEquals(9L, new TaroCoins().getNumber(N));
	}
	
	@Test(timeout=2000)
	public void test4() {
		long N = 8489289L;
		assertEquals(6853L, new TaroCoins().getNumber(N));
	}
	
	@Test(timeout=2000)
	public void test5() {
		long N = 1000000000L;
		assertEquals(73411L, new TaroCoins().getNumber(N));
	}
}
