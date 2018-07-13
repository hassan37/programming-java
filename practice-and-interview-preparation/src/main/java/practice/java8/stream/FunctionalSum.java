package practice.java8.stream;

import java.util.Arrays;
import java.util.List;

public class FunctionalSum {

	public static void main(String[] args) {
		System.out.println(sum(Arrays.asList(1,2,3,4,5), 3));
	}

	static int sum(List<Integer> ints, int x) {
		return ints.stream()
			.filter(i -> Integer.compare(i, x) > 0)
			.mapToInt(Integer::intValue)
			.sum();
	}
}
