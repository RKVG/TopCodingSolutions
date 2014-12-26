import org.junit.Test;
import static org.junit.Assert.*;

public class IsHomomorphismTest {
	
	@Test
	public void test0() {
		String[] source = new String[] {"0000",
 "0123",
 "0202",
 "0321"};
		String[] target = new String[] {"0000",
 "0123",
 "0202",
 "0321"};
		int[] mapping = new int[] {0,1,2,3};
		assertArrayEquals(new String[] { }, new IsHomomorphism().numBad(source, target, mapping));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] source = new String[] {"0123456",
 "1234560",
 "2345601",
 "3456012",
 "4560123",
 "5601234",
 "6012345"};
		String[] target = new String[] {"0123456",
 "1234560",
 "2345601",
 "3456012",
 "4560123",
 "5601234",
 "6012345"};
		int[] mapping = new int[] {1,3,2,1,2,1,1};
		assertArrayEquals(new String[] { "(0,0)",  "(0,1)",  "(0,2)",  "(0,3)",  "(0,4)",  "(0,5)",  "(0,6)",  "(1,0)",  "(1,1)",  "(1,2)",  "(1,3)",  "(1,4)",  "(1,5)",  "(1,6)",  "(2,0)",  "(2,1)",  "(2,2)",  "(2,3)",  "(2,4)",  "(2,5)",  "(3,0)",  "(3,1)",  "(3,2)",  "(3,3)",  "(3,4)",  "(3,5)",  "(4,0)",  "(4,1)",  "(4,2)",  "(4,3)",  "(4,4)",  "(4,5)",  "(4,6)",  "(5,0)",  "(5,1)",  "(5,2)",  "(5,3)",  "(5,4)",  "(5,5)",  "(6,0)",  "(6,1)",  "(6,4)",  "(6,6)" }, new IsHomomorphism().numBad(source, target, mapping));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] source = new String[] {"012",
 "120",
 "210"};
		String[] target = new String[] {"012",
 "120",
 "110"};
		int[] mapping = new int[] {0,1,2};
		assertArrayEquals(new String[] { "(2,0)" }, new IsHomomorphism().numBad(source, target, mapping));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] source = new String[] {"012",
 "120",
 "210"};
		String[] target = new String[] {"012",
 "120",
 "210"};
		int[] mapping = new int[] {1,2,0};
		assertArrayEquals(new String[] { "(0,0)",  "(0,1)",  "(0,2)",  "(1,0)",  "(1,2)",  "(2,0)",  "(2,2)" }, new IsHomomorphism().numBad(source, target, mapping));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] source = new String[] {"01","10"};
		String[] target = new String[] {"10","01"};
		int[] mapping = new int[] {1,0};
		assertArrayEquals(new String[] { }, new IsHomomorphism().numBad(source, target, mapping));
	}
}
