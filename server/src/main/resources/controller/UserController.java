package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private UserDAO userDAO;
	
	public UserController(UserDAO dao) {
		this.userDAO = dao;
	}
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<Participants> list(){
		return userDAO.list();
	}
	
	@RequestMapping(path = "/users/add", method = RequestMethod.POST)
	public Participants add() {
		
	}

	
	
	


}
