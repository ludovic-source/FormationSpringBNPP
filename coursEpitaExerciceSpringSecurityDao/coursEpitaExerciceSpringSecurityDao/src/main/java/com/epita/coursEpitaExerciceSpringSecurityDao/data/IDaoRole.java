package com.epita.coursEpitaExerciceSpringSecurityDao.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epita.coursEpitaExerciceSpringSecurityDao.entite.Role;

public interface IDaoRole extends JpaRepository<Role, Long>{
	
	

}
