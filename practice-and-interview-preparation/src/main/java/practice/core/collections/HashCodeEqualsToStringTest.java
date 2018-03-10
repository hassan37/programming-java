package practice.core.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashCodeEqualsToStringTest {

	public static void main(String[] args) {
		Person p1 = new Person(1, "p1");
		Person p2 = new Person(2, "p2");
		Person p3 = new Person(1, "p1");

		System.out.println("p1-p2: equals = " + p1.equals(p2));
		System.out.println("p1-p3: equals = " + p1.equals(p3));
		System.out.println("p2-p3: equals = " + p3.equals(p2));

		System.out.println("p1 hashcode = " + p1.hashCode());
		System.out.println("p2 hashcode = " + p2.hashCode());
		System.out.println("p3 hashcode = " + p3.hashCode());

		System.out.println("p1 hashcode = " + p1.toString());
		System.out.println("p2 hashcode = " + p2.toString());
		System.out.println("p3 hashcode = " + p3.toString());

		Set<Person> ps = new HashSet<>();
		ps.add(p1);
		ps.add(p2);
		ps.add(p3);
		System.out.println("Person HashSets = " + ps);

		Map<Person, Boolean> pm = new HashMap<>();
		pm.put(p1, Boolean.TRUE);
		pm.put(p2, Boolean.FALSE);
		pm.put(p3, Boolean.TRUE);
		System.out.println("Person Map = " + pm);
	}
}
