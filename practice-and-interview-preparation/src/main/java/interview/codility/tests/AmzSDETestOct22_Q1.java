package interview.codility.tests;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class AmzSDETestOct22_Q1 {

	List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations, int numDeliveries) {

		Map<Double, Integer> distances = calcDistances(numDestinations, allLocations, numDeliveries);
		List<List<Integer>> deliveries = calcDeliveries(numDeliveries, allLocations, distances);

		return deliveries;
	}

	private List<List<Integer>> calcDeliveries(int numDeliveries, List<List<Integer>> allLocations, Map<Double, Integer> distances) {
		List<List<Integer>> deliveries = new ArrayList<>(numDeliveries);
		for (Entry<Double, Integer> e : distances.entrySet()) {
			deliveries.add(allLocations.get(e.getValue()));

			if (deliveries.size() == numDeliveries)
				break;
		}

		return deliveries;
	}

	Map<Double, Integer> calcDistances(int numDestinations, List<List<Integer>> allLocations, int numDeliveries) {
		Map<Double, Integer> distances = new HashMap<>(numDeliveries);

		for (Integer i = 0; i < numDestinations; i++) {
			List<Integer> coordinates  = allLocations.get(i);
			
			Double xSqr = Math.pow(coordinates.get(0), 2);
			Double ySqr = Math.pow(coordinates.get(1), 2);
			Double dist = Math.sqrt((xSqr + ySqr));

			DecimalFormat df = new DecimalFormat("#.###");
			df.setRoundingMode(RoundingMode.CEILING);

			distances.putIfAbsent(Double.valueOf(df.format(dist)), i);
		}
		System.out.println(distances);
		
		Map<Double, Integer> sortedDistances = distances
			.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByKey())
			.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
		
		System.out.println(sortedDistances);

		return sortedDistances;
	}

	public static void main(String[] args) {
		AmzSDETestOct22_Q1 q1 = new AmzSDETestOct22_Q1();
		List<List<Integer>> allLocations = new ArrayList<>(6);
		allLocations.add(Arrays.asList(3,6));
		allLocations.add(Arrays.asList(2,4));
		allLocations.add(Arrays.asList(5,3));
		allLocations.add(Arrays.asList(2,7));
		allLocations.add(Arrays.asList(1,8));
		allLocations.add(Arrays.asList(7,9));
		
		System.out.println(q1.ClosestXdestinations(6, allLocations, 3));
		
		
		System.out.println(Math.pow(2d, 1d));
		System.out.println(Math.pow(2d, 2d));
		System.out.println(Math.pow(2, 3));
	}
}
