package com.bnpp.shop.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnpp.shop.domain.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{	

}
