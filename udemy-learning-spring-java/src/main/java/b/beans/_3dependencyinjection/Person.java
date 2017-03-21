package b.beans._3dependencyinjection;

class Person {

	private int id;
	private String name;

	private int taxID;

	private Address address;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	void speak() {
		System.out.println("Hello Spring! I am a person.");
	}

	public int getTaxID() { return taxID; }
	public void setTaxID(int taxID) { this.taxID = taxID; }

	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxID=" + taxID + ", address=" + address + "]";
	}

}
