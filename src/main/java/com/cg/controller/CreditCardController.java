package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.CreditCard;
import com.cg.service.ICreditCardservice;

@RestController
@RequestMapping("/creditcardapi")
public class CreditCardController {

	@Autowired
	ICreditCardservice CreditCardService;

	@PostMapping("/addcreditcard")
	public CreditCard addCreditCard(@Valid @RequestBody CreditCard creditCard) {

		return CreditCardService.addCreditCard(creditCard);
	}

	@GetMapping("/removecreditcard/{cardId}")
	public CreditCard removeCreditCard(@PathVariable("cardId") int cardId) {
		return CreditCardService.removeCreditCard(cardId);
	}

	@PutMapping("/updatecreditcard/{cardId}")
	public CreditCard updateCreditCard(@PathVariable("cardId") int cardId, @RequestBody CreditCard creditCard) 
	{
		return CreditCardService.updateCreditCard(cardId, creditCard);
	}
	
	@GetMapping("/getcreditcard/{cardId}")
	public CreditCard getCreditCard(@PathVariable("cardId")int cardId)
	{
		return CreditCardService.getCreditCard(cardId);
	}

	@GetMapping("/getallcreditcards")
	public List<CreditCard> getAllCreditCard() {
		return CreditCardService.getAllCreditCard();
	}

}
