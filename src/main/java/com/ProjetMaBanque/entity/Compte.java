package com.ProjetMaBanque.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author toulouse - Classe ABSTRAITE car on cree soit un compte courant soit
 *         un compte epargne - Le plus souvent les entitees sont des classes qui
 *         implementent l'interface Serializable
 * @Entity sert a definir la table Compte
 * @Inheritance car il y a de l'heritage
 *              (strategy=InheritanceType.SINGLE_TABLE)signifie qu'il va y avoir
 *              une table pour toute la hierarchie de class - Le plus souvent
 *              utilise Probleme si il a trop de colonne vide sur le long terme
 * @DiscriminatorColumn(name="TYPE_CPTE", discriminatorType=DiscriminatorType.STRING,
 *                                        length=20) en utilisant SINGLE TABLE
 *                                        une colonne va se creee dans la table
 *                                        Compte donc avec Discriminator on
 *                                        redefinie cette colonne ( nom , type,
 *                                        longeur) - Par default( "dType",
 *                                        VARCHAR, 256)
 */
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Compte implements Serializable {

	/**
	 * Attributs
	 * 
	 * @Id pour specifier l'identifiant Pas de @GeneratedValue car l'ID est de type
	 *     String
	 * @ManyToOne car clef etrangere - Un compte appartient a un client (voir schema
	 *            UML)(1..1) - Par default il nomme la clef etrangere "client"
	 * @JoinColumn(name="CODE_CLIENT") permet de redefinir la clef etrangeres et de
	 *                                 donner un nom à la jointure
	 * @OneToMany un compte peut subir plusieurs operations (voir schema UML)(1..*)
	 *            (mappedBy ="compte") car dans la classe Compte un Client est
	 *            specifiant comme client fetch=FetchType.LAZY par defautl ca gere
	 *            les associations entre les classes
	 */
	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;

	@ManyToOne
	@JoinColumn(name = "CODE_CLIENT")
	private Client client;

	@OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
	private Collection<Operation> operations;

	
	
	
	
	
	// Constructeur
	public Compte() {
		super();
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Passage dans le constructeur Mere par default Compte()");

	}

	public Compte(String codeCompte, Date dateCreation, double solde, Client client) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Passage dans le constructeur Mere Compte() 4 param : " + codeCompte + dateCreation + solde + client);
	}

	// Getters et Setters
	public String getCodeCompte() {
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Recuperation du  GETTER getCodeCompte() : " + codeCompte);
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Positionement dans le SETTER setCodeCompte avec param : " + codeCompte);
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Recuperation du  GETTER getDateCreation() : " + dateCreation);
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Positionement dans le SETTER setDateCreation avec param : " + dateCreation);
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Recuperation du  GETTER getSolde() : " + solde);
		return solde;
	}

	public void setSolde(double solde) {
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Positionement dans le SETTER setSolde avec param : " + solde);
		this.solde = solde;
	}

	public Client getClient() {
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Recuperation du  GETTER getClient() : " + client);
		return client;
	}

	public void setClient(Client client) {
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Positionement dans le SETTER setClient avec param : " + client);
		this.client = client;
	}

	public Collection<Operation> getOperations() {
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Recuperation du" + " GETTER Collection<Operation> getOperations() : " + operations);
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		final Log log = LogFactory.getLog(Compte.class);
		log.info("Positionement dans le SETTER" + " setOperations(Collection<Operation> operations) avec param : "
				+ operations);
		this.operations = operations;
	}

}
