package e.db._1dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("offersDAO")
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Offer> getOffers() {
		return jdbc.query("select * from offer", OfferRowMapper.New());
	}

	public Offer getOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbc.queryForObject("select * from offer where id=:id", params, OfferRowMapper.New());
	}

	public boolean deleteOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbc.update("delete from offer where id=:id", params) == 1;
	}

	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("update offer set name=:name, text=:text, email=:email where id=:id", params) == 1;
	}

	public boolean create(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("insert into offer (name, text, email) values (:name, :text, :email)", params) == 1;
	}

}
