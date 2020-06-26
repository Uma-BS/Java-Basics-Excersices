package com.onlinetest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onlinetest.entity.MyUserDetails;
import com.onlinetest.entity.User;
import com.onlinetest.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Username passed to Userdetails Service: " + username);
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(()-> new UsernameNotFoundException("User not found: " + username));
		return user.map(MyUserDetails::new).get();
	}

}
