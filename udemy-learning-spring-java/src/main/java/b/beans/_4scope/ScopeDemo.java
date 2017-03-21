package b.beans._4scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ScopeDemo {

	public static void main(String[] args) {
		ScopeDemo app = new ScopeDemo();
		app.singletonDemo();
		app.prototypeDemo();
	}

	private void singletonDemo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_4scope/beans.xml");

		Person p1 = (Person) ctx.getBean("person");
		Person p2 = (Person) ctx.getBean("person");

		System.out.println(p1);
		System.out.println(p2);

		p1.updateCity("Islamabad");
		System.out.println(p1);
		System.out.println(p2);

		p2.updateCity("Jehlum");

		System.out.println(p1);
		System.out.println(p2);

		((ClassPathXmlApplicationContext) ctx).close();

	}

	private void prototypeDemo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_4scope/beans.xml");

		Address a1 = (Address) ctx.getBean("address");
		Address a2 = (Address) ctx.getBean("address");

		System.out.println(a1);
		System.out.println(a2);

		a1.setCity("Islamabad");
		a2.setCity("Jehlum");

		System.out.println(a1);
		System.out.println(a2);

		((ClassPathXmlApplicationContext) ctx).close();

	}

}
