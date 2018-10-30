package practice.java8.lambda._1_basics.functional_comparators;

import java.util.function.Function;

public class ComparatorApp {

	public static void main(String[] args) {
		FComparator<Person> idComp = (p1, p2) -> p1.getID() - p2.getID();
		FComparator<Person> ageComp = (p1, p2) -> p1.getAge() - p2.getAge();
		FComparator<Person> fNameComp = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		FComparator<Person> lNameComp = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

		Function<Person, Integer> fID = Person::getID;
		Function<Person, Integer> fAge = Person::getAge;
		Function<Person, String> fName = Person::getFirstName;
		Function<Person, String> lName = Person::getLastName;

		
	}
}
