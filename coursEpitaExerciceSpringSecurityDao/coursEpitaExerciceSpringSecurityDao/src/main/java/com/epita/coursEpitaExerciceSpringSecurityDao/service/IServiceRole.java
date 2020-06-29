package com.epita.coursEpitaExerciceSpringSecurityDao.service;

import java.util.Optional;

import com.epita.coursEpitaExerciceSpringSecurityDao.entite.Role;

public interface IServiceRole {
	
	void createRole(Role role);
	
	Optional<Role> getRole(Long id);

}
