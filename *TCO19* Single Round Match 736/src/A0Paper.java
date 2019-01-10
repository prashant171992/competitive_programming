import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class A0Paper {
	
	public String canBuild(int[] A) {

		if (A[0] != 0) {
			return "Possible";
		}

		for (int i = A.length - 1 ; i > 0 ; --i) {
			A[i-1] += A[i]/2;
		}

		if (A[0] != 0) {
			return "Possible";
		} else {
			return "Impossible";
		}

	}
}
