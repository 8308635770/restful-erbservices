package com.rest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users=new ArrayList<User>();
	private static int usersCount=3;
	
	static {
		users.add(new User(1,"Shivam",new Date()));
		users.add(new User(2,"Shivam2",new Date()));
		users.add(new User(3,"Shivam3",new Date()));

	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User saveUSer(User user) {
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findUser(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User>iterator=users.iterator();
		while (iterator.hasNext()) {
			User user=iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
