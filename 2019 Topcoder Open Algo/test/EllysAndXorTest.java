import org.junit.Test;
import static org.junit.Assert.*;

public class EllysAndXorTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] numbers = new int[] {42, 27, 38};
		assertEquals(44, new EllysAndXor().getMax(numbers));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] numbers = new int[] {666, 133, 438, 123, 893, 674, 462, 209};
		assertEquals(976, new EllysAndXor().getMax(numbers));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] numbers = new int[] {42};
		assertEquals(42, new EllysAndXor().getMax(numbers));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] numbers = new int[] {123, 456, 789, 987, 654, 321};
		assertEquals(975, new EllysAndXor().getMax(numbers));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] numbers = new int[] {42, 13, 17, 666, 811, 314, 1, 5, 2, 1000};
		assertEquals(1007, new EllysAndXor().getMax(numbers));
	}
}
