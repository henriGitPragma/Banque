package com.ProjetMaBanque.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author toulouse - Un comtpe courant est un compte donc un heritage de Compte
 * @Entity sert a definir la table
 *         CompteCourant @DiscriminatorValue("CompteCourant") cela veut dire que
 *         si je cree un compte courant la colonne "TYPE_CPTE"(dans Compte) sera
 *         egale a "CompteCourant"
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("CompteCourant")
public class CompteCourant extends Compte {

	// Attributs
	private double decouvert;

	// Constructeur
	public CompteCourant() {
		super();
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Passage dans le constructeur Fille par default CompteCourant()");
	}

	// Creation du contructeur avec la class parent Compte
	// Source -> Generate Constructor Using Fields -> Select super constructeur to
	// invoke ->
	// Choisir le constructeur parent
	public CompteCourant(String codeCompte, Date dateCreation, double solde, Client client, double decouvert) {
		super(codeCompte, dateCreation, solde, client);
		this.decouvert = decouvert;
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Passage dans le constructeur Fille CompteCourant() avec 5 param "
				+ "+ appel du constructeur Mere 4 param  :  " + codeCompte + dateCreation + solde + client + decouvert);
	}

	// Getters et Setters
	public double getDecouvert() {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Recuperation du  GETTER getDecouvert() : " + decouvert);
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Positionement dans le SETTER setDecouvert avec param : " + decouvert);
		this.decouvert = decouvert;
	}

}
