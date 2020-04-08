package com.kevo.co.ke.KevSoft.USERS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	//Autowire UsersRepository
	@Autowired
    private UsersRepository usersRepository;
	
	
	//getAllusers Method
	public List<User> getAllUsers(){
		return usersRepository.findAll();
		
	}
	
	//Create users Method
	public User createUser(User user) {
		return usersRepository.save(user);
	}
	
	//get user By ID Method
	public Optional<User> getUserById(Long id) {
		Optional<User> user=usersRepository.findById(id);
		return user;
	}
	
	//Update user By ID Method
	public User updateUserById(Long id,User user) {
		user.setId(id);
		return usersRepository.save(user);
	}
	
	//Delete user By ID Method
	public void deleteUserById(Long id) {
		if(usersRepository.findById(id).isPresent()) {
			usersRepository.deleteById(id);
		}
	}
	
	//Get User By Username
	public User getUserByUserName(String username) {
		return usersRepository.findByUsername(username);
	}
}
