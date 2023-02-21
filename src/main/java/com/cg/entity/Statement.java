package com.cg.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;


@Entity
public class Statement{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long statementId;
	@Min(value=1000,message="Dueamount should be greater than 1000")
	private double dueAmount;
	private LocalDate billingDate;
	private LocalDate dueDate;
    @ManyToOne
	public Customer customer;
	
	public Statement() {}
	
	public Statement(long statementId, double dueAmount, LocalDate billingDate, LocalDate dueDate, Customer customer) {
		super();
		this.statementId = statementId;
		this.dueAmount = dueAmount;
		this.billingDate = billingDate;
		this.dueDate = dueDate;
		this.customer = customer;
	}
	public long getStatementId() {
		return statementId;
	}
	public void setStatementId(long statementId) {
		this.statementId = statementId;
	}
	public double getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Statement [statementId=" + statementId + ", dueAmount=" + dueAmount + ", billingDate=" + billingDate
				+ ", dueDate=" + dueDate + ", customer=" + customer + "]";
	}
	
	

}
