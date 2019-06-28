package com.ProjetMaBanque.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author toulouse - Un Versement est une operation donc un heritage de
 *         Operation
 * @Entity sert a definir la table Versement @DiscriminatorValue("Versement")
 *         cela veut dire que si je cree une operation la colonne
 *         "TYPE_OPE"(dans Operation) sera egale a "Versement"
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("Versement")
public class Versement extends Operation {

	// Constructeur
	public Versement() {
		super();
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Passage dans le constructeur Fille par default Versement()");
	}

	public Versement(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
		final Log log = LogFactory.getLog(Operation.class);
		log.info("Passage dans le constructeur Fille Versement() avec 3 param "
				+ "+ appel du constructeur Mere 3 param : " + dateOperation + montant + compte);
	}
}
