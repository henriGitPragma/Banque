package com.ProjetMaBanque.metier;


import org.springframework.data.domain.Page;

import com.ProjetMaBanque.entity.Compte;
import com.ProjetMaBanque.entity.Operation;

public interface IbanqueMetier {

	//	final Log log = LogFactory.getLog(IbanqueService.class);
	//	log.info("");

	/**
	 * Premier besoin fonctionelle -> Consulter un compte avec parametre
	 * le numero du compte
	 */
	public Compte consulterCompte(String codeCpte);

	/**
	 * Deuxieme besoin  fonctionelle -> Effectuer un versement avec parametre
	 * le numero du compte et le montant
	 */
	public void verser(String codeCpte, double montant);

	/**
	 * Troisieme besoin fonctionelle -> Effectuer un retrait avec parametre
	 * le numero du compte et le montant
	 */
	public void retirer(String codeCpte, double montant);
	
	/**
	 * Quatrieme besoin fonctionelle -> Effectuer un virement avec parametre
	 * le premier compte et le deuxieme comtpe et un montant
	 */
	public void virement(String codeCpte1, String codeCpte2,double montant);
	
	/**
	 * Cinquieme besoin fonctionelle -> Consulter les operations d'un compte page par page
	 * Utilisation d'une INTERFACE, une liste fournit par SPRINGDATA Page<T> 
	 * mais on peut creer notre propre class PAGE dans la couche metier
	 * Il lui faut en param le numero du compte, le numero de la page et la taille
	 */
	public Page<Operation>listOperation(String codeCpte,int page, int size );

}
