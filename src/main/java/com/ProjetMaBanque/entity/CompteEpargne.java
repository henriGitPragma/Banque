package com.ProjetMaBanque.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author toulouse - Un comtpe Epargne est un compte donc un heritage de Compte
 * @Entity sert a definir la table
 *         CompteEpargne @DiscriminatorValue("CompteEpargne") cela veut dire que
 *         si je cree un compte epargne la colonne "TYPE_CPTE"(dans Compte) sera
 *         egale a "CompteEpargne"
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("CompteEpargne")
public class CompteEpargne extends Compte {

	// Attributs
	private double taux;

	// Constructeur
	public CompteEpargne() {
		super();
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Passage dans le constructeur Fille par default CompteEpargne()");
	}

	// Creation du contructeur avec la class parent Compte
	// Source -> Generate Constructor Using Fields -> Select super constructeur to
	// invoke ->
	// Choisir le constructeur parent
	public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, double taux) {
		super(codeCompte, dateCreation, solde, client);
		this.taux = taux;
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Passage dans le constructeur fille CompteCourant() avec  5 param "
				+ "+ appel du constructeur Mere 4 param :  " + codeCompte + dateCreation + solde + client + taux);
	}

	// Gettters et Setters
	public double getTaux() {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Recuperation du  GETTER getTaux() : " + taux);
		return taux;
	}

	public void setTaux(double taux) {
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Positionement dans le SETTER setTaux avec param : " + taux);
		this.taux = taux;
	}

}
