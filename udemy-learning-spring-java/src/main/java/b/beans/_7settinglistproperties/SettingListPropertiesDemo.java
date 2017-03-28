package b.beans._7settinglistproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SettingListPropertiesDemo {

	public static void main(String[] args) {
		SettingListPropertiesDemo app = new SettingListPropertiesDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("b/beans/_7settinglistproperties/beans.xml");
		FruitBasket fb = (FruitBasket) ctx.getBean("fruitbasket");
		System.out.println(fb);
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
