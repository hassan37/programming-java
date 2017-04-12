package c.autowiring._5removingduplicates;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class RemovingAmbiguitiesInAutowiringDemo {

	public static void main(String[] args) {
		RemovingAmbiguitiesInAutowiringDemo app = new RemovingAmbiguitiesInAutowiringDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("c/autowiring/_5removingduplicates/beans.xml");
		Logger l = (Logger) ctx.getBean("logger");
		l.writeConsole("Hello Spring!");
		l.writeFile("Learning Autowiring!");

		((ClassPathXmlApplicationContext) ctx).close();

	}
}
