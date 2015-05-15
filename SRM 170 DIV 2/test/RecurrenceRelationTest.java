import org.junit.Test;
import static org.junit.Assert.*;

public class RecurrenceRelationTest {
	
	@Test
	public void test0() {
		int[] coefficients = new int[] {2,1};
		int[] initial = new int[] {9,7};
		int N = 6;
		assertEquals(5, new RecurrenceRelation().moduloTen(coefficients, initial, N));
	}
	
	@Test
	public void test1() {
		int[] coefficients = new int[] {1,1};
		int[] initial = new int[] {0,1};
		int N = 9;
		assertEquals(4, new RecurrenceRelation().moduloTen(coefficients, initial, N));
	}
	
	@Test
	public void test2() {
		int[] coefficients = new int[] {2};
		int[] initial = new int[] {1};
		int N = 20;
		assertEquals(6, new RecurrenceRelation().moduloTen(coefficients, initial, N));
	}
	
	@Test
	public void test3() {
		int[] coefficients = new int[] {2};
		int[] initial = new int[] {1};
		int N = 64;
		assertEquals(6, new RecurrenceRelation().moduloTen(coefficients, initial, N));
	}
	
	@Test
	public void test4() {
		int[] coefficients = new int[] {25,143};
		int[] initial = new int[] {0,0};
		int N = 100000;
		assertEquals(0, new RecurrenceRelation().moduloTen(coefficients, initial, N));
	}
	
	@Test
	public void test5() {
		int[] coefficients = new int[] {9,8,7,6,5,4,3,2,1,0};
		int[] initial = new int[] {1,2,3,4,5,6,7,8,9,10};
		int N = 654;
		assertEquals(5, new RecurrenceRelation().moduloTen(coefficients, initial, N));
	}
	
	@Test
	public void test6() {
		int[] coefficients = new int[] {901,492,100};
		int[] initial = new int[] {-6,-15,-39};
		int N = 0;
		assertEquals(4, new RecurrenceRelation().moduloTen(coefficients, initial, N));
	}
}
