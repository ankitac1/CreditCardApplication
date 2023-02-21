package com.cg.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.entity.Transaction;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction,Long>  {
	
	
	
	


}
