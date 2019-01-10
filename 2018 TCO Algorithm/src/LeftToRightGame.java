import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LeftToRightGame {
	
	public String whoWins(int length, int divisor) {
		if (length % 2 != 0 && numDigit(divisor) <= length) {
			return "Alice";
		}
		return "Bob";
	}
	private int numDigit(int n) {
		return String.valueOf(n).length();
	}
}
