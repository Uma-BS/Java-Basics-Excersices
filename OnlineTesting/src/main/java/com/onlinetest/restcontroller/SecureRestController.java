package com.onlinetest.restcontroller;

import java.util.Set;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetest.entity.User;
import com.onlinetest.model.AuthenticationResponse;
import com.onlinetest.security.JwtUtility;
import com.onlinetest.service.MyUserDetailsService;
import com.onlinetest.service.RegisterService;

@RestController
@CrossOrigin
public class SecureRestController {

	@Autowired
	RegisterService registerService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtility jwtTokenUtil;
	
	@PostMapping("/signin")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}catch (DisabledException e) {
			throw new Exception("User_Disabled", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		final GrantedAuthority userRole = userDetails.getAuthorities().iterator().next();
		
		return ResponseEntity.ok(new AuthenticationResponse(token, userRole));
		
	}
	
	@PostMapping("/signup")
	public void register(@RequestBody User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if(registerService.findDulicates(user).isEmpty()) {
			registerService.save(user);
		}else{
			throw new NonUniqueResultException("User already exists");
		}
	}
}
