package com.eduin.rest.webservices.user;

import java.net.URI;
import java.util.Iterator;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.hateoas.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	public Resource<User> retrieveUser(@PathVariable int Id){
		User user = service.findOne(Id);
		if(user == null)
			throw new userNotFoundException("id-" +Id);
		//HATEOS

		//"all-users", /users, SERVER_PATH + "/users"

		//retrieveAllUsers

		Resource<User> resource = new Resource<User>(user);

		ControllerLinkBuilder linkTo =
				linkTo(methodOn(this.getClass().retrieveAllUsers());
				resource.add(linkTo.withrel("all-users"));
		

		return resource;


	}

	//Post Users
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.Save(user);

		//CREATE

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{/Id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	//Delete User

	@DeleteMapping("/users/{Id}")
	public void deleteUser(@PathVariable int Id){
		User user = service.deleteById(Id);
		if(user == null)
			throw new userNotFoundException("id-" +Id);

	}








}
