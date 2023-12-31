package com.eduin.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Edwin", new Date()));
		users.add(new User(2, "Benson", new Date()));
		users.add(new User(3, "Richard", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User Save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
		
	}
	
	public User findOne(int Id) {
		for(User user:users) {
			if(user.getId()==Id) {
				return user;
			}
			
		}
		return null;
		
		
	}
	
	public User deleteById(int Id){
		Iterator<User>iterator = users.iterator();
		
		while(iterator.hasNext()) {
			User user = iterator.next();
		if(user.getId() == Id) {
			iterator.remove();
			return user;
		}
			
	}
		return null;
	
	}
		
	
	
}
