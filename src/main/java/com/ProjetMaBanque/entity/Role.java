package com.ProjetMaBanque.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
@Entity
public class Role implements Serializable {

	//Attributs
	@Id
	@GeneratedValue(generator="Seq_Role")
	private Long id_role;
	
	private String role;

	
	//Constructeur
	public Role() {
		super();
	}

	public Role(String role) {
		super();
		this.role = role;
		final Log log = LogFactory.getLog(Role.class);
		log.info("Passage dans le constructeur Users (1param)" + role );
	}

	
	//Getters /Setters
	public Long getId_role() {
		final Log log = LogFactory.getLog(Role.class);
		log.info("Passage dans GETTER  getId_role" + id_role);
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
		final Log log = LogFactory.getLog(Role.class);
		log.info("Passage dans SETTER " +  id_role );
	}

	public String getRole() {
		final Log log = LogFactory.getLog(Role.class);
		log.info("Passage dans GETTER" + role );
		return role;
	}

	public void setRole(String role) {
		this.role = role;
		final Log log = LogFactory.getLog(Role.class);
		log.info("Passage dans  SETTER " +  role );
	}
	
	
	
}
