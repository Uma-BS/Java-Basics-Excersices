package com.onlinetest.restcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class HomeController {
	
	
	@GetMapping
	public String home() {
		return "<h2>Welcome to Home Page!!</h2>";
	}
	
	@GetMapping("/user")
	public String user(){
		return "<h2>Welcome User.. </h2>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h2> Welcome Admin..</h2> ";
	}
	
	@GetMapping("/everyone")
	public String test() {
		return "<h2> Welcome everyone..</h2>";
	}
	
}
