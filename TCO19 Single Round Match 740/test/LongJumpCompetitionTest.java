import org.junit.Test;
import static org.junit.Assert.*;

public class LongJumpCompetitionTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] jumpLengths = new int[] {847, 833, 829};
		assertArrayEquals(new int[] {0 }, new LongJumpCompetition().recoverStandings(jumpLengths));
	}
	
	@Test
	public void test1() {
		int[] jumpLengths = new int[] {100, 120, 110, 130, 120, 111, 147, 92, 0};
		assertArrayEquals(new int[] {0, 2, 1 }, new LongJumpCompetition().recoverStandings(jumpLengths));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] jumpLengths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		assertArrayEquals(new int[] {0, 1, 2, 3 }, new LongJumpCompetition().recoverStandings(jumpLengths));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] jumpLengths = new int[] {850, 840, 841, 850, 850, 837};
		assertArrayEquals(new int[] {1, 0 }, new LongJumpCompetition().recoverStandings(jumpLengths));
	}
}
