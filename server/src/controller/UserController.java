package controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.dao.UserDAO;
import main.models.Participant;

@RestController
public class UserController {
	
	private UserDAO userDAO;
	
	public UserController(UserDAO dao) {
		this.userDAO = dao;
	}
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<Participant> list(){
		return userDAO.list();
	}
	
	@RequestMapping(path = "/users/add", method = RequestMethod.POST)
	public Participant add() {
		return null;
	}

	
	
	


}
