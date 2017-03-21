package b.beans._2settingproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SettingBeanPropertiesDemo {

	public static void main(String[] args) {
		SettingBeanPropertiesDemo app = new SettingBeanPropertiesDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_2settingproperties/beans.xml");
		Person p = (Person) ctx.getBean("person");
		System.out.println(p);
		p.speak();
		((ClassPathXmlApplicationContext) ctx).close();

	}
	
}
