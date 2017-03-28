package b.beans._8listofbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ListOfBeansDemo {

	public static void main(String[] args) {
		ListOfBeansDemo app = new ListOfBeansDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_8listofbeans/beans.xml");
		Jungle j = (Jungle) ctx.getBean("jungle");
		System.out.println(j);
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
