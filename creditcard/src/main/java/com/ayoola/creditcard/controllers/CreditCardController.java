package com.ayoola.creditcard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ayoola.creditcard.model.CreditCard;
import com.ayoola.creditcard.model.CreditScore;
import com.ayoola.creditcard.repo.CreditCardRepo;


@RestController
public class CreditCardController {
	
	@Autowired
	private CreditCardRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/issueCard")
	public boolean issueCard(@RequestBody CreditCard card) {
		if (getScore(card.getSsn()) >= 700) {
			repo.save(card);
			return true;
		}
		return false;
	}

	private int getScore(String ssn) {
		// Hitting the creditscore API end-point for a particular ssn and returning the creditscore. 
		CreditScore creditScore = restTemplate.getForObject("http://localhost:8080/creditscore/creditscores/" + ssn, CreditScore.class);
		return creditScore.getScore();
	}
}
