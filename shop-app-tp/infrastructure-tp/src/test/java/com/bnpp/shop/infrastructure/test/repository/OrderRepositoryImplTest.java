package com.bnpp.shop.infrastructure.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bnpp.shop.infrastructure.repository.OrderRepository;

//@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
class OrderRepositoryImplTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void verifier_existeById() {
		Integer id = 1;
		assertThat(orderRepository.existsById(id)).isEqualTo("null");		
	}

}
