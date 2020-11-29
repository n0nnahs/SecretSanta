package com.techelevator.locations.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.locations.dao.UserDAO;
import com.techelevator.locations.models.Participant;




@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserDAO userDAO;
	
	public UserController(UserDAO dao) {
		this.userDAO = dao;
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<Participant> list(){
		return userDAO.list();
	}
	
	@RequestMapping(path = "/users/add", method = RequestMethod.POST)
	public Participant add() {
		return null;
	}

	
	
	


}
