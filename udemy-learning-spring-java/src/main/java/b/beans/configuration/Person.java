package b.beans.configuration;

class Person {

	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	void speak() {
		System.out.println("Hello Spring! I am a person.");
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
