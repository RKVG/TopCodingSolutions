import org.junit.Test;
import static org.junit.Assert.*;

public class RochamboTest {
	
	@Test(timeout=2000)
	public void test0() {
		String opponent = "PS";
		assertEquals(1, new Rochambo().wins(opponent));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String opponent = "PSRRPS";
		assertEquals(3, new Rochambo().wins(opponent));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String opponent = "PSRPSRPRSR";
		assertEquals(7, new Rochambo().wins(opponent));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String opponent = "SRPSRPSPRSPRPSRPSRP";
		assertEquals(16, new Rochambo().wins(opponent));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String opponent = "RPPPRRPSSSRRRSRSPPSSPRRPSRRRRSPPPPSSPSSSSSRSSSRPRR";
		assertEquals(18, new Rochambo().wins(opponent));
	}
}
