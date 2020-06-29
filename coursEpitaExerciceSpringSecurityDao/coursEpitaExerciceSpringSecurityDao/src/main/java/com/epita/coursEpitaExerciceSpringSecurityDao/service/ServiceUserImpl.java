package com.epita.coursEpitaExerciceSpringSecurityDao.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epita.coursEpitaExerciceSpringSecurityDao.data.IDaoUser;
import com.epita.coursEpitaExerciceSpringSecurityDao.entite.Role;
import com.epita.coursEpitaExerciceSpringSecurityDao.entite.Utilisateur;

@Service
@Transactional
public class ServiceUserImpl implements IServiceUser {

	@Autowired
	IDaoUser daoUser;
		
	@Autowired
	IServiceRole serviceRole;
	
	@Override
	public void create(Utilisateur user) {
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			System.out.println("je passe ici");
			serviceRole.createRole(role);
		}
		
		String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));
		
		daoUser.save(user);
		
	}
	/*
	@Override
	public User getUser(String username) {
		return daoUser.findByUsername(username);
	}
	*/
}
