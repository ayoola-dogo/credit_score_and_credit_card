package com.ayoola.creditscore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ayoola.creditscore.model.CreditScore;
import com.ayoola.creditscore.repo.CreditScoreRepo;

@RestController
public class CreditScoreController {
	
	@Autowired
	CreditScoreRepo repo;
	
	// Using the HTTP GET method to call this end-point
	@GetMapping("/creditscores/{ssn}")
	public CreditScore getCreditScore(@PathVariable("ssn") String ssn) {
		return repo.findById(ssn).get();
	}
}
