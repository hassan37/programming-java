package a.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

class FileSystemXmlApplicationContextDemo {

	public static void main(String[] args) {
		FileSystemXmlApplicationContextDemo app = new FileSystemXmlApplicationContextDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		Person p = (Person) ctx.getBean("person");
		p.speak();
		((FileSystemXmlApplicationContext) ctx).close();
	}
}
