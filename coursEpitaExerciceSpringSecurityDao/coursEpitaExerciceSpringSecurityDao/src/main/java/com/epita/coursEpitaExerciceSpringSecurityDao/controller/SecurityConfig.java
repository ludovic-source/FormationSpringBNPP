package com.epita.coursEpitaExerciceSpringSecurityDao.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.passwordEncoder(passwordEncoder())
			.dataSource(dataSource)
			.usersByUsernameQuery(
						"select username, mot_passe, enabled from utilisateur where username=?")
			.authoritiesByUsernameQuery(
						"select username, name_role from utilisateur " + 
						"left join utilisateur_roles on utilisateur.id_user = utilisateur_roles.utilisateur_id_user " + 
						"left join role on role.id_role = utilisateur_roles.roles_id_role " + 
						"where username =?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Subtilité : Spring Security rajoute "ROLE_" davant le role "USER"
		//     en base de données, il doit donc y avoir "ROLE_USER" non "USER"
		http.httpBasic()		// user + password(authent faible)
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/demo/security/**").hasRole("USER")
			.and()
			.csrf().disable()
			.formLogin().disable();
	}
	
	@Bean
	   public PasswordEncoder passwordEncoder(){
	       PasswordEncoder encoder = new BCryptPasswordEncoder();
	       return encoder;
	   }
	
}
