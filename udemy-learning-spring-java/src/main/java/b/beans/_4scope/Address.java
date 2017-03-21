package b.beans._4scope;

class Address {

	private String street;
	private String city;

	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	String getStreet() { return street; }
	void setStreet(String street) { this.street = street; }

	String getCity() { return city; }
	void setCity(String city) { this.city = city; }

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
	}

}
