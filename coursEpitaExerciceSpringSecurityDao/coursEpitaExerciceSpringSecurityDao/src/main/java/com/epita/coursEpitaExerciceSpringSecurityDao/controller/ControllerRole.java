package com.epita.coursEpitaExerciceSpringSecurityDao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.epita.coursEpitaExerciceSpringSecurityDao.entite.Role;
import com.epita.coursEpitaExerciceSpringSecurityDao.service.IServiceRole;

@RestController
@RequestMapping("/role")
public class ControllerRole {

	@Autowired
	IServiceRole serviceRole;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void createRole(@RequestBody Role role) {
		System.out.println("name_role : " + role.getName_role());
		serviceRole.createRole(role);
	}
}
