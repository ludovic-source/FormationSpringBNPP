package com.bnpp.shop.application.management;

import java.util.Optional;
import java.util.Set;


import com.bnpp.shop.domain.entity.ItemEntity;
import com.bnpp.shop.domain.entity.OrderEntity;

public interface OrderManagement {
	
	void create(OrderEntity order);
	
	Optional<OrderEntity> findEntity(Integer id);
	
	Set<OrderEntity> findEntityByCustomer(Integer idCustomer);
	
	void update(OrderEntity order);

	Set<ItemEntity> findItemsByOrder(Integer idOrder);
	
	OrderEntity createOrderByCustomer(OrderEntity order);

}
