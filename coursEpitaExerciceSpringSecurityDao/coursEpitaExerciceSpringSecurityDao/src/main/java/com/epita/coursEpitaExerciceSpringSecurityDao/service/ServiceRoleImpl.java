package com.epita.coursEpitaExerciceSpringSecurityDao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epita.coursEpitaExerciceSpringSecurityDao.data.IDaoRole;
import com.epita.coursEpitaExerciceSpringSecurityDao.entite.Role;

@Service
public class ServiceRoleImpl implements IServiceRole{

	@Autowired
	IDaoRole daoRole;
	
	@Override
	public void createRole(Role role) {
		daoRole.save(role);		
	}

	@Override
	public Optional<Role> getRole(Long id) {
		return daoRole.findById(id);
	}

	
	
}
