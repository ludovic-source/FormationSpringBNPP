package com.bnpp.shop.exposition.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.shop.application.management.OrderManagement;
import com.bnpp.shop.domain.entity.ItemEntity;
import com.bnpp.shop.domain.entity.OrderEntity;

@RestController
@RequestMapping("/shop/order")
public class OrderController {
	
	@Autowired
	OrderManagement orderManagement;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody OrderEntity order){
		if (order != null) {
			orderManagement.create(order);
		}
	}
	
	// rechercher un order à partir de l'id du customer
	@GetMapping("/find/order/{id}")
	public Set<OrderEntity> findOrdersByCustomer(@PathVariable("id") Integer idCustomer) {
		if (idCustomer != null && idCustomer != 0) {
			return orderManagement.findEntityByCustomer(idCustomer);
		}
		return null;
	}
	
	// rechercher les items à partir d'un id order
	@GetMapping("/find/items/{id}")
	public Set<ItemEntity> findItemsByOrder(@PathVariable("id") Integer idOrder) {
		if (idOrder != null && idOrder != 0) {
			return orderManagement.findItemsByOrder(idOrder);
		}
		return null;
	}
	

}
