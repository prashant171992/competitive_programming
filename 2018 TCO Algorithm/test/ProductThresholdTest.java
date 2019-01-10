import org.junit.Test;
import static org.junit.Assert.*;

public class ProductThresholdTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 5;
		int limit = 5;
		int[] Aprefix = new int[] {1,2,3,-4,5};
		int spread = 1;
		int offset = 1;
		assertEquals(13L, new ProductThreshold().subarrayCount(N, limit, Aprefix, spread, offset));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 10;
		int limit = 8;
		int[] Aprefix = new int[] {2,2,2,2,2,2,2,2,2,2};
		int spread = 1;
		int offset = 47;
		assertEquals(27L, new ProductThreshold().subarrayCount(N, limit, Aprefix, spread, offset));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 20;
		int limit = 999888777;
		int[] Aprefix = new int[] {47};
		int spread = 7654321;
		int offset = 1;
		assertEquals(21L, new ProductThreshold().subarrayCount(N, limit, Aprefix, spread, offset));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 5;
		int limit = 8;
		int[] Aprefix = new int[] {3,0,3,0,3};
		int spread = 47;
		int offset = 47;
		assertEquals(15L, new ProductThreshold().subarrayCount(N, limit, Aprefix, spread, offset));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 1000;
		int limit = 1;
		int[] Aprefix = new int[] {-1};
		int spread = 1;
		int offset = 2;
		assertEquals(1000L, new ProductThreshold().subarrayCount(N, limit, Aprefix, spread, offset));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int N = 100;
		int limit = 47;
		int[] Aprefix = new int[] {1};
		int spread = 1;
		int offset = 1;
		assertEquals(5050L, new ProductThreshold().subarrayCount(N, limit, Aprefix, spread, offset));
	}
}
