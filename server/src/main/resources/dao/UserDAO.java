package main.dao;

import java.util.List;

import main.models.Participant;

public interface User {

	List<Participant> list();
	

	Participant add(Participant user);
	
}
