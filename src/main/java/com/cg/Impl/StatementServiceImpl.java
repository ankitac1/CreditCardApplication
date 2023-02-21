package com.cg.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Statement;
import com.cg.exceptions.StatementNotFoundException;
import com.cg.repository.IStatementRepository;
import com.cg.service.IStatementService;

@Service
public class StatementServiceImpl implements IStatementService{

	@Autowired
	IStatementRepository statementrepository;
	
	@Override
	public Statement addStatement(Statement statement) {
		statementrepository.saveAndFlush(statement);
		return statement;
	}

	@Override
	public Statement removeStatement(long id) {
		if(statementrepository.existsById(id)) {
		Statement s = statementrepository.findById(id);
		statementrepository.deleteById(id);
		return s;
		}
		else
		{
			throw new StatementNotFoundException("Statement Not Found");
		}
	}

	@Override
	public Statement updateStatement(long id, Statement statement) {
		if(statementrepository.existsById(id)) {
			Statement s = statementrepository.findById(statement.getStatementId());
			s.setStatementId(statement.getStatementId());
			s.setDueAmount(statement.getDueAmount());;
			s.setBillingDate(statement.getBillingDate());
			s.setDueDate(statement.getDueDate());
			statementrepository.save(s);
			return s;
		}
		else
		{
			throw new StatementNotFoundException("Statement Not Found");
		}
			
	}

	@Override
	public Statement getStatement(long id) {
		if(statementrepository.existsById(id)) {
		return statementrepository.findById(id);
		}
		else
		{
			throw new StatementNotFoundException("Statement Not Found");
		}
			
	}

	@Override
	public List<Statement> getAllStatements() {
		return statementrepository.findAll();
	}

	@Override
	public Statement getBilledStatement(long id) {
		Statement billedStatement = statementrepository.findById(id);
		if(billedStatement != null && billedStatement.getDueAmount() > 0) {
			Statement statement = new Statement();
			statement.setStatementId(billedStatement.getStatementId());
			statement.setDueAmount(billedStatement.getDueAmount());
			statement.setBillingDate(billedStatement.getBillingDate());
			statement.setDueDate(billedStatement.getDueDate());
			//statement.setCustomer(billedStatement.getCustomer());
			return statement;
		} else {
			throw new StatementNotFoundException("Statement not found with the given id");
		}
	}

	@Override
	public Statement getUnbilledStatement(long id) {
		Statement unbilledStatement = statementrepository.findById(id);
		if(unbilledStatement != null && unbilledStatement.getDueAmount() == 0) {
			Statement statement = new Statement();
			statement.setStatementId(unbilledStatement.getStatementId());
			statement.setDueAmount(unbilledStatement.getDueAmount());
			statement.setBillingDate(unbilledStatement.getBillingDate());
			statement.setDueDate(unbilledStatement.getDueDate());
			//statement.setCustomer(unbilledStatement.getCustomer());
			return statement;
		} else {
			throw new StatementNotFoundException("Statement not found with the given id");
		}
	}

}
