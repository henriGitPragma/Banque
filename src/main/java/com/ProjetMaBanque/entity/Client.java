package com.ProjetMaBanque.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author toulouse
 * @Entity sert a definir la table Client Le plus souvent les entitees sont des
 *         classes qui implementent l'interface Serializable
 */
@SuppressWarnings("serial")
@Entity
public class Client implements Serializable {

	/**
	 * Attributs -
	 * 
	 * @Id pour specifier l'identifiant
	 * @GeneratedValue(strategy = GenerationType.AUTO) pour que les valeur soit
	 *                          genere AUTOMATIQUEMENT
	 * @OneToMany un client peut avoir plusieurs compte(1..*)(voir schema UML)
	 *            (mappedBy ="client") car dans la classe Compte un Client est
	 *            specifiant comme client fetch=FetchType.LAZY par defautl ca gere
	 *            les associations entre les classes
	 */
	@Id
	@GeneratedValue(generator="Seq_Client")
	private Long ID_code;
	
	
	private String nom;
	
	private String email;
	
	
	
	
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;

	// Constructeur
	public Client() {
		super();
		final Log log = LogFactory.getLog(Client.class);
		log.info("Passage dans le constructeur par default Client()");
	}

	public Client(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
		final Log log = LogFactory.getLog(Client.class);
		log.info("Passage dans le constructeur Client(String nom, String email)");
	}

	// Getters et Setters
	public Long getCode() {
		final Log log = LogFactory.getLog(Client.class);
		log.info("Recuperation du  GETTER getCode() : " + ID_code);
		return ID_code;
	}

	public void setCode(Long code) {
		final Log log = LogFactory.getLog(Client.class);
		log.info("Positionement dans le SETTER setCode avec param : " + code);
		this.ID_code = code;
	}

	public String getNom() {
		final Log log = LogFactory.getLog(Client.class);
		log.info("Recuperation du  GETTER getNom() : " + nom);
		return nom;
	}

	public void setNom(String nom) {
		final Log log = LogFactory.getLog(Client.class);
		log.info("Positionement dans le SETTER setNom avec param : " + nom);
		this.nom = nom;
	}

	public String getEmail() {
		final Log log = LogFactory.getLog(Client.class);
		log.info("Recuperation du  GETTER getEmail() : " + email);
		return email;
	}

	public void setEmail(String email) {
		final Log log = LogFactory.getLog(Client.class);
		log.info("Positionement dans le SETTER setEmail avec param : " + email);
		this.email = email;
	}

	public Collection<Compte> getComptes() {
		final Log log = LogFactory.getLog(Client.class);
		log.info("Recuperation du  GETTER Collection<Compte> getComptes() : " + comptes);
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		final Log log = LogFactory.getLog(Client.class);
		log.info("Positionement dans le SETTER" + " setComptes(Collection<Compte> comptes) avec param : " + comptes);
		this.comptes = comptes;
	}

}
