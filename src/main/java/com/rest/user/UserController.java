package com.rest.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

@RestController
public class UserController {
	
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userDaoService.findAll();
	}
	

	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user= userDaoService.findUser(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody User user) {
		User newUSer= userDaoService.saveUSer(user);
		
		URI location1= ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(newUSer.getId()).toUri();
		
		return ResponseEntity.created(location1).build();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
		User user=userDaoService.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("User is not found with id="+id);
		}
		return ResponseEntity.ok().build();
	}

}
