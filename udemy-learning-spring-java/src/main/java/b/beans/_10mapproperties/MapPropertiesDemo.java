package b.beans._10mapproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class MapPropertiesDemo {

	public static void main(String[] args) {
		MapPropertiesDemo app = new MapPropertiesDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_10mapproperties/beans.xml");
		Jungle j = (Jungle) ctx.getBean("jungle");
		System.out.println(j);
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
