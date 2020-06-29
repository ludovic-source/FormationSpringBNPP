package com.epita.coursEpitaExerciceSpringSecurityDao.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epita.coursEpitaExerciceSpringSecurityDao.entite.Utilisateur;

public interface IDaoUser extends JpaRepository<Utilisateur, Long>{

	/*
	User findByUsername(String username);
	*/

}
