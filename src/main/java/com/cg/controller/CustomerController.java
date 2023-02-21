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

import com.cg.entity.Customer;
import com.cg.service.ICustomerService;

@RestController
@RequestMapping("/customerapi")
public class CustomerController
{
	@Autowired
	ICustomerService CustomerService;
	
	@PostMapping("/addcustomer")
	public  Customer addCustomer(@Valid @RequestBody Customer customer)
	{
		return CustomerService.addCustomer(customer);
	}
	
	@GetMapping("/removecustomer/{custId}")
	public Customer removeCustomer(@PathVariable("custId")long custId)
	{
		return  CustomerService.removeCustomer(custId);
	}
	@PutMapping("/updatecustomer/{custId}")
	public Customer updateCustomer(@PathVariable("custId")long custId,@RequestBody Customer customer)
	{
		return CustomerService.updateCustomer(custId,customer);
	}
	@GetMapping("/getcustomer/{custId}")
	public Customer getCustomer(@PathVariable("custId")long custId)
	{
		return CustomerService.getCustomer(custId);
	}
	@GetMapping("/getallcustomers")
	public List<Customer>getAllCustomers()
	{
		return CustomerService.getAllCustomers();
	}
}


