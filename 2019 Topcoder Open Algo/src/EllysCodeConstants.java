import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class EllysCodeConstants {
	
	public String getLiteral(String candidate) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('O', 0);
		map.put('I', 1);
		map.put('Z', 2);
		map.put('S', 5);
		map.put('T', 7);

		List<String> suffixes = Arrays.asList("L", "LL", "U", "UL", "ULL", "LU", "LLU");


		// checking first 6 characters

		boolean first6Character = true;

		for (Character character : candidate.toCharArray()) {
			if (character - 'A' > 5) {
				first6Character = false;
				break;
			}
		}

		if (first6Character) {
			return "0x" + candidate;
		}

		if (candidate.length() >= 4) {
			String subS = candidate.substring(candidate.length()-4, candidate.length());
			String main = candidate.substring(0, candidate.length()-6);

		}
		if (candidate.length() < 4) {

		}

		return "";
	}
}
