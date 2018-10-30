package interview.codility.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmzSDETestOct22_Q2 {

	static List<List<Integer>> optimalUtilization(int maxTravelDist,
			List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {

		Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				if (o1.get(1) > o2.get(1))
					return 1;
				if (o1.get(1) < o2.get(1))
					return -11;
				return 0;
			}
		};
		Collections.sort(forwardRouteList, comparator);
		Collections.sort(returnRouteList, comparator);
		List<Integer> singlePair;
		Map<Integer, List<List<Integer>>> maxPairs = new HashMap<>();
		for (List<Integer> indic : forwardRouteList) {
			List<Integer> pair = search(Math.abs(indic.get(1) - maxTravelDist),
					returnRouteList);
			singlePair = new ArrayList<>();
			singlePair.add(indic.get(0));
			singlePair.add(pair.get(0));
			if (maxPairs.containsKey(indic.get(1) + pair.get(1))) {
				maxPairs.get(indic.get(1) + pair.get(1)).add(singlePair);
			} else {
				List<List<Integer>> row = new ArrayList<>();
				row.add(singlePair);
				maxPairs.put(indic.get(1) + pair.get(1), row);
			}

		}
		int max = -1;
		for (Integer i : maxPairs.keySet()) {
			if (i <= maxTravelDist) {
				max = Math.max(max, i);
			}
		}
		return maxPairs.get(max);
	}

	public static List<Integer> search(int value, List<List<Integer>> a) {

		if (value < a.get(0).get(1)) {
			return a.get(0);
		}
		if (value > a.get(a.size() - 1).get(1)) {
			return a.get(a.size() - 1);
		}

		int lo = 0;
		int hi = a.size() - 1;

		while (lo <= hi) {
			int mid = (hi + lo) / 2;
			// System.out.println(mid);
			if (value < a.get(mid).get(1)) {

				hi = mid - 1;
			} else if (value > a.get(mid).get(1)) {
				lo = mid + 1;
			} else {
				return a.get(mid);
			}
		}
		return (a.get(lo).get(1) - value) > (value - a.get(hi).get(1))
				? a.get(lo)
				: a.get(hi);
	}
}
