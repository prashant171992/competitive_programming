import org.junit.Test;
import static org.junit.Assert.*;

public class GetAcceptedTest {
	
	@Test(timeout=2000)
	public void test0() {
		String question = "Do you want to get accepted?";
		assertEquals("True.", new GetAccepted().answer(question));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String question = "Do you not want to get accepted?";
		assertEquals("False.", new GetAccepted().answer(question));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String question = "Do you want to not get accepted?";
		assertEquals("False.", new GetAccepted().answer(question));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String question = "Do you want to get not not accepted?";
		assertEquals("True.", new GetAccepted().answer(question));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String question = "Do you not want to not get not not not accepted?";
		assertEquals("False.", new GetAccepted().answer(question));
	}
}
