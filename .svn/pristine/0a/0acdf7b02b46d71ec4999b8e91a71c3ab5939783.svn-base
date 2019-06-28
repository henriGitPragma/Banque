package com.ProjetMaBanque.metier;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ProjetMaBanque.dao.CompteRepository;
import com.ProjetMaBanque.dao.OperationRepository;
import com.ProjetMaBanque.entity.Compte;
import com.ProjetMaBanque.entity.CompteCourant;
import com.ProjetMaBanque.entity.Operation;
import com.ProjetMaBanque.entity.Retrait;
import com.ProjetMaBanque.entity.Versement;

/**
 * Toutes les methodes  de la couches metier
 * @author toulouse
 * @Service permet a Spring d'instancier cette class au demarrage Utiliser
 *          seulement pour les objets de la couche metier
 * @Transactional Permet a spring de gerer les Transactions
 *                (org.springframework.transaction.annotation.Transactional)
 *                toutes les methodes sont transactionnelles.
 *@Autowired gere l'injection des dependances, 
 *on demande a spring de gerer l'implementation de cette interface
 */
@Service
@Transactional
public class BanqueMetierImpl implements IbanqueMetier {

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;

	// logger
	final Log log = LogFactory.getLog(BanqueMetierImpl.class);

	/**
	 *  Optional<Compte> optional  c'est un conteneur qui contient l'objet compte
	 *  NE PAS OUBLIER LE GET POUR RECUPRER LA VALEUR
	 * 
	 *  1. Pour consulter un compte on a besoin de la couche DAO avec compteRepository
	 *  2. On teste si la valeur est pas null
	 *  3. Generer une exception quand le compte est introuvable
	 * 		On peut aussi creer notre propre exception (heritage de la class Exception)
	 */
	@Override
	public Compte consulterCompte(String codeCompte) {
		log.info("Acces methode consulterCompte(String codeCpte) : " + codeCompte);
		// 1.
		 Optional<Compte> optional = compteRepository.findById(codeCompte);
		 Compte compte = optional.get();
		log.info("Optional Transformer : " + compte );
		// 2. 3.
		 if(compte==null) throw new RuntimeException("Compte Introuvable");
		// 4.
		return  compte ;
	}

	/**
	 * 1. Il faut consulter le compte
	 * 2. Il faut creer un versement
	 * 3. Il faut enregistrer ce versement -> private OperationRepository operationRepository;
	 * 4. Mettre a jour le solde
	 */
	@Override
	public void verser(String codeCpte, double montant) {
		log.info("Acces methode verser(String codeCpte, double montant) : " + codeCpte +  montant);
		// 1.
		Compte compte =consulterCompte(codeCpte);
		log.info("compte retourner :  " +compte);
		// 2.
		Versement versement = new Versement(new Date(), montant, compte);
		// 3.
		operationRepository.save(versement);
		// 4.
		compte.setSolde(compte.getSolde()+montant);
		compteRepository.save(compte);

	}
	/**
	 * 1. Il faut consulter le compte
	 * 2. Connaitre quel type de compte (Epargne ou Courant) a cause du decouvert null sur epargne
	 * 	  Regarder si le solde est suffisant
	 * 3. Il faut creer un retrait
	 * 4. Il faut enregistrer ce retrait -> private OperationRepository operationRepository;
	 * 5. Mettre a jour le solde
	 */
	@Override
	public void retirer(String codeCpte, double montant) {
		log.info("Acces methode retirer(String codeCpte, double montant) : " + codeCpte +  montant);
		// 1.
		Compte compte =consulterCompte(codeCpte);
		// 2.
		double facilitesCaisse=0;
		if (compte instanceof CompteCourant) 
			facilitesCaisse = ((CompteCourant) compte).getDecouvert();
		if(compte.getSolde() + facilitesCaisse < montant)
			throw new RuntimeException("Solde Insuffisant");
		// 3.
		Retrait retrait = new Retrait(new Date(), montant, compte);
		// 4.
		operationRepository.save(retrait);
		// 5.
		compte.setSolde(compte.getSolde() - montant);
		compteRepository.save(compte);
	}
	/**
	 * 1. On retire d'un compte
	 * 2. On verse sur un autre
	 * 3. On gere l'exception si on fait un virement vers le meme compte
	 */
	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		log.info("Acces methode "
				+ "virement(String codeCpte1, String codeCpte2, double montant)"
				+ codeCpte1 + codeCpte2 + montant );
		// 3.
		if(codeCpte1.equals(codeCpte2))
			throw new RuntimeException("Impossible d'effectuer un virement sur le meme compte");
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
	}
	/**
	 * On return la methode qui est dans OperationRepository qui retourne la page trie
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		log.info("Acces methode listOperation(String codeCpte, int page, int size) :" + codeCpte + page + size);
		log.info("On retourne la liste d'operation par page et trier :  "
		+ operationRepository.listOperation(codeCpte, new PageRequest(page, size)));
		return operationRepository.listOperation(codeCpte, new PageRequest(page, size));
	}

}
