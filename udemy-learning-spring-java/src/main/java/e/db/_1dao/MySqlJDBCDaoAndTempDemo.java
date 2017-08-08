package e.db._1dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class MySqlJDBCDaoAndTempDemo {

	public static void main(String[] args) {
		MySqlJDBCDaoAndTempDemo app = new MySqlJDBCDaoAndTempDemo();
		app.demo();
	}

	private void demo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("e/db/_1dao/beans.xml");
		OffersDAO od = (OffersDAO) ctx.getBean("offersDAO");
		try {
			System.out.println(od.getOffers());
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Cannot Database Connection.");
		} catch (DataAccessException e) {
			System.out.println("Data Access Exception Occured. Msg: " + e.getMessage());
			System.out.println("Exception Class: " + e.getClass());
		}
		((ClassPathXmlApplicationContext) ctx).close();

	}
}
