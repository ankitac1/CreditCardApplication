package com.cg.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Transaction;
import com.cg.exceptions.TransactionNotFoundException;
import com.cg.repository.ITransactionRepository;
import com.cg.service.ITransactionService;

@Service
public class ITransactionServiceImpl implements ITransactionService {

	@Autowired
	ITransactionRepository transactionRepository;
	
	@Override
	public Transaction addTransaction(Transaction transaction) {
		transactionRepository.saveAndFlush(transaction);
		return transaction;
	}

	@Override
	public Transaction removeTransaction(long id) {
		if(!transactionRepository.existsById(id))
		{
			throw new TransactionNotFoundException("Transaction not found ");
		}
		else {
		Transaction t=transactionRepository.findById(id).get();
		transactionRepository.deleteById(id);
		return t;
		}
		
	}

	@Override
	public Transaction updateTransaction(long id, Transaction transaction) {
		if(!transactionRepository.existsById(id))
		{
			throw new TransactionNotFoundException("Transaction not found ");
		}
		else {
		Transaction t=transactionRepository.findById(id).get();
		
		t.setTransId(transaction.getTransId());
		t.setCardNumber(transaction.getCardNumber());
		t.setTranDate(transaction.getTranDate());
		t.setStatus(transaction.getStatus());
		t.setAmount(transaction.getAmount());
		t.setAmount(transaction.getAmount());
		t.setPaymentMethod(transaction.getPaymentMethod());
		t.setDescription(transaction.getDescription());
		
		transactionRepository.save(t);

		return t;
		}
	}

	@Override
	public Transaction getTransactionDetails(long id) {
		if(!transactionRepository.existsById(id))
		{
			throw new TransactionNotFoundException("Transaction not found ");
		}
		else {

		return transactionRepository.findById(id).get();
		}
	}

	@Override
	public List<Transaction> getAllTransactions() {

		return transactionRepository.findAll();
	}

}
