package com.onlinetest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetest.entity.User;
import com.onlinetest.repository.UserRepository;

@Service
public class RegisterService {

	@Autowired
	UserRepository userRepo;
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public Optional<User> findDulicates(User user) {
		return userRepo.findByUsername(user.getUsername());
	}
	
}
