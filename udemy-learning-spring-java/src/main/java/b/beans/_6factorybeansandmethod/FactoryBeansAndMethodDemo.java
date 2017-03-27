package b.beans._6factorybeansandmethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class FactoryBeansAndMethodDemo {

	public static void main(String[] args) {
		FactoryBeansAndMethodDemo app = new FactoryBeansAndMethodDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_6factorybeansandmethod/beans.xml");

		Person p1 = (Person) ctx.getBean("person");
		Person p2 = (Person) ctx.getBean("person2");
		p1.setTaxID(99);
		p2.setTaxID(88);
		p1.updateCity("Isb");
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
