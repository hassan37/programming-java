package practice.java8.lambda._1_basics.functional_comparators;

import java.util.function.Function;

@FunctionalInterface
public interface FComparator<T> {

	int compare(T t1, T t2);

	static <U, R> FComparator<U> comparing(Function<U, Comparable<R>> f) {
		return null;// (p1, p2) -> f.apply(p1).compare(f.apply(p2));
	}
}
