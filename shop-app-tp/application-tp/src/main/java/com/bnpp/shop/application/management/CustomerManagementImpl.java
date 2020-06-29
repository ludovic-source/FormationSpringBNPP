package com.bnpp.shop.application.management;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.shop.domain.entity.CustomerEntity;
import com.bnpp.shop.infrastructure.repository.CustomerRepository;

@Service
@Transactional
public class CustomerManagementImpl implements CustomerManagement{

	@Autowired
	CustomerRepository customerRepository;
	
	private static final Log logger = LogFactory.getLog(CustomerManagementImpl.class);
	
	@Override
	public void create(CustomerEntity customer) {
		logger.info("create customer : " + customer.getName());
		customerRepository.save(customer);	
		
	}

	@Override
	public Optional<CustomerEntity> findCustomer(Integer id) {		
		logger.info("find customer");
		return customerRepository.findById(id);
		
	}

	@Override
	public void update(CustomerEntity customer) {
		customerRepository.save(customer);
		logger.info("update customer");
		
	}

}
