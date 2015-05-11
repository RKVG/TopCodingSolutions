import org.junit.Test;
import static org.junit.Assert.*;

public class TwainTest {
	
	@Test
	public void test0() {
		int year = 1;
		String phrase = "i fixed the chrome xerox by the cyclical church";
		assertEquals("i fiksed the chrome zeroks by the cyclical church", new Twain().getNewSpelling(year, phrase));
	}
	
	@Test
	public void test1() {
		int year = 2;
		String phrase = "i fixed the chrome xerox by the cyclical church";
		assertEquals("i fiksed the chrome zeroks bi the ciclical church", new Twain().getNewSpelling(year, phrase));
	}
	
	@Test
	public void test2() {
		int year = 0;
		String phrase = "this is unchanged";
		assertEquals("this is unchanged", new Twain().getNewSpelling(year, phrase));
	}
	
	@Test
	public void test3() {
		int year = 7;
		String phrase = "sch kn x xschrx cknnchc cyck xxceci";
		assertEquals("sk n z zskrks nchk sik zksesi", new Twain().getNewSpelling(year, phrase));
	}
	
	@Test
	public void test4() {
		int year = 7;
		String phrase = "  concoction   convalescence   cyclical   cello   ";
		assertEquals("  konkoktion   konvalesense   siklikal   selo   ", new Twain().getNewSpelling(year, phrase));
	}
	
	@Test
	public void test5() {
		int year = 7;
		String phrase = "";
		assertEquals("", new Twain().getNewSpelling(year, phrase));
	}
	
	@Test
	public void test6() {
		int year = 7;
		String phrase = "cck xzz aaaaa";
		assertEquals("k z aaaaa", new Twain().getNewSpelling(year, phrase));
	}
}
