package com.techelevator.locations.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.locations.dao.UserDAO;
import com.techelevator.locations.models.Participant;




@RestController
@RequestMapping("/users")
@CrossOrigin(origins= "*")
public class UserController {

	private UserDAO userDAO;

	public UserController(UserDAO dao) {
		this.userDAO = dao;
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<Participant> list(){
		return userDAO.list();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "", method = RequestMethod.POST)
	public Participant add(@RequestBody Participant participant) {
		return userDAO.add(participant);
	}






}
