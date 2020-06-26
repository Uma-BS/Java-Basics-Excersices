package com.onlinetest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Questions")
@Data
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	
	@Column(length = 1000)
	private String question;
	
	@Column
	private boolean coded;
	
	@Column(length = 10000)
	private String code;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Option> options = new HashSet<>();
	
	@Column
	private String answer;
}