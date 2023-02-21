package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Statement;

@Repository
public interface IStatementRepository extends JpaRepository<Statement,Long>{
	Statement findById(long id);

}
