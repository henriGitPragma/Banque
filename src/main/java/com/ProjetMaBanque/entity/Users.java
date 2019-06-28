package com.ProjetMaBanque.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@SuppressWarnings("serial")
@Entity
public class Users implements Serializable {

	
	//Attributs
	@Id
	@GeneratedValue(generator="Seq_Users")
	private Long id_users;
	
	private String username;
	
	private String password;

	private boolean enabled;
	
	

	//Constructeurs
	public Users() {
		super();
	}

	public Users(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled=enabled;
		final Log log = LogFactory.getLog(Users.class);
		log.info("Passage dans le constructeur Users (2param)" + username + password );
	}

	//Getters / Setters
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public Long getId_users() {
		final Log log = LogFactory.getLog(Users.class);
		log.info("Passage dans GETTER getId_users" + id_users );
		return id_users;
	}

	public void setId_users(Long id_users) {
		this.id_users = id_users;
		final Log log = LogFactory.getLog(Users.class);
		log.info("Passage dans SETTER setId_users" + id_users );
	}

	public String getUsername() {
		final Log log = LogFactory.getLog(Users.class);
		log.info("Passage dans GETTER getUsername" + username );
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		final Log log = LogFactory.getLog(Users.class);
		log.info("Passage dans SETTER setUsername" + username );
	}

	public String getPassword() {
		final Log log = LogFactory.getLog(Users.class);
		log.info("Passage dans GETTER getPassword" + password );
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		final Log log = LogFactory.getLog(Users.class);
		log.info("Passage dans SETTER setPassword" + password );
	}
	
	
	
	
	
	
}
