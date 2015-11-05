import org.junit.Test;
import static org.junit.Assert.*;

public class MatchingTest {
	
	@Test
	public void test0() {
		String[] first = new String[] {"DIAMOND","BLUE","SOLID","ONE"}
;
		String[] second = new String[] {"DIAMOND","GREEN","SOLID","TWO"}
;
		assertArrayEquals(new String[] { "DIAMOND",  "RED",  "SOLID",  "THREE" }, new Matching().findMatch(first, second));
	}
	
	@Test
	public void test1() {
		String[] first = new String[] {"CIRCLE","GREEN","EMPTY","TWO"}
;
		String[] second = new String[] {"DIAMOND","BLUE","STRIPED","ONE"}
;
		assertArrayEquals(new String[] { "SQUIGGLE",  "RED",  "SOLID",  "THREE" }, new Matching().findMatch(first, second));
	}
	
	@Test
	public void test2() {
		String[] first = new String[] {"DIAMOND","RED","SOLID","ONE"}
;
		String[] second = new String[] {"SQUIGGLE","BLUE","SOLID","TWO"}
;
		assertArrayEquals(new String[] { "CIRCLE",  "GREEN",  "SOLID",  "THREE" }, new Matching().findMatch(first, second));
	}
	
	@Test
	public void test3() {
		String[] first = new String[] {"SQUIGGLE","RED","STRIPED","ONE"}
;
		String[] second = new String[] {"SQUIGGLE","RED","STRIPED","ONE"}
;
		assertArrayEquals(new String[] { "SQUIGGLE",  "RED",  "STRIPED",  "ONE" }, new Matching().findMatch(first, second));
	}
}
