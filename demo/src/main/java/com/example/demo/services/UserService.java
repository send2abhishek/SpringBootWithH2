package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UsersOne;
import com.example.demo.repositiory.UserRepos;

//service
@Service
public class UserService {
	
	@Autowired
	private UserRepos userRepos;
	
	//getAll user
	public List<UsersOne> getAlluser(){
		
		return userRepos.findAll();
	}
	
	//saveuser
		public UsersOne SaveUSer(UsersOne user){
			
			return userRepos.save(user);
			
		}
		
		public Optional<UsersOne> getById(Long id) {
			
			return userRepos.findById(id);
		}
		
		public UsersOne updateUserById(Long id,UsersOne user) {
			
			user.setId(id);
			return userRepos.save(user);
			
		}
		
		public void DeleteById(Long id) {
			
			if(userRepos.findById(id).isPresent()) {
				userRepos.deleteById(id);
				
			}
		}
		
		
public UsersOne findUserByUserName(String username) {
			
			
			return userRepos.findByUserName(username);
			
		}


}
