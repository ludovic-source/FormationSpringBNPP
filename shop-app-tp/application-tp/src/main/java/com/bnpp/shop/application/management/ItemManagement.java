package com.bnpp.shop.application.management;

import java.util.Optional;
import java.util.Set;

import com.bnpp.shop.domain.entity.ItemEntity;
import com.bnpp.shop.domain.entity.OrderEntity;

public interface ItemManagement {
	
	void create(ItemEntity item);
	
	Optional<ItemEntity> findItem(Integer id);
	
	void update(ItemEntity item);

}
