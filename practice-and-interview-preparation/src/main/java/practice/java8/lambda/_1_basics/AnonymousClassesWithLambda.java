package practice.java8.lambda._1_basics;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassesWithLambda {

	public static void main(String[] args) {
		fileFilterExampleUsingLambda();
		stringComparatorExampleUsingLambda();
	}

	static void fileFilterExampleUsingLambda() {
		File dir = Paths.get("D:\\accela\\_05_sql-server").toFile();
		File[] files = dir.listFiles(
			(File f) -> f.getName().endsWith(".sql")
		);
		for (File file : files) {
			System.out.println("fileFilterExampleUsingLambda: " + file.getName());
		}
	}

	static void stringComparatorExampleUsingLambda() {
		Comparator<String> lengthComp = (s1, s2) -> Integer.compare(s2.length(), s1.length());
		List<String> list = Arrays.asList("*", "***", "**");
		list.sort(lengthComp);

		System.out.println("stringComparatorExampleUsingLambda: " + list);
	}
}
