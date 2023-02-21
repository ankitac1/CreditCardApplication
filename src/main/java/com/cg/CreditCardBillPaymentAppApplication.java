package com.cg;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.repository.ICustomerRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CreditCardBillPaymentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardBillPaymentAppApplication.class, args);
		}
}

		
		
		


