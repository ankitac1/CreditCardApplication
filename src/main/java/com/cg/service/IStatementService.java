package com.cg.service;

import java.util.List;

import com.cg.entity.Statement;

public interface IStatementService {
	
	public Statement addStatement(Statement statement);
	public Statement removeStatement(long id);
	public Statement updateStatement(long id, Statement statement);
	public Statement getStatement(long id);
	public List<Statement> getAllStatements();
	public Statement getBilledStatement(long id);
	public Statement getUnbilledStatement(long id);

}
