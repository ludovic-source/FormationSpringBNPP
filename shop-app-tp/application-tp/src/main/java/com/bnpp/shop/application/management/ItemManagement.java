package com.bnpp.shop.application.management;

import java.util.List;
import java.util.Optional;

import com.bnpp.shop.domain.entity.ItemEntity;


public interface ItemManagement {
	
	void create(ItemEntity item);
	
	Optional<ItemEntity> findItem(Integer id);
	
	void update(ItemEntity item);
	
	List<ItemEntity> findByAllItems();

}
