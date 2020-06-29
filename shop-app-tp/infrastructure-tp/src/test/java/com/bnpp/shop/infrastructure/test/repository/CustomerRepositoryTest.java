package com.bnpp.shop.infrastructure.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.bnpp.shop.domain.entity.CustomerEntity;
import com.bnpp.shop.infrastructure.repository.CustomerRepository;

//@RunWith(SpringRunner.class)      // avec Junit 4
//@ExtendWith(SpringExtension.class)	// avec Junit 5
//@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	private TestEntityManager entitymanager;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@BeforeEach
	public void Init() {
		CustomerEntity customer = new CustomerEntity();
		customer.setId(1);
		customer.setName("Warren Buffet");
		customer.setPassword("roiDeLaFinance");
		System.out.println(customer.getName());
		//entitymanager.persist(customer);
	}	
	/*
	@Test
	public void verifier_existsById() {
		Integer id = 1;
		assertThat(customerRepository.findById(id).isPresent());		
	}
	*/

}
