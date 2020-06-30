package com.bnpp.shop.exposition.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.shop.application.management.ItemManagement;
import com.bnpp.shop.domain.entity.ItemEntity;

@RestController
@RequestMapping("/shop/item")

public class ItemController {
	
	@Autowired
	ItemManagement itemManagement;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody ItemEntity item){
		if (item != null) {
			itemManagement.create(item);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/find/all")
	public List<ItemEntity> findAllItems() {
		return itemManagement.findByAllItems();
	}
	
	
}
