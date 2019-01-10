import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class GetAccepted {
	
	public String answer(String question) {

		String [] strings = question.split("\\s+");
		boolean ans = true;
		for (int i = 0; i < strings.length; ++i) {
			if (strings[i].equals("not")) {
				ans = !ans;
			}
		}
		if (ans) {
			return "True.";
		} else {
			return "False.";
		}

	}
}
