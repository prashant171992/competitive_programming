import org.junit.Test;
import static org.junit.Assert.*;

public class RerollTest {
	
	@Test(timeout=2000)
	public void test0() {
		int target = 7;
		int[] dice = new int[] {2,6,4};
		assertEquals(1, new Reroll().minimumDice(target, dice));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int target = 10;
		int[] dice = new int[] {4,2,4,5};
		assertEquals(2, new Reroll().minimumDice(target, dice));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int target = 42;
		int[] dice = new int[] {6,6,6,6,6,6,6};
		assertEquals(0, new Reroll().minimumDice(target, dice));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int target = 95;
		int[] dice = new int[] {5,3,2,3,4,1,4,6,6,5,5,4,4,6,5,4,5,1,1,4};
		assertEquals(4, new Reroll().minimumDice(target, dice));
	}
}
