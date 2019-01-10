import java.util.*;
import java.math.*;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class ProductThreshold {
	
	public long subarrayCount(int N, int limit, int[] Aprefix, int spread, int offset) {

		int p = Aprefix.length;
		int []A = new int[p];
		IntStream.rangeClosed(0, p-1).forEach(i-> A[i] = Aprefix[i]);
		int seed = A[p-1];
		for (int i = p; i<= N-1; ++i) {
			seed = (int) ((seed * 1103515245 + 12345) % Math.pow(2, 31));
			A[i] = (seed % spread) + offset;
		}
		int product = 1;
		int count = 0;
		int result = 0;
		boolean bF = false;
		for (int i = 0, j = 0, k=0 ; j < A.length; ++j) {
			product *= A[j];
			int temp = product;
			k = j-1;
			if (product >= limit) {
				while (i <= j && product >= limit) {
					product /= A[i++];
				}
				result += j - i + 1;
			} else {
				while (k >=1 && temp <= limit) {
					temp *= A[k--];
					result++;
				}
				//product = temp;
			}
		}
		return result;
	}
}
