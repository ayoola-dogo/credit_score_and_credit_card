package com.ayoola.creditscore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayoola.creditscore.model.CreditScore;

public interface CreditScoreRepo extends JpaRepository<CreditScore, String> {
	

}
