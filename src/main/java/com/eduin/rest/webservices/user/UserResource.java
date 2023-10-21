package com.eduin.rest.webservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	//GET Users
	//retrieveAllUsers
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//GET Users/{id}
	@GetMapping("/users/{Id}")
	public User retrieveUser(@PathVariable int Id){
		return service.findOne(Id);
	}
	
	//Post Users
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		User savedUser = service.Save(user);
	}

}
