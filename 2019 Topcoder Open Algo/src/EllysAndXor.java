import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class EllysAndXor {
	
	public int getMax(int[] numbers) {


		int result = 0;

		if (numbers.length == 1) return numbers[0];

		List<Integer> list = new ArrayList<>();
		list.add(numbers[0]);

		for (int i = 1; i < numbers.length; ++i) {
			List<Integer> newList = new ArrayList<>();
			for (Integer integer : list) {
				newList.add(numbers[i] & integer);
				newList.add(numbers[i] ^ integer);
			}
			list.clear();
			list = newList;
		}

		for (Integer integer : list) {
			result = Math.max(integer, result);
		}
		return result;
		//return Math.max(result[numbers.length-1][0], result[numbers.length-1][1]);
	}
}
