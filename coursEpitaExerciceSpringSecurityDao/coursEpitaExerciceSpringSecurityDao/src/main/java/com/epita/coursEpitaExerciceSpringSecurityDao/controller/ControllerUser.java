package com.epita.coursEpitaExerciceSpringSecurityDao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.epita.coursEpitaExerciceSpringSecurityDao.entite.Utilisateur;
import com.epita.coursEpitaExerciceSpringSecurityDao.service.IServiceRole;
import com.epita.coursEpitaExerciceSpringSecurityDao.service.IServiceUser;

@RestController
@RequestMapping("/user")
public class ControllerUser {
	
	@Autowired
	IServiceUser serviceUser;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void createUser(@RequestBody Utilisateur user) {
		if (user!=null) {
			System.out.println("user : " + user.getId_user() + " -- username : " + user.getName_user());
			serviceUser.create(user);
		}
	}

}
