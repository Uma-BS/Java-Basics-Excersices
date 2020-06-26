package com.onlinetest.restcontroller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetest.entity.Question;
import com.onlinetest.service.QuestionService;




@RestController
@CrossOrigin
public class QuestionController {

	@Autowired
	private QuestionService qtnService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/savequestion")
	public void addQtn(@RequestBody Question qtn) {
		qtnService.add(qtn);
		System.out.println(qtn.toString());
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/getquestions")
	public Collection<Question> getQtns() {
		return qtnService.getAll();
	}
	
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@GetMapping("/getanswers")
	public Map<Integer, String> answers(){
		return qtnService.getAnswers();
	}
}
