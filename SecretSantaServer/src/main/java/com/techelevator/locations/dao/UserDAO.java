package com.techelevator.locations.dao;

import java.util.List;

import com.techelevator.locations.models.Participant;


public interface UserDAO {

	List<Participant> list();
	

	Participant add();
	
}
