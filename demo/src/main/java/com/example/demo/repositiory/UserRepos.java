package com.example.demo.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.UsersOne;

@Repository
public interface UserRepos extends JpaRepository<UsersOne, Long> {
	
	UsersOne findByUserName(String username);
	
}
