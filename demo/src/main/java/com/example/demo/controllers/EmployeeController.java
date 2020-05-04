package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UsersOne;
import com.example.demo.services.UserService;


@RestController
@RequestMapping("/users")
public class EmployeeController {

	//Autowire the service
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public List<UsersOne> getAllPersons() {
		
		return service.getAlluser();
		
	}
	@GetMapping("/{id}")
	public Optional<UsersOne> getPersonById(@PathVariable Long id) {
		
		return service.getById(id);
		
	}
	
	@GetMapping("/byName/{username}")
	public UsersOne getPersonByUSerName(@PathVariable String username) {
		
		return service.findUserByUserName(username);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<UsersOne> SavePersons(@RequestBody UsersOne user) {
		
		UsersOne users=service.SaveUSer(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(users);
		
	}
	
	@PutMapping("/{id}")
	public UsersOne updateUserById(@PathVariable Long id,@RequestBody UsersOne user) {
		
		return service.updateUserById(id, user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> DeleteUserById(@PathVariable Long id) {
		service.DeleteById(id);
		HashMap<String, String> map = new HashMap<>();
		map.put("Message", "User Deleted");
		return ResponseEntity.status(200).body(map);
	}
//	
//	
//	@GetMapping("/")
//	public ResponseEntity<Map<String, Object>> getAllDetails() {
//		
//		HashMap<String, Object> map = new HashMap<>();
//		
//		map.put("Employee",new Employee(1,"Abhishek Aryan","Electronic City"));
//		map.put("Name", "Abhishek");
//		map.put("Address", "Elelctronic city");
//		
//		return ResponseEntity.status(HttpStatus.CREATED).header("All gud", "All").body(map);
//	}

}
