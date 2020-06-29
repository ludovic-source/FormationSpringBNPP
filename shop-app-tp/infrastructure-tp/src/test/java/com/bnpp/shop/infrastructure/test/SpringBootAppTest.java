package com.bnpp.shop.infrastructure.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EntityScan("com.bnpp.shop.domain.entity")
//pour préciser où se trouvent les controller
@ComponentScan(basePackages = {"com.bnpp.shop"}, lazyInit = true )
//@EnableJpaRepositories(basePackages = "com.bnpp.shop.infrastructure.repository")
@EnableJpaRepositories
public class SpringBootAppTest {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppTest.class, args);
		System.out.println("Les tests des repository en infrastructure peuvent démarrer");

	}

}
