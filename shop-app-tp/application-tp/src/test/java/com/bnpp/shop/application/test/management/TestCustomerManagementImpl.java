package com.bnpp.shop.application.test.management;

import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bnpp.shop.application.management.CustomerManagement;
import com.bnpp.shop.domain.entity.CustomerEntity;
import com.bnpp.shop.infrastructure.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCustomerManagementImpl {
	
	@Autowired
	private CustomerManagement customerManagement;
	
    @MockBean
    private CustomerRepository customerRepository;    
    
	@Test
	public void testFindCustomer() {

		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(1);
		customerEntity.setName("Toto");
		customerEntity.setPassword("RoiDeLaBlague");		
		
        Optional<CustomerEntity> customerEntityMock;
        customerEntityMock = Optional.ofNullable(customerEntity);
        
		when(customerRepository.findById(1)).thenReturn(customerEntityMock);
        
        Optional<CustomerEntity> customerResultEntity = customerManagement.findCustomer(1);
        
        //System.out.println(customerEntityMock);
        //System.out.println(customerResultEntity);
        
        assertThat(customerResultEntity.isPresent());
        assertThat(customerResultEntity.equals(customerEntityMock));
	}

	
}
