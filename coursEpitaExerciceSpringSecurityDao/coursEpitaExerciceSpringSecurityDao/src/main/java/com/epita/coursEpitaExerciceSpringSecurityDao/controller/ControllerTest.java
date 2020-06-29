package com.epita.coursEpitaExerciceSpringSecurityDao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epita.coursEpitaExerciceSpringSecurityDao.data.IDaoUser;

@RestController
@RequestMapping("/demo")
public class ControllerTest {

	@Autowired
	IDaoUser daoUser;
	
	@GetMapping("/security")
	public String getHello() {
		return "Hello Security !";
	}
}
