import java.util.*;
import java.math.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class LongJumpCompetition {
	
	public int[] recoverStandings(int[] jumpLengths) {

		int groupSize = jumpLengths.length/3;

		int j = 0;

		Map<Integer, List<Integer>> map = new LinkedHashMap<>();

		for (int i = groupSize-1; i>=0; --i) {
			List<Integer> currentList = map.getOrDefault(i, new ArrayList<>());
			currentList.add(jumpLengths[j]);
			currentList.sort(Comparator.reverseOrder());
			map.put(i, currentList);
			j++;
		}

		for (int i = j; i < jumpLengths.length; i+=groupSize) {
			map = map.entrySet()
					.stream()
					.sorted(((Comparator<Map.Entry<Integer, List<Integer>>>) (o1, o2) -> {

						List<Integer> l1 = o1.getValue();
						List<Integer> l2 = o2.getValue();
						for (int i1 = 0; i1 < l1.size(); ++i1) {
							if (l1.get(i1) > l2.get(i1)) {
								return -1;
							}
						}

						for (int i1 = 0; i1 < l1.size(); ++i1) {
							if (l2.get(i1) > l1.get(i1)) {
								return 1;
							}
						}

						if (o1.getKey() > o2.getKey()) {
							return -1;
						}
						return 1;

					})).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
			int counter = 1;

			for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
				List<Integer> currentList = entry.getValue();
				currentList.add(jumpLengths[i+groupSize - counter]);
				currentList.sort(Comparator.reverseOrder());
				map.put(entry.getKey(), currentList);
				counter++;
			}

		}

		map = map.entrySet()
				.stream()
				.sorted(((Comparator<Map.Entry<Integer, List<Integer>>>) (o1, o2) -> {

					List<Integer> l1 = o1.getValue();
					List<Integer> l2 = o2.getValue();
					for (int i1 = 0; i1 < l1.size(); ++i1) {
						if (l1.get(i1) > l2.get(i1)) {
							return -1;
						}
					}

					for (int i1 = 0; i1 < l1.size(); ++i1) {
						if (l2.get(i1) > l1.get(i1)) {
							return 1;
						}
					}

					if (o1.getKey() > o2.getKey()) {
						return -1;
					}
					return 1;

				})).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));



		int resultA[] = new int[groupSize];
		int counter = groupSize-1;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			resultA[counter] = entry.getKey();
			counter--;
		}

		return resultA;
	}
}
