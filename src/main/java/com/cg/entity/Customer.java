package com.cg.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;



@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long customerId;
	@NotBlank(message="Name can't be blank")
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;
	private String address;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Account> accountlist;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Statement> statement;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<CreditCard> creditcard;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Payment> payment;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<Transaction> transaction;
	

	public Customer() {}
	
	public Customer(long customerId,String name,String email,String contactNo,LocalDate dob,String address) {
		super();
		this.customerId=customerId;
		this.name=name;
		this.email=email;
		this.contactNo=contactNo;
		this.dob=dob;
		this.address=address;
		
	}
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<Account> getAccountlist() {
		return accountlist;
	}

	public void setAccountlist(Set<Account> accountlist) {
		this.accountlist = accountlist;
	}
	public List<Statement> getStatement() {
		return statement;
	}

	public void setStatement(List<Statement> statement) {
		this.statement = statement;
	}
	
	public List<CreditCard> getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(List<CreditCard> creditcard) {
		this.creditcard = creditcard;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + "]";
	}
}
	