package com.techelevator.locations.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.locations.models.Participant;



@Component
public class UserSqlDAO implements UserDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public UserSqlDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Participant> list() {
		List<Participant> participants = new ArrayList<>();
		String sql = "SELECT id, discord_name, address, wishlist FROM users";
				
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Participant participantResult = mapRowToParticipant(results);
			participants.add(participantResult);
		}
		return participants;
				
	}

	@Override
	public Participant add(Participant user) {
		String sqlAdd = "INSERT INTO users(id, discord_name, address, wishlist) VALUES (DEFAULT, ?, ?, ?) RETURNING id";

		SqlRowSet returningId = jdbcTemplate.queryForRowSet(sqlAdd, user.getName(), user.getAddress(), user.getWishlist());
		returningId.next();
		user.setId(returningId.getInt("id"));
		return user;
	}

	
	private Participant mapRowToParticipant(SqlRowSet results) {
		Participant participant = new Participant();
		participant.setId(results.getInt(1));
		participant.setName(results.getString("discord_name"));
		participant.setAddress(results.getString("address"));
		participant.setWishlist(results.getString("wishlist"));
		
		return participant;
	}
	
}
