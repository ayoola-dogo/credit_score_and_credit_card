package com.ayoola.creditcard.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayoola.creditcard.model.CreditCard;

public interface CreditCardRepo extends JpaRepository<CreditCard, String> {

}
