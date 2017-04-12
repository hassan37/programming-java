package c.autowiring._4default;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class DefaultAutowiringDemo {

	public static void main(String[] args) {
		DefaultAutowiringDemo app = new DefaultAutowiringDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("c/autowiring/_4default/beans.xml");
		Logger l = (Logger) ctx.getBean("logger");
		l.writeConsole("Hello Spring!");
		l.writeFile("Learning Autowiring!");

		((ClassPathXmlApplicationContext) ctx).close();

	}
}
