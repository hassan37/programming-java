package b.beans.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class BeanConstructorArgDemo {

	public static void main(String[] args) {
		BeanConstructorArgDemo app = new BeanConstructorArgDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/configuration/beans.xml");
		Person p = (Person) ctx.getBean("person");
		System.out.println(p);
		p.speak();
		((ClassPathXmlApplicationContext) ctx).close();

	}
	
}
