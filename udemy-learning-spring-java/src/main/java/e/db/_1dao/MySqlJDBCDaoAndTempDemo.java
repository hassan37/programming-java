package e.db._1dao;

import java.util.ArrayList;
import java.util.List;

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
			tryJDBCBatchCreate(od);
			tryJDBCCreate(od);
			tryJDBCUpdate(od);
			tryJDBCDelete(od);
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Cannot Database Connection.");
		} catch (DataAccessException e) {
			System.out.println("Data Access Exception Occured. Msg: " + e.getMessage());
			System.out.println("Exception Class: " + e.getClass());
		}
		((ClassPathXmlApplicationContext) ctx).close();

	}

	private void tryJDBCBatchCreate(OffersDAO od) {
		Offer o1 = new Offer().setEmail("batch-created@email.com").setName("batch-created.name.1").setText("batch-cute created for sale");
		Offer o2 = new Offer().setEmail("batch-created@email.com").setName("batch-created.name.2").setText("batch-cute created for sale");
		Offer o3 = new Offer().setEmail("batch-created@email.com").setName("batch-created.name.3").setText("batch-cute created for sale");
		List<Offer> offers = new ArrayList<>(3);
		offers.add(o1);
		offers.add(o2);
		offers.add(o3);

		System.out.println(od.create(offers));
	}

	private void tryJDBCDelete(OffersDAO od) {
		System.out.println(od.getOffer(3));
		try {
			if (od.deleteOffer(3)) {
				System.out.println("Offer: 3 deleted.");
				return;
			}
		} catch (Exception e) {
			System.out.println("Unable to delete due to: " + e.getMessage());
		}
		System.out.println("Offer: 3 cannot be deleted.");
	}

	private void tryJDBCCreate(OffersDAO od) {
		Offer offer = new Offer().setEmail("created@email.com").setName("created.name").setText("cute created for sale");
		od.create(offer);
		System.out.println(od.getOffers());
	}

	private void tryJDBCUpdate(OffersDAO od) {
		System.out.println(od.getOffer(1));
		Offer offer = new Offer().setId(1).setEmail("updated@email.com").setName("updated.name").setText("cute cat for sale");
		od.update(offer);
		System.out.println(od.getOffer(1));
	}
}
