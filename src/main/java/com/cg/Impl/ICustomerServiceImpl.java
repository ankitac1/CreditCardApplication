package com.cg.Impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.exceptions.CustomerNotFoundException;
import com.cg.repository.ICustomerRepository;
import com.cg.service.ICustomerService;

@Service
public  class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		customerRepository.saveAndFlush(customer);
		return customer;
	}

	@Override
	public Customer removeCustomer(long custId) 
	{
		if(!customerRepository.existsById(custId))
		{
			throw new CustomerNotFoundException("Customer not found");
		}
		else 
		{
		Customer c=customerRepository.findById(custId).get();
		customerRepository.deleteById(custId);
		return c;
	}
	}

	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		if(!customerRepository.existsById(custId))
		{
			throw new CustomerNotFoundException("Customer not found");
		}
		else
		{
		Customer c=customerRepository.findById(custId).get();
		
		c.setCustomerId(customer.getCustomerId());
		c.setName(customer.getName());
		c.setEmail(customer.getEmail());
		c.setContactNo(customer.getContactNo());
		c.setDob(customer.getDob());
		c.setAddress(customer.getAddress());
		
		return c;
	}
	}
	@Override
	public Customer getCustomer(long custId) {
		if(!customerRepository.existsById(custId))
		{

			throw new CustomerNotFoundException("Customer not found");
		}
		else {
		return customerRepository.findById(custId).get();
	}
	}

	@Override
	public List<Customer>getAllCustomers() {
		
		return customerRepository.findAll();
	}
}
