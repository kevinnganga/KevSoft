package com.kevo.co.ke.KevSoft.USERS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> GetAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/saving")
	public User CreateUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> FindUserById(@PathVariable("id")Long id) {
		return userService.getUserById(id);
		
	}
	
	@PutMapping("/users/{id}")
	public User UpdateUserById(@PathVariable("id")Long id,@RequestBody User user) {
		return userService.updateUserById(id, user);
	}
	
	@DeleteMapping("/user/{id}")
	public void DeleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
	
	@GetMapping("/user/{username}")
	public User GetUserByUserName(@PathVariable("username") String username) {
		return userService.getUserByUserName(username);
	}

}
