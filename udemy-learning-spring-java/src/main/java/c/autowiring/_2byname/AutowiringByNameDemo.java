package c.autowiring._2byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class AutowiringByNameDemo {

	public static void main(String[] args) {
		AutowiringByNameDemo app = new AutowiringByNameDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("c/autowiring/_2byname/beans.xml");
		Logger l = (Logger) ctx.getBean("logger");
		l.writeConsole("Hello Spring!");
		l.writeFile("Learning Autowiring!");

		((ClassPathXmlApplicationContext) ctx).close();

	}
}
