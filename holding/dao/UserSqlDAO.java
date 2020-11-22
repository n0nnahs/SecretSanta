package main.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import main.models.Participant;

@Component
public class UserSqlDAO implements User {
	
	private JdbcTemplate jdbcTemplate;
	
	public UserSqlDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Participant> list() {
		List<Participant> participants = new ArrayList<>();
		String sql = "SELECT name, address, email, wishlist FROM users";
				
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Participant participantResult = mapRowToParticipant(results);
			participants.add(participantResult);
		}
		return participants;
				
	}

	@Override
	public void add(Participant user) {
		String sqlAdd = "INSERT INTO users(name, address, email, wishlist) VALUES (?, ?, ?, ?)";
		jdbcTemplate.add(sqlAdd, user.getName(), user.getAddress(), user.getEmail(), user.getWishlist());
	}

	
	private Participant mapRowToParticipant(SqlRowSet results) {
		Participant participant = new Participant();
		participant.setName(results.getString("name"));
		participant.setAddress(results.getString("address"));
		participant.setEmail(results.getString("email"));
		participant.setWishlist(results.getString("wishlist"));
		
		return participant;
	}
	
}
