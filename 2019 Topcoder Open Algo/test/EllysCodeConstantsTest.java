import org.junit.Test;
import static org.junit.Assert.*;

public class EllysCodeConstantsTest {
	
	@Test(timeout=2000)
	public void test0() {
		String candidate = "DEADBEEF";
		assertEquals("0xDEADBEEF", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String candidate = "BABACECA";
		assertEquals("0xBABACECA", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String candidate = "TOPCODER";
		assertEquals("", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String candidate = "FLU";
		assertEquals("0xFLU", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String candidate = "FULL";
		assertEquals("0xFULL", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String candidate = "FALL";
		assertEquals("0xFALL", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String candidate = "TASTEFUL";
		assertEquals("0x7A57EFUL", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test7() {
		String candidate = "OFFICIAL";
		assertEquals("0x0FF1C1AL", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test8() {
		String candidate = "OOZE";
		assertEquals("0x002E", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test9() {
		String candidate = "ESPRIT";
		assertEquals("", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test10() {
		String candidate = "COOL";
		assertEquals("0xC00L", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test11() {
		String candidate = "DISEASE";
		assertEquals("0xD15EA5E", new EllysCodeConstants().getLiteral(candidate));
	}
	
	@Test(timeout=2000)
	public void test12() {
		String candidate = "SOLVED";
		assertEquals("", new EllysCodeConstants().getLiteral(candidate));
	}
}
