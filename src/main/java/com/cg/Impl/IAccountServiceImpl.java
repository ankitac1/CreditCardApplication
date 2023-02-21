package com.cg.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Account;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.repository.IAccountRepository;
import com.cg.service.IAccountService;

@Service
public class IAccountServiceImpl implements IAccountService {

	@Autowired
	IAccountRepository accountrepository;

	Account acc;

	@Override
	public Account addAccount(Account account) {

		accountrepository.saveAndFlush(account);
		return account;

	}

	@Override
	public Account removeAccount(long id) {
		if (accountrepository.existsById(id)) {
		accountrepository.deleteById(id);
		System.out.println("Account removed successfully");
		return acc;
		}
		else {
			throw new AccountNotFoundException("Account not found");
		}
	}

	@Override
	public Account updateAccount(long id, Account account) {
		if (accountrepository.existsById(account.getAccountId())) {
			Account acc = accountrepository.findById(account.getAccountId()).get();
			acc.setAccountName(account.getAccountName());
			acc.setBalance(account.getBalance());
			acc.setAccountType(account.getAccountType());

			accountrepository.save(acc);

			return acc;
		} else {

			throw new AccountNotFoundException("Account not found");
		}

	}

	@Override
	public Account getAccount(long id) {
		if (accountrepository.existsById(id)) {
			return accountrepository.findById(id).get();
		} else {
			throw new AccountNotFoundException("Account not found");
		}
	}

	@Override
	public List<Account> getAllAccounts() {
		System.out.println("getall accounts");
		return accountrepository.findAll();
	}

}
