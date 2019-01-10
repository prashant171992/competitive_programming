import org.junit.Test;
import static org.junit.Assert.*;

public class HiddenRabbitsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] p = new int[] {0,1,2};
		int m = 2;
		int[] r = new int[] {2};
		int[] a = new int[] {0};
		int[] b = new int[] {1};
		int[] x = new int[] {1};
		assertArrayEquals(new int[] {1, 1 }, new HiddenRabbits().whereAreTheRabbits(p, m, r, a, b, x));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] p = new int[] {0,1};
		int m = 2;
		int[] r = new int[] {0,1};
		int[] a = new int[] {0,1};
		int[] b = new int[] {1,0};
		int[] x = new int[] {0,1};
		assertArrayEquals(new int[] {0, 1 }, new HiddenRabbits().whereAreTheRabbits(p, m, r, a, b, x));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] p = new int[] {0,1,1};
		int m = 3;
		int[] r = new int[] {0,0,0,2,3,2,3,2,3};
		int[] a = new int[] {0,1,2,0,0,1,1,2,2};
		int[] b = new int[] {1,2,0,1,1,2,2,0,0};
		int[] x = new int[] {1,1,1,2,3,2,3,2,3};
		assertArrayEquals(new int[] { }, new HiddenRabbits().whereAreTheRabbits(p, m, r, a, b, x));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] p = new int[] {0,1,2};
		int m = 4;
		int[] r = new int[] {2,1,0,2,1,3};
		int[] a = new int[] {0,1,0,0,2,2};
		int[] b = new int[] {2,3,1,1,3,3};
		int[] x = new int[] {1,2,0,2,1,3};
		assertArrayEquals(new int[] {0, 2, 1, 3 }, new HiddenRabbits().whereAreTheRabbits(p, m, r, a, b, x));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] p = new int[] {0,0,0,1,0,2,3,1};
		int m = 10;
		int[] r = new int[] {3,3};
		int[] a = new int[] {2,6};
		int[] b = new int[] {6,2};
		int[] x = new int[] {5,0};
		assertArrayEquals(new int[] { }, new HiddenRabbits().whereAreTheRabbits(p, m, r, a, b, x));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] p = new int[] {0,0,0,0,2,2,3,0,7,6,9,11,4,13,7,10,12,1,18};
		int m = 15;
		int[] r = new int[] {13,15,1,11,17,15,13,6,15,14,10,15,3,5,0,1,17,7,9,13,18,4,4,14,16}
;
		int[] a = new int[] {2,0,13,12,5,11,14,10,12,7,7,2,14,9,14,0,0,3,0,6,13,3,1,6,14}
;
		int[] b = new int[] {3,7,6,0,1,12,1,1,4,2,8,10,3,3,3,10,3,0,4,4,11,2,5,14,0}
;
		int[] x = new int[] {0,7,0,7,18,0,1,0,0,7,10,7,0,2,0,0,7,7,7,0,0,0,18,0,0}
;
		assertArrayEquals(new int[] {7, 18, 7, 0, 0, 18, 0, 7, 10, 2, 0, 0, 0, 0, 1 }, new HiddenRabbits().whereAreTheRabbits(p, m, r, a, b, x));
	}
}
