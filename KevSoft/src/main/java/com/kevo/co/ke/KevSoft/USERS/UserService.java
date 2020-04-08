package com.kevo.co.ke.KevSoft.USERS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
	public User createUser(User user) throws UserExistsException{
		//CHECK IF THE USER EXISTS
		User ifUserexists=usersRepository.findByUsername(user.getUsername()); //picks the username provided by the username getter in the User Entity
		
		if(ifUserexists !=null) {
			throw new UserExistsException("User Already Exists in the Repository"); 
		}
		return usersRepository.save(user);
	}
	
	//get user By ID Method
	public Optional<User> getUserById(Long id) throws UserNotFoundException{
		Optional<User> user=usersRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User Not Found in the Repository");
		}
		return user;
	}
	
	//Update user By ID Method
	public User updateUserById(Long id,User user) throws UserNotFoundException {
		Optional<User> userToUpdate=usersRepository.findById(id);
		if(!userToUpdate.isPresent()) {
			throw new UserNotFoundException("User Not Found in the Repository,Provide the correct user ID");
		}
		user.setId(id);
		return usersRepository.save(user);
	}
	
	//Delete user By ID Method
	public void deleteUserById(Long id) {
		Optional<User> userToDelete=usersRepository.findById(id);
		if(!userToDelete.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Not Found in the Repository,Provide the correct user ID");//WE IMPLIMENT THE EXCEPTION HERE COZ THE DELETE MAPPING IN THE CONTROLLER DON'T HAVE A RETURN TYPE
		}
		
		usersRepository.deleteById(id);
	}
	
	//Get User By Username
	public User getUserByUserName(String username) {
		return usersRepository.findByUsername(username);
	}
}
