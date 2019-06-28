package com.ProjetMaBanque.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.logging.*;

/**
 * @author toulouse Classe ABSTRAITE car on cree soit des versements soit des
 *         retraits Le plus souvent les entitees sont des classes qui
 *         implementent l'interface Serializable
 * @Entity sert a definir la table Operation
 * @Inheritance car il y a de l'heritage
 *              (strategy=InheritanceType.SINGLE_TABLE)signifie qu'il va y avoir
 *              une table pour toute la hierarchie de class - Le plus souvent
 *              utilise - Probleme si il a trop de colonne vide sur le long
 *              terme
 * @DiscriminatorColumn(name="TYPE_OPE", discriminatorType=DiscriminatorType.STRING,
 *                                       length=20) en utilisant SINGLE TABLE
 *                                       une colonne va se creee dans la table
 *                                       Compte donc avec Discriminator on
 *                                       redefinie cette colonne ( nom , type,
 *                                       longeur) (par default( "dType",
 *                                       VARCHAR, 256)
 */
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OPE", discriminatorType = DiscriminatorType.STRING, length = 10)
public abstract class Operation implements Serializable {

	/**
	 * Attributs -
	 * 
	 * @Id pour specifier l'identifiant
	 * @GeneratedValue(strategy = GenerationType.AUTO) pour que les valeur soit
	 *                          genere AUTOMATIQUEMENT
	 * @ManyToOne car clef etrangere - Une operation appartient a un compte (voir
	 *            schema UML)(1..1) - Par default il nomme la clef etrangere
	 *            "client"
	 * @JoinColumn(name="CODE_COMPTE") permet de redefinir la clef etrangeres et de
	 *                                 donner un nom à la jointure
	 */
	@Id
	@GeneratedValue
	private Long numOperation;
	private Date dateOperation;
	private double montant;

	@ManyToOne
	@JoinColumn(name = "CODE_COMPTE")
	private Compte compte;

	// Constructeur
	public Operation() {
		super();
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Passage dans le constructeur Mere par default Operation()");
	}

	public Operation(Date dateOperation, double montant, Compte compte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Passage dans le constructeur Mere Operation() 3 param avec :  " + dateOperation + montant + compte);
	}

	// Getters et Setters
	public Long getNumOperation() {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Recuperation du  GETTER getNumOperation() : " + numOperation);
		return numOperation;
	}

	public void setNumOperation(Long numOperation) {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Positionement dans le SETTER setNumOperation avec param : " + numOperation);
		this.numOperation = numOperation;
	}

	public Date getDateOperation() {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Recuperation du  GETTER getDateOperation() : " + dateOperation);
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Positionement dans le SETTER setDateOperation avec param : " + dateOperation);
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Recuperation du  GETTER getMontant() : " + montant);
		return montant;
	}

	public void setMontant(double montant) {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Positionement dans le SETTER setMontant avec param : " + montant);
		this.montant = montant;
	}

	public Compte getCompte() {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Recuperation du  GETTER getCompte() : " + compte);
		return compte;
	}

	public void setCompte(Compte compte) {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Positionement dans le SETTER setCompte avec param : " + compte);
		this.compte = compte;
	}
}
