import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MazeWithKeys {
	
	public int startingPoints(String[] a) {

		int result = 0;
		for (int i = 0 ; i < a.length; ++i) {
			for (int j = 0 ; j < a[i].length(); ++j) {

				if (compute(a, i , j, new ArrayList<>())) {
					result ++;
				}
			}
		}

		return result;

	}

	public boolean compute(String[] a, int i, int j, List<String> keys) {
		if (a[i].charAt(j) == '*') {
			 return true;
		}
		if (a[i].charAt(j) == '.') {
			boolean result = true;
			if (i < a.length - 1)
				result = compute(a, i + 1, j, keys);
			if (i > 1)
				result &= compute(a, i-1, j , keys);
			if (j < a[i].length() - 1)
				result &= compute(a, i, j+1 , keys);
			if (j > 1)
				result &= compute(a, i, j - 1 , keys);
			return result;
		}

		if (a[i].charAt(j) == '#') {
			return false;
		}

		if (a[i].charAt(j) >= 'A' && a[i].charAt(j) <= 'Z') {
			String s = a[i].charAt(j)+ "";
			if (keys.contains(s.toLowerCase())){
				boolean result = true;
				if (i < a.length - 1)
					result = compute(a, i + 1, j, keys);
				if (i > 1)
					result &= compute(a, i-1, j , keys);
				if (j < a[i].length() - 1)
					result &= compute(a, i, j+1 , keys);
				if (j > 1)
					result &= compute(a, i, j - 1 , keys);
				return result;
			}
			else {
				return false;
			}
		}

		else {
			keys.add(String.valueOf(a[i].charAt(j)));
			boolean result = true;
			if (i < a.length - 1)
				result = compute(a, i + 1, j, keys);
			if (i > 1)
				result &= compute(a, i-1, j , keys);
			if (j < a[i].length() - 1)
				result &= compute(a, i, j+1 , keys);
			if (j > 1)
				result &= compute(a, i, j - 1 , keys);
			return result;
		}
	}
}
