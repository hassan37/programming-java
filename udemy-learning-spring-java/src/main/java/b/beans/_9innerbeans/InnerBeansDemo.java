package b.beans._9innerbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class InnerBeansDemo {

	public static void main(String[] args) {
		InnerBeansDemo app = new InnerBeansDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_9innerbeans/beans.xml");
		Jungle j = (Jungle) ctx.getBean("jungle");
		System.out.println(j);
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
