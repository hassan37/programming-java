package b.beans._3dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class DependencyInjectionThroughXMLDemo {

	public static void main(String[] args) {
		DependencyInjectionThroughXMLDemo app = new DependencyInjectionThroughXMLDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_3dependencyinjection/beans.xml");
		Person p = (Person) ctx.getBean("person");
		System.out.println(p);
		((ClassPathXmlApplicationContext) ctx).close();

	}
	
}
