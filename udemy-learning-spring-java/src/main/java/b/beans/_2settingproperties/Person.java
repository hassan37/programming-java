package b.beans._2settingproperties;

class Person {

	private int id;
	private String name;

	private int taxID;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	void speak() {
		System.out.println("Hello Spring! I am a person.");
	}

	public int getTaxID() { return taxID; }
	public void setTaxID(int taxID) { this.taxID = taxID; }

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxID=" + taxID + "]";
	}

}
