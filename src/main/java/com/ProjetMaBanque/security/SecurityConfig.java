package com.ProjetMaBanque.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



/**
 * 
 * @author toulouse
 * Heritage de -> WebSecurityConfigurerAdapter
 * @Configuration  -> Gerer la securite
 * @EnableWebSecurity -> Gerer la securite
 * 
 * 
 * 
 * http.formLogin() -> je demande a sroing de passer
 *  par une authentifiacation base sur un formulauire
 * 
 * 
 * -> Permet de ne pas avoir le cryptage de password
 *  -> exception -> There is no PasswordEncoder mapped for the id "null"
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		//Creation de user et de role sans SGBD
		//Creation d'un user admin avec deux roles
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}admin").roles("ADMIN","USER");
//		
		
		//Creation d'un utilisateur avec un role
		auth.inMemoryAuthentication().withUser("user")
		.password("{noop}user").roles("USER");
		
		
	

		/**
		 *  On a au prealable cree les tables user/role/userRole
		 * Permet d'adpater l'application pour definir les roles de chacun 
		 * 
		 * dataSource(dataSource) -> On lui dit de chercher les utilisateurs dans la SGBD de l'application
		 * authoritiesByUsernameQuery(query) -> On ecrit la recquete que doit 
		 * effectuer springSecurity pour trouver l'utilisateurs
		 * 
		 * Requete -> principal / credentials -> nom donner par default par SpringSecurty
		 * SpringSecurity recuperer username saisi par l'utilisateur, il se connecte a la base de donner pour savoir si l'utilisateur existe,
		 * s'il existe il va comperer le mot de passe si il est valide.
		 * authoritiesByUsernameQuery ->  il va regarder les roles affectes -> where username=? car SprigSecurity il connait que le username
		 * 
		 * rolePrefix() -> on indique SpringSecurity quand il recuperer un role il lui ajoute un prefixe
		 * 
		 * 
		 *
		 */
//		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//        .usersByUsernameQuery("select username , password ,'TRUE' from Users where username=?")
//        .authoritiesByUsernameQuery("select u.username ,r.role from Users u "
//        		+ "inner join User_Role ur on(u.id_users=ur.username) "
//        		+ "inner join Role r on(ur.role=r.id_role) where u.username=?")
//		.passwordEncoder(passwordEncoder);
			
	}
	
	
	//Formulaire de connection par default et perso	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		
		//Personnalisation du formulaire
		http.formLogin().loginPage("/login");
		
//		//Formulaire par defaut 
		//http.formLogin();
		//http.authorizeRequests().antMatchers("/operation", "/consulterCompte").hasAnyAuthority("ROLE_USER");
		//http.authorizeRequests().antMatchers("/saveOperation").access("hasRole('ROLE_ADMIN')");
		
//		.anyRequest().fullyAuthenticated().and().formLogin().and().logout();
		//Permet de personnaliser la page quand un user n'est pas autorise a faire une action
		//on le redirige vers la page 403
		http.exceptionHandling().accessDeniedPage("/403");
	}
	
	
}
