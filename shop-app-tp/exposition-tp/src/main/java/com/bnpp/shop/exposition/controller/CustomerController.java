package com.bnpp.shop.exposition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.shop.application.management.CustomerManagement;
import com.bnpp.shop.domain.entity.CustomerEntity;

@RestController
@RequestMapping("/shop/customer")
public class CustomerController {
	
	@Autowired
	CustomerManagement customerManagement;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody CustomerEntity customer) {
		if (customer != null) {
			customerManagement.create(customer);
		}
	}
	
	
}
