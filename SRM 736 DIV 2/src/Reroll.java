import java.util.*;
import java.math.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Reroll {

	public int minimumDice(int target, int[] dice) {
		List<Integer> dices  = Arrays.stream(dice).boxed().collect(Collectors.toList());;
		Collections.sort(dices);
		Collections.reverse(dices);

		List<Integer> dices1 = Arrays.stream(dice).boxed().collect(Collectors.toList());;
		Collections.sort(dices1);

		int sum = dices.stream().mapToInt(i -> i).sum();

		int sum1= dices.stream().mapToInt(i -> i).sum();


		int result = 0;
		int result1 = 0;
		for (int i = dices.size()-1; i >= 0; --i) {
			if (sum == target) break;
			int otherSum = target - (sum - dices.get(i));
			if (otherSum <= 0) {
				sum = sum - dices.get(i) + 1;
				dices.set(i, 1);
				result++;
			} else if (otherSum < dices.get(i)){
				sum = sum - dices.get(i) + otherSum;
				dices.set(i, otherSum);
				result++;
			} else if (otherSum > dices.get(i)) {
				if (otherSum > 6) {
					if (dices.get(i) != 6) {
						result++;
					}
					sum = sum - dices.get(i) + 6;
					dices.set(i, 6);
				} else {
					sum = sum - dices.get(i) + otherSum;
					dices.set(i, otherSum);
					result++;
				}
			}
		}

		for (int i = dices.size()-1; i >= 0; --i) {
			if (sum1 == target) break;
			int otherSum = target - (sum1 - dices1.get(i));
			if (otherSum <= 0) {
				sum1 = sum1 - dices1.get(i) + 1;
				dices1.set(i, 1);
				result1++;
			} else if (otherSum < dices1.get(i)){
				sum1 = sum1 - dices1.get(i) + otherSum;
				dices1.set(i, otherSum);
				result1++;
			} else if (otherSum > dices1.get(i)) {
				if (otherSum > 6) {
					if (dices1.get(i) != 6) {
						result1++;
					}
					sum1 = sum1 - dices1.get(i) + 6;
					dices1.set(i, 6);
				} else {
					sum1 = sum1 - dices1.get(i) + otherSum;
					dices1.set(i, otherSum);
					result1++;
				}
			}
		}
		return Math.min(result, result1);

	}
}
