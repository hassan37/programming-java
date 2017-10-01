package guru.di.pofiles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIExampleApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("guru/di/pofiles/beans.xml");
		GreetingController con = (GreetingController) ctx.getBean("greetingController");
		con.sayGreetings();
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
