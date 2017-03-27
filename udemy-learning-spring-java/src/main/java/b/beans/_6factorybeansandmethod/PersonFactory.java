package b.beans._6factorybeansandmethod;

class PersonFactory {

	public Person createNewPerson(int id, String name) {
		System.out.println("Using Person Factory Class.");
		return new Person(id, name);
	}
}
