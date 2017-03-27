package b.beans._6factorybeansandmethod;

class Person {

	private int id;
	private String name;

	private int taxID;

	private Address address;

	/**
	 * Factory Method
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public static Person New(int id, String name) {
		System.out.println("Using New Factory Method");
		return new Person(id, name);
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	void speak() { System.out.println("Hello Spring! I am a person."); }

	public void onCreate() { System.out.println("Person Created. " + this); }
	public void onDelete() { System.out.println("Person Died. " + this); }

	public int getTaxID() { return taxID; }
	public void setTaxID(int taxID) { this.taxID = taxID; }

	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }
	
	public void updateCity(String city) { address.setCity(city); }
	public void updateStreet(String street) { address.setStreet(street); }

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxID=" + taxID + ", address=" + address + "]";
	}

}
