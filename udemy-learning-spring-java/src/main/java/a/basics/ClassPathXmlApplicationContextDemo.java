package a.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ClassPathXmlApplicationContextDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContextDemo app = new ClassPathXmlApplicationContextDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("a/basics/beans.xml");
		Person p = (Person) ctx.getBean("person");
		p.speak();
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
