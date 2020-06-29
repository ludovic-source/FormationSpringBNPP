package com.bnpp.shop.application.management;

import java.util.Optional;

import com.bnpp.shop.domain.entity.CustomerEntity;

public interface CustomerManagement {
	
	void create(CustomerEntity customer);
	
	Optional<CustomerEntity> findCustomer(Integer id);
	
	void update(CustomerEntity customer);

}
