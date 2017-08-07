package e.db._1dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OfferRowMapper implements RowMapper<Offer> {

	public static RowMapper<Offer> New() {
		return new OfferRowMapper();
	}

	@Override
	public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Offer o = new Offer();
		o.setId(rs.getInt("id"));
		o.setEmail(rs.getString("email"));
		o.setName(rs.getString("name"));
		o.setText(rs.getString("text"));

		return o;
	}

}
