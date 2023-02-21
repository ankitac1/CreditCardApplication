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

import com.cg.entity.Transaction;
import com.cg.service.ITransactionService;

@RestController
@RequestMapping("/transactionapi")
public class TransactionController {
	
	@Autowired
	ITransactionService TransactionService;
	
	@PostMapping("/addtransaction")
	public Transaction addTransaction(@Valid @RequestBody Transaction transaction)
	{
		return TransactionService.addTransaction(transaction);
	}
	
	@GetMapping("/removetransaction/{id}")
	public Transaction removeTransaction(@PathVariable("id")long id) 
	{
		
		return TransactionService.removeTransaction(id);
		
	}
	
	@PutMapping("/updatetransaction/{id}")
	public Transaction updateTransaction(@PathVariable("id")int id,@RequestBody Transaction transaction)
	{
		return TransactionService.updateTransaction(id, transaction);
		
	}
	
	@GetMapping("/gettransactiondetails/{id}")
	public Transaction getTransactionDetails(@PathVariable("id")int id)
	{
		return TransactionService.getTransactionDetails(id);
		
	}
	
	@GetMapping("/getalltransactions")
	public List<Transaction> getAllTransactions()
	{
		return TransactionService.getAllTransactions();
	}
	

}
