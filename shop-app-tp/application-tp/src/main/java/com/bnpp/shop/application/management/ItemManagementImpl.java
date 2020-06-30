package com.bnpp.shop.application.management;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.shop.domain.entity.ItemEntity;
import com.bnpp.shop.infrastructure.repository.ItemRepository;

@Service
@Transactional
public class ItemManagementImpl implements ItemManagement {

	@Autowired
	ItemRepository itemRepository;
	
	private static final Log logger = LogFactory.getLog(ItemManagementImpl.class);
	
	public void create(ItemEntity item) {
		itemRepository.save(item);
		logger.info("create item");
		
	}	

	public void update(ItemEntity item) {
		itemRepository.save(item);
		logger.info("update item");
		
	}

	public Optional<ItemEntity> findItem(Integer id) {
		logger.info("find item by id");
		return itemRepository.findById(id);
	}

	@Override
	public List<ItemEntity> findByAllItems() {
		logger.info("find all items");
		return itemRepository.findAll();
	}

}
