import org.junit.Test;
import static org.junit.Assert.*;

public class ProblemWritingTest {
	
	@Test(timeout=2000)
	public void test0() {
		String dotForm = "3+5";
		assertEquals("", new ProblemWriting().myCheckData(dotForm));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String dotForm = "9..+.5...*....3";
		assertEquals("", new ProblemWriting().myCheckData(dotForm));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String dotForm = "5.3+4";
		assertEquals("dotForm is not in dot notation, check character 2.", new ProblemWriting().myCheckData(dotForm));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String dotForm = "9*9*9*9*9*9*9*9*9*9*9*9*9*9";
		assertEquals("dotForm must contain between 1 and 25 characters, inclusive.", new ProblemWriting().myCheckData(dotForm));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String dotForm = "3.........../...........4";
		assertEquals("", new ProblemWriting().myCheckData(dotForm));
	}
}
