package basics.app;

import basics.beans.Person;

public class App {

	public static void main(String[] args) {
		App app = new App();
		app.simplePersonDeomo();

	}

	private void simplePersonDeomo() {
		Person p = new Person();
		p.speak();
		
	}

}
