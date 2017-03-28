package b.beans._11arbitrarymapsasbeanproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ArbitraryMapsAsBeanPropertiesDemo {

	public static void main(String[] args) {
		ArbitraryMapsAsBeanPropertiesDemo app = new ArbitraryMapsAsBeanPropertiesDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_11arbitrarymapsasbeanproperties/beans.xml");
		Jungle j = (Jungle) ctx.getBean("jungle");
		System.out.println(j);
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
