import org.junit.Test;
import static org.junit.Assert.*;

public class MaidensBunrakuTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] x = new int[] {-5,-5,-5,5,5,5};
		int[] y = new int[] {4,5,6,4,5,6};
		assertEquals(4, new MaidensBunraku().maximal(x, y));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] x = new int[] {-1,-1,1,1};
		int[] y = new int[] {4,0,4,0};
		assertEquals(0, new MaidensBunraku().maximal(x, y));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] x = new int[] {0,1,2,3,4,0,1,2,3,4};
		int[] y = new int[] {0,0,0,0,0,1,1,1,1,1};
		assertEquals(15, new MaidensBunraku().maximal(x, y));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] x = new int[] {0,1,2,3,4,5,6,7,8,9};
		int[] y = new int[] {0,1,2,3,4,5,6,7,8,9};
		assertEquals(16, new MaidensBunraku().maximal(x, y));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] x = new int[] {1000000};
		int[] y = new int[] {-1000000};
		assertEquals(0, new MaidensBunraku().maximal(x, y));
	}
}
