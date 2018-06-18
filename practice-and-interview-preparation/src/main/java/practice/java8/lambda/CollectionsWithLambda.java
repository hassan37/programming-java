package practice.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class CollectionsWithLambda {

	public static void main(String[] args) {
		List<String> l = Arrays.asList("Hafiz", "Muhammad", "Hassan");
		l.forEach(System.out::println);
	}
}
