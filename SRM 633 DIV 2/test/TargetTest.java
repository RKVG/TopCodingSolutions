import org.junit.Test;
import static org.junit.Assert.*;

public class TargetTest {
	
	@Test
	public void test0() {
		int n = 5;
		assertArrayEquals(new String[] {"#####", "#   #", "# # #", "#   #", "#####" }, new Target().draw(n));
	}
	
	@Test
	public void test1() {
		int n = 9;
		assertArrayEquals(new String[] {"#########", "#       #", "# ##### #", "# #   # #", "# # # # #", "# #   # #", "# ##### #", "#       #", "#########" }, new Target().draw(n));
	}
	
	@Test
	public void test2() {
		int n = 13;
		assertArrayEquals(new String[] {"#############", "#           #", "# ######### #", "# #       # #", "# # ##### # #", "# # #   # # #", "# # # # # # #", "# # #   # # #", "# # ##### # #", "# #       # #", "# ######### #", "#           #", "#############" }, new Target().draw(n));
	}
	
	@Test
	public void test3() {
		int n = 17;
		assertArrayEquals(new String[] {"#################", "#               #", "# ############# #", "# #           # #", "# # ######### # #", "# # #       # # #", "# # # ##### # # #", "# # # #   # # # #", "# # # # # # # # #", "# # # #   # # # #", "# # # ##### # # #", "# # #       # # #", "# # ######### # #", "# #           # #", "# ############# #", "#               #", "#################" }, new Target().draw(n));
	}
}
