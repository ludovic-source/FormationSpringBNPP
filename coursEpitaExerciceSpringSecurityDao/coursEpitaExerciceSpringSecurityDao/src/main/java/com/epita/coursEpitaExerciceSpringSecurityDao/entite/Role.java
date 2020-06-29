package com.epita.coursEpitaExerciceSpringSecurityDao.entite;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_role;	
	private String name_role;
	
	//@ManyToMany(mappedBy = "roles")
	@ManyToMany
	private Set<Utilisateur> users;

	// Accesseurs
	public Long getId_role() {
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}

	public String getName_role() {
		return name_role;
	}

	public void setName_role(String name_role) {
		this.name_role = name_role;
	}

	public Set<Utilisateur> getUsers() {
		return users;
	}

	public void setUsers(Set<Utilisateur> users) {
		this.users = users;
	}

	
	
}
