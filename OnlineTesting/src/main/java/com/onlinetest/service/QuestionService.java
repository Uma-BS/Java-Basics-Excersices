package com.onlinetest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetest.entity.Question;
import com.onlinetest.repository.QuestionRepository;


@Service
public class QuestionService {

	@Autowired
	private QuestionRepository qtnRep;
	
	public void add(Question qtn) {
		qtnRep.save(qtn);
	}
	
	public Collection<Question> getAll() {
		List<Question> questions = new ArrayList<>();
		qtnRep.findAll().forEach(question -> questions.add(question));
		return questions;
	}
	
	public Question getById(int qtnNum) {
		return qtnRep.findById(qtnNum).get();
	}
	
	public void deleteById(int qtnNum) {
		qtnRep.deleteById(qtnNum);
	}
	
	public void deleteAll() {
		qtnRep.deleteAll();
	}
	
	public Map<Integer, String> getAnswers(){
		Map<Integer, String> answers = new HashMap<>();
		List<Question> question = (List<Question>)this.getAll();
		for (Question qtn : question) {
			answers.put(qtn.getNum(), qtn.getAnswer());
		}
		return answers;
	}

}
