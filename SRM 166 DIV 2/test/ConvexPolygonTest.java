import org.junit.Test;
import static org.junit.Assert.*;

public class ConvexPolygonTest {
	
	@Test
	public void test0() {
		int[] x = new int[] {0,0,1};
		int[] y = new int[] {0,1,0};
		assertEquals(0.5, new ConvexPolygon().findArea(x, y), 1e-9);
	}
	
	@Test
	public void test1() {
		int[] x = new int[] {-10000,-10000,10000,10000};
		int[] y = new int[] {10000,-10000,-10000,10000};
		assertEquals(4.0E8, new ConvexPolygon().findArea(x, y), 1e-9);
	}
	
	@Test
	public void test2() {
		int[] x = new int[] {100,80,30,-30,-80,-100,-80,-30,30,80};
		int[] y = new int[] {0,58,95,95,58,0,-58,-95,-95,-58};
		assertEquals(29020.0, new ConvexPolygon().findArea(x, y), 1e-9);
	}
	
	@Test
	public void test3() {
		int[] x = new int[] {-1646,-9172,-9830,-9802,-9749,-9474,-8668,-6832,120,8380,9338,9307,8042};
		int[] y = new int[] {-9998,-8619,-7863,3976,4541,5975,8127,9500,9612,8734,5216,-9042,-9689};
		assertEquals(3.55115104E8, new ConvexPolygon().findArea(x, y), 1e-9);
	}
	
	@Test
	public void test4() {
		int[] x = new int[] {-6010,-7937,-8782,-9506,-9654,-9852,-9854,-9998,-9999,-9996,-9901,-9811,
-9444,-8798,-8580,-2085,6842,8339,9827,9946,9993,9959,9940,9855,9657,
8504,8262,7552,6326,5537,4723};
		int[] y = new int[] {-9976,-9947,-9873,-9739,-9654,-8501,-8475,-5009,475,4926,7078,8673,9417,
9785,9820,9974,9986,9979,9862,9211,-5070,-6599,-7121,-8624,-8912,-9710,
-9766,-9863,-9914,-9941,-9962};
		assertEquals(3.939960635E8, new ConvexPolygon().findArea(x, y), 1e-9);
	}
}
