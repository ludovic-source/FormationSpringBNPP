package com.bnpp.shop.infrastructure.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnpp.shop.domain.entity.CustomerEntity;
import com.bnpp.shop.domain.entity.ItemEntity;
import com.bnpp.shop.domain.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

	Set<OrderEntity> findByCustomer(Optional<CustomerEntity> customer);

}
