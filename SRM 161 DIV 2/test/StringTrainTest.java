import org.junit.Test;
import static org.junit.Assert.*;

public class StringTrainTest {
	
	@Test
	public void test0() {
		String[] cars = new String[] {"ABCDE","CDFFF","CDE","CDEGG","GABC"};
		assertEquals("10 DEGABC", new StringTrain().buildTrain(cars));
	}
	
	@Test
	public void test1() {
		String[] cars = new String[] {"AAAAA","AAAAA","AAAAA"};
		assertEquals("7 A", new StringTrain().buildTrain(cars));
	}
	
	@Test
	public void test2() {
		String[] cars = new String[] {"CABABDABAB","CABAB","ABABDABAB","DABAB"};
		assertEquals("15 CDAB", new StringTrain().buildTrain(cars));
	}
	
	@Test
	public void test3() {
		String[] cars = new String[] {"ABABAB","ABABAB","ABABABAB","BZZZZZ"};
		assertEquals("15 ABZ", new StringTrain().buildTrain(cars));
	}
	
	@Test
	public void test4() {
		String[] cars = new String[] {"A","A","A","AA"};
		assertEquals("1 A", new StringTrain().buildTrain(cars));
	}
}
