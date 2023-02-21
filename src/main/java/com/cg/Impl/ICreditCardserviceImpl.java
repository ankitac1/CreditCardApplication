package com.cg.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.CreditCard;
import com.cg.exceptions.CreditCardNotFoundException;
import com.cg.repository.ICreditCardRepository;
import com.cg.service.ICreditCardservice;

@Service
public class ICreditCardserviceImpl implements ICreditCardservice {
	
	@Autowired
	ICreditCardRepository creditcardrepository;

	@Override
	public CreditCard addCreditCard(CreditCard creditcard) {
		creditcardrepository.saveAndFlush(creditcard);
		return creditcard;
	}

	@Override
	public CreditCard removeCreditCard(long cardId) {
		if(creditcardrepository.existsById(cardId))
		{
		CreditCard c = creditcardrepository.findById(cardId).get();
		creditcardrepository.deleteById(cardId);
		return c;
		}
		else
		{
			throw new CreditCardNotFoundException("No Credit Card with given Id");
		}
	}


	@Override
	public CreditCard getCreditCard(long cardId) {
		if(creditcardrepository.existsById(cardId))
		{
		return creditcardrepository.findById(cardId).get();
		}
		else
		{
			throw new CreditCardNotFoundException("No Credit Card with given Id");
		}
	}

	@Override
	public List<CreditCard> getAllCreditCard() {
		return creditcardrepository.findAll();
	}

	@Override
	public CreditCard updateCreditCard(long cardId, CreditCard creditcard) {
		if(creditcardrepository.existsById(cardId))
		{
		CreditCard c = creditcardrepository.findById(cardId).get();
		c.setId(creditcard.getId());
		c.setCardname(creditcard.getCardname());
		c.setCardtype(creditcard.getCardtype());
		c.setCardnumber(creditcard.getCardnumber());
		c.setExpirydate(creditcard.getExpirydate());
		c.setBankname(creditcard.getBankname());
		return c;
		}
		else
		{
			throw new CreditCardNotFoundException("No Credit Card with given Id");	
		}
	}

}
