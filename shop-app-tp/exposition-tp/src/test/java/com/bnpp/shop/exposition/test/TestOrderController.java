package com.bnpp.shop.exposition.test;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bnpp.shop.application.management.OrderManagement;
import com.bnpp.shop.domain.entity.OrderEntity;

//@RunWith(SpringRunner.class)		// avec Junit 4
@ExtendWith(SpringExtension.class)	// avec Junit 5
@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class TestOrderController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderManagement orderManagement;
	
	// pourquoi le test fonctionne uniquement en Junit 5 avec Jupiter ???????
	// et comme le Junit 5 fait planter le maven install....
	@Test
	public void test_find_order_by_id() throws Exception {
		
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId(1);
		BigDecimal total = new BigDecimal(100.05);
		orderEntity.setTotal(total);
		Set<OrderEntity> setOrdersEntities = new HashSet<>();
		setOrdersEntities.add(orderEntity);
		Integer idCustomer = 53;
		
		// ne reconnait pas le given . Pourquoi ??????
		// given(orderManagement.findEntityByCustomer(idCustomer)).willReturn(setOrdersEntities);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/shop/order/find/order/1")		// lancement de la requete
				.accept(MediaType.APPLICATION_JSON))	// vérifier que le retour est du Json
				.andExpect(status().isOk());				// vérifie que le statut de réponse est OK


		// il existe d'autres Assert qu'on peut ajouter au mockMvc pour augmenter la couverture du test
		// ce mockMvc remplace AsserThat
		
	}

}
