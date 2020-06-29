package com.bnpp.shop.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnpp.shop.domain.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

	CustomerEntity findByName(String name);

}
