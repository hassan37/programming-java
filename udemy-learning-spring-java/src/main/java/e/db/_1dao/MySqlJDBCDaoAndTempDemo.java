package e.db._1dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySqlJDBCDaoAndTempDemo {

	public static void main(String[] args) {
		MySqlJDBCDaoAndTempDemo app = new MySqlJDBCDaoAndTempDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("e/db/_1dao/beans.xml");
		OffersDAO od = (OffersDAO) ctx.getBean("offersDAO");
		System.out.println(od.getOffers());
		((ClassPathXmlApplicationContext) ctx).close();

	}
}
