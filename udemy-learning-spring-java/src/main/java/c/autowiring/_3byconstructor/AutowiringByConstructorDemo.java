package c.autowiring._3byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class AutowiringByConstructorDemo {

	public static void main(String[] args) {
		AutowiringByConstructorDemo app = new AutowiringByConstructorDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("c/autowiring/_3byconstructor/beans.xml");
		Logger l = (Logger) ctx.getBean("logger");
		l.writeConsole("Hello Spring!");
		l.writeFile("Learning Autowiring!");

		((ClassPathXmlApplicationContext) ctx).close();

	}
}
