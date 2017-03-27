package b.beans._5initdestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class InitDestroyMethodsDemo {

	public static void main(String[] args) {
		InitDestroyMethodsDemo app = new InitDestroyMethodsDemo();
		app.initDestroyMethodsDemo();
	}

	/**
	 * for 'prototype' instances, Spring does not call destroy method
	 * hence for Address instances, 'onDelete' won't be called
	 */
	private void initDestroyMethodsDemo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_5initdestroy/beans.xml");

		Person p1 = (Person) ctx.getBean("person");
		p1.speak();
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
