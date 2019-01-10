import org.junit.Test;
import static org.junit.Assert.*;

public class SubarrayAveragesTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		assertArrayEquals(new double[] {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 }, new SubarrayAverages().findBest(arr), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] arr = new int[] {7,6,5,4,3,2,1};
		assertArrayEquals(new double[] {4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0 }, new SubarrayAverages().findBest(arr), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] arr = new int[] {1,2,1,2}
;
		assertArrayEquals(new double[] {1.0, 1.5, 1.5, 2.0 }, new SubarrayAverages().findBest(arr), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] arr = new int[] {1,10,1,1,1,1,10}
;
		assertArrayEquals(new double[] {1.0, 2.8, 2.8, 2.8, 2.8, 2.8, 10.0 }, new SubarrayAverages().findBest(arr), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] arr = new int[] {4,5,6,7,8,9,10,11,12,13,14,15,16,17,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
;
		assertArrayEquals(new double[] {4.0, 5.0, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846, 5.846153846153846 }, new SubarrayAverages().findBest(arr), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] arr = new int[] {1000000}
;
		assertArrayEquals(new double[] {1000000.0 }, new SubarrayAverages().findBest(arr), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test6() {
		int[] arr = new int[] {9450,7098,6048,1050,672,8232,5028,
672,672,42,42,42,42,42,9450,6048,
3402,3402,2688,9450,7098,6048,1050,
672,8232,5028,672,672,9450,6048,3402};
		assertArrayEquals(new double[] {2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 2795.1428571428573, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 4565.142857142857, 6300.0, 6300.0, 6300.0 }, new SubarrayAverages().findBest(arr), 1e-9);
	}
}
