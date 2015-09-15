import org.junit.Test;
import static org.junit.Assert.*;

public class RGBColorTest {
	
	@Test
	public void test0() {
		int[] rgb = new int[] {255,0,0};
		assertArrayEquals(new int[] { 0,  255,  255 }, new RGBColor().getComplement(rgb));
	}
	
	@Test
	public void test1() {
		int[] rgb = new int[] {115,115,143};
		assertArrayEquals(new int[] { 243,  243,  15 }, new RGBColor().getComplement(rgb));
	}
	
	@Test
	public void test2() {
		int[] rgb = new int[] {115,115,144};
		assertArrayEquals(new int[] { 140,  140,  111 }, new RGBColor().getComplement(rgb));
	}
	
	@Test
	public void test3() {
		int[] rgb = new int[] {153,12,55};
		assertArrayEquals(new int[] { 102,  243,  200 }, new RGBColor().getComplement(rgb));
	}

	@Test
	public void test4() {
		int[] rgb = new int[] {126,129,107};
		assertArrayEquals(new int[] { 129,  126,  148 }, new RGBColor().getComplement(rgb));
	}
}
