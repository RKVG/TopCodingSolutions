import org.junit.Test;
import static org.junit.Assert.*;

public class BracketExpressionsTest {
	
	@Test(timeout=2000)
	public void test0() {
		String expression = "([]{})";
		assertEquals("possible", new BracketExpressions().ifPossible(expression));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String expression = "(())[]";
		assertEquals("possible", new BracketExpressions().ifPossible(expression));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String expression = "({])";
		assertEquals("impossible", new BracketExpressions().ifPossible(expression));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String expression = "[]X";
		assertEquals("impossible", new BracketExpressions().ifPossible(expression));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String expression = "([]X()[()]XX}[])X{{}}]";
		assertEquals("possible", new BracketExpressions().ifPossible(expression));
	}
}
