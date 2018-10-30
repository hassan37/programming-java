package practice.java8.lambda._1_basics;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/*
 * Method Reference: another way to write lambda expression
 */
public class MethodReferenceBasics {

	public static void main(String[] args) {

		BinaryOperator<Integer> max = Math::max;

		Consumer<String> print = System.out::println;
		print.accept(String.valueOf(max.apply(2, 5)));
	}
}
