package d.annotatedwiring._3autoBeanDiscovery;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoBeansDiscoveryDemo {

	public static void main(String[] args) {
		AutoBeansDiscoveryDemo app = new AutoBeansDiscoveryDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("d/annotatedwiring/_3autoBeanDiscovery/beans.xml");
		Logger l = (Logger) ctx.getBean("logger");
		l.writeConsole("Hello Spring!");
		l.writeFile("Learning Autowiring!");

		((ClassPathXmlApplicationContext) ctx).close();

	}
}
