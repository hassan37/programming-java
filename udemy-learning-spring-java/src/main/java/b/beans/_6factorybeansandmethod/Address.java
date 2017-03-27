package b.beans._6factorybeansandmethod;

class Address {

	private String street;
	private String city;

	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	public void onCreate() { System.out.println("Address Created. " + this); }
	public void onDelete() { System.out.println("Address Deleted."); }
	
	String getStreet() { return street; }
	void setStreet(String street) { this.street = street; }

	String getCity() { return city; }
	void setCity(String city) { this.city = city; }

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
	}

}
