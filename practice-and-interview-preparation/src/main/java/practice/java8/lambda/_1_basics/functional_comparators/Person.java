package practice.java8.lambda._1_basics.functional_comparators;

public class Person {

	private int id;
	private int age;
	private String firstName;
	private String lastName;
	public int getID() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	
}
