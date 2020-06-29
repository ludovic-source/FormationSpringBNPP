package com.bnpp.shop.application.management;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.shop.domain.entity.CustomerEntity;
import com.bnpp.shop.domain.entity.ItemEntity;
import com.bnpp.shop.domain.entity.OrderEntity;
import com.bnpp.shop.infrastructure.repository.ItemRepository;
import com.bnpp.shop.infrastructure.repository.OrderRepository;

@Service
@Transactional
public class OrderManagementImpl implements OrderManagement {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerManagement customerManagement;
	
	private static Set<ItemEntity> itemsEntitiesFind;
	
	private static final Log logger = LogFactory.getLog(OrderManagementImpl.class);
	
	public void create(OrderEntity order) {
		orderRepository.save(order);
		logger.info("create order");
		
	}	

	public Optional<OrderEntity> findEntity(Integer id) {
		logger.info("find Order by id");
		return orderRepository.findById(id);
	}

	public Set<OrderEntity> findEntityByCustomer(Integer idCustomer) {
		logger.info("find Order by Customer");
		Optional<CustomerEntity> customer = customerManagement.findCustomer(idCustomer);
		return orderRepository.findByCustomer(customer);
	}

	public void update(OrderEntity order) {
		orderRepository.save(order);
		logger.info(order);
		
	}

	@Override
	public Set<ItemEntity> findItemsByOrder(Integer idOrder) {
		Optional<OrderEntity> orderEntity = orderRepository.findById(idOrder);		
		orderEntity.ifPresent(theOrderEntity -> lambdaFindItemsByIdOrder(theOrderEntity));		
		return itemsEntitiesFind;
	}
	
	public static void lambdaFindItemsByIdOrder(OrderEntity orderEntity) {
		itemsEntitiesFind = orderEntity.getItems();
	}

}
