package com.bnpp.shop.infrastructure.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bnpp.shop.infrastructure.repository.ItemRepository;

//@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
class ItemRepositoryImplTest {

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	public void verifier_existeById() {
		Integer id = 1;
		assertThat(itemRepository.existsById(id)).isEqualTo("null");		
	}

}
