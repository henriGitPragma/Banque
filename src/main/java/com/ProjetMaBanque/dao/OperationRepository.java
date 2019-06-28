package com.ProjetMaBanque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ProjetMaBanque.entity.Operation;

/**
 * Permet de gerer les Entites à l'aide de SpringData
 * Avec SpringData il suffit d'heriter d'une interface generique 
 * JpaRepository<Operation,Long> cela nous permet de gerer l'entitee "Operation" qui a ID de type "Long numOperation"
 *
 */
public interface OperationRepository  extends JpaRepository<Operation,Long>{
//	final Log log = LogFactory.getLog(OperationRepository.class);
//	log.info("");
	
	/**
	 * Methode qui permet de retourner les operations d'un compte
	 * que je voudrais consulter page par page
	 * On declare une 'Page' d'operations
	 * 
	 * Quand on retourne une Page il faut declarer un objet de type Pageable
	 * 
	 * Avec SpringData il faut donner la requete grace à @Query
	 * -> on veut O(objet operation) dans la table Operation ou o.compte.codeCompte 
	 * (dans la classe operation il y a l'attribut compte et dans la class
	 *  compte on s'interesse a l'attribut codeCompte )
	 *  
	 *  codeCompte represente le parametre 'x' mais il faut le specifier dans le methode avec @param
	 * 
	 * On veut la liste des operations mais trier par date -> order by o.dateOperation desc
	 */
	@Query("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
	public Page<Operation> listOperation(@Param ("x")String codeCpte, Pageable pageable);
}
