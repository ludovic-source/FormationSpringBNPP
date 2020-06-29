package com.epita.coursEpitaExerciceSpringSecurityDao.entite;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	private String name_user;
	private String username;
	private String mot_passe;
	private boolean enabled;
	
	@ManyToMany
	//@JoinTable(name="utilisateur_roles",
	//	joinColumns = @JoinColumn(name= "username"),		
	//	inverseJoinColumns = @JoinColumn(name= "id_role"))
    //@JoinTable(name="utilisateur_roles",
	//    joinColumns = @JoinColumn(name="usernanme"),
	//    inverseJoinColumns = @JoinColumn(name="name_role"))
	private Set<Role> roles;

	// Accesseurs
	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return mot_passe;
	}

	public void setPassword(String mot_passe) {
		this.mot_passe = mot_passe;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
