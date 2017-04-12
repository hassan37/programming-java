package d.annotatedwiring._2qualifiers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class AutowiringViaQualifiersWithInitDestroyDemo {

	public static void main(String[] args) {
		AutowiringViaQualifiersWithInitDestroyDemo app = new AutowiringViaQualifiersWithInitDestroyDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("d/annotatedwiring/_2qualifiers/beans.xml");
		Logger l = (Logger) ctx.getBean("logger");
		l.writeConsole("Hello Spring!");
		l.writeFile("Learning Autowiring!");

		((ClassPathXmlApplicationContext) ctx).close();

	}
}
