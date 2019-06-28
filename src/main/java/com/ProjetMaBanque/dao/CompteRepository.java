package com.ProjetMaBanque.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetMaBanque.entity.Compte;


/**
 * Permet de gerer les Entites à l'aide de SpringData
 * Avec SpringData il suffit d'heriter d'une interface generique 
 * JpaRepository<Compte,String> cela nous permet de gerer l'entitee "Compte" qui a ID de type "String codeCompte"
 *
 */
public interface CompteRepository  extends JpaRepository<Compte,String>{

//final Log log = LogFactory.getLog(CompteRepository.class);
//log.info("");
	
}
