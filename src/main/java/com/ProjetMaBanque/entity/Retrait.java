package com.ProjetMaBanque.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author toulouse - Un Retrait est une operation donc un heritage de Operation
 * @Entity sert a definir la table Retrait @DiscriminatorValue("Retrait") cela
 *         veut dire que si je cree une operation la colonne "TYPE_OPE"(dans
 *         Operation) sera egale a "Retrait"
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("Retrait")
public class Retrait extends Operation {

	// Constructeur
	public Retrait() {
		super();
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Passage dans le constructeur Fille par default Retrait()");
	}

	public Retrait(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Passage dans le constructeur Fille Retrait() avec 3 param "
				+ "+ appel du constructeur Mere 3 param : " + dateOperation + montant + compte);
	}
}
