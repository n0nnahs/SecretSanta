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
		String sql = "SELECT discord_name, address, wishlist FROM users";
				
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Participant participantResult = mapRowToParticipant(results);
			participants.add(participantResult);
		}
		return participants;
				
	}

	@Override
	public Participant add() {
		String sqlAdd = "INSERT INTO users(discord_name, address, wishlist) VALUES (?, ?, ?)";
		Participant user = null;
		//jdbcTemplate.add(sqlAdd, user.getName(), user.getAddress(), user.getEmail(), user.getWishlist());
		return user;
	}

	
	private Participant mapRowToParticipant(SqlRowSet results) {
		Participant participant = new Participant();
		participant.setName(results.getString("discord_name"));
		participant.setAddress(results.getString("address"));
		participant.setWishlist(results.getString("wishlist"));
		
		return participant;
	}
	
}
