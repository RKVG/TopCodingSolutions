import org.junit.Test;
import static org.junit.Assert.*;

public class XorSequenceEasyTest {
	
	@Test
	public void test0() {
		int[] A = new int[] {3,2,1,0,3,2};
		int N = 4;
		assertEquals(8, new XorSequenceEasy().getmax(A, N));
	}
	
	@Test
	public void test1() {
		int[] A = new int[] {3,0,4,6,1,5,7,6};
		int N = 8;
		assertEquals(21, new XorSequenceEasy().getmax(A, N));
	}
	
	@Test
	public void test2() {
		int[] A = new int[] {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9};
		int N = 16;
		assertEquals(76, new XorSequenceEasy().getmax(A, N));
	}
	
	@Test
	public void test3() {
		int[] A = new int[] {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
		int N = 8;
		assertEquals(0, new XorSequenceEasy().getmax(A, N));
	}
	
	@Test
	public void test4() {
		int[] A = new int[] {408024109,11635919,196474438,117649705,812669700,553475508,445349752,271145432,730417256,738416295
,147699711,880268351,816031019,686078705,1032012284,182546393,875376506,220137366,906190345,16216108
,799485093,715669847,413196148,122291044,777206980,68706223,769896725,212567592,809746340,964776169
,928126551,228208603,918774366,352800800,849040635,941604920,326686120,920977486,964528038,659998484
,207195539,607901477,725914710,655525412,949610052,142750431,766838105,1024818573,836758851,97228667};
		int N = 1073741824;
		assertEquals(720, new XorSequenceEasy().getmax(A, N));
	}
}
