package com.bnpp.shop.exposition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.bnpp.shop.infrastructure.repository")
@EnableJpaRepositories(basePackages = "com.bnpp.shop")
@EntityScan("com.bnpp.shop.domain.entity")
//pour préciser où se trouvent les controller
@ComponentScan(basePackages = {"com.bnpp.shop"} )
public class MainShopApp {

	public static void main(String[] args) {
		SpringApplication.run(MainShopApp.class, args);
		System.out.println("ça marche !");

	}

}
