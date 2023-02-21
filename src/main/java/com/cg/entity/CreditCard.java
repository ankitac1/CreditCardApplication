package com.cg.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class CreditCard {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	public long id;
	@NotBlank(message="CardName can't be blank")
	public String cardname;
	public String cardtype;
	@NotBlank(message="CardNumber can't be Null")
	public String cardnumber;
	public LocalDate expirydate;
	public String bankname;

	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCard(long id, String cardname, String cardtype, String cardnumber, LocalDate expirydate,
			String bankname) {
		super();
		this.id = id;
		this.cardname = cardname;
		this.cardtype = cardtype;
		this.cardnumber = cardnumber;
		this.expirydate = expirydate;
		this.bankname = bankname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	@Override
	public String toString() {
		return "CreditCard1 [id=" + id + ", cardname=" + cardname + ", cardtype=" + cardtype + ", cardnumber="
				+ cardnumber + ", expirydate=" + expirydate + ", bankname=" + bankname + "]";
	}

}
