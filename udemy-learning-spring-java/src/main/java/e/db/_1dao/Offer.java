package e.db._1dao;

public class Offer {

	private Integer id;
	private String email;
	private String name;
	private String text;

	public Integer getId() {
		return this.id;
	}

	public Offer setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return this.email;
	}

	public Offer setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public Offer setName(String name) {
		this.name = name;
		return this;
	}

	public String getText() {
		return this.text;
	}

	public Offer setText(String text) {
		this.text = text;
		return this;
}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", email=" + email + ", name=" + name + ", text=" + text + "]";
	}

}