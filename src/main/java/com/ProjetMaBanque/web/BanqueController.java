package com.ProjetMaBanque.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ProjetMaBanque.entity.Compte;
import com.ProjetMaBanque.entity.Operation;
import com.ProjetMaBanque.metier.IbanqueMetier;
/**
 * Le controller a besoin de la couche metier 
 */
@Controller
public class BanqueController {
	
	@Autowired
	private IbanqueMetier banqueMetier;
	
	/**
	 * On cree une methode index qui permet de retourner une vue par default
	 *@RequestMapping("/operations") permet a acceder a cette methode 
	 *Quand je vais taper http://localhost:8080/operations 
	 *j'aurai une vue comptes.html -> Creation de la page comptes.html
	 *
	 */
	@RequestMapping("/operation")
	public String index() {
		return "compte";
		
	}
	
	/**
	 * 1. Appel a la couche metier pour consulter  le compte
	 * 2. Je stocke cette objet dans le model ( et je l'appel compte)
	 * @param model
	 * @param codeCompte
	 * @return
	 * @RequestParam (Attribuer un nom au parametre que l'on vouldrait recuperer)
	 * 
	 * Quand on consulte un compte, la methode compte peut générer une exception
	 * 4. Dans le model je stocke l'exception parce que le message
	 * 	  de l'exception je vais l'afficher dans le vue 
	 * 
	 * 5. Je stocke dans un model l'attribut 'codeCpte'
	 * 
	 * 6. je vais recuperer la Page d'operation pour afficher la liste des operations
	 * 		je vais afficher que 4  dernieres operations
	 * 		On stocke cette liste d'operation dans le moddele
	 * 		getContent() -> permet de retourner la lsite d'operation
	 * 
	 * 7. Creation de la pagination
	 * -> defaultValue="5" on affiche 5 ligne par page 
	 * 
	 */
	@RequestMapping("/consulterCompte")
	public String consulter(Model model,String codeCpte,
			@RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="5")int size) { 
		// 5.
		model.addAttribute("codeCompte", codeCpte);
		try {
			// 1.
			Compte compte = banqueMetier.consulterCompte(codeCpte);
			// 6.
			Page<Operation>pageOperations = 
					banqueMetier.listOperation(codeCpte, page, size);
			model.addAttribute("listOperations", pageOperations.getContent());
			// 7. 
			//Recuperation de la liste de page
			//Total des pages -> getTotalPages()
			int[] pages=new int [pageOperations.getTotalPages()];
			model.addAttribute("pages", pages);
			
			
			// 2.
			model.addAttribute("compte", compte);
			
		} catch (Exception e) {
			// 4.
			model.addAttribute("Exception", e);
		}
		return "compte";
	}
	
	/**
	 * Listener de la partie Operation sur le compte
	 * @param model
	 * @param typeOperation
	 * @param codeCompte
	 * @param montant
	 * @param codeCompte2
	 * @return
	 */
	@RequestMapping(value="/saveOperation", method=RequestMethod.POST)
	public String saveOperation(Model model, String typeOperation,
			String codeCompte, double montant, String codeCompte2) {

		try {
			if(typeOperation.equals("VERS")) {
				banqueMetier.verser(codeCompte, montant);
			}
			else if(typeOperation.equals("RET")) {
				banqueMetier.retirer(codeCompte, montant);
			}
			if(typeOperation.equals("VIR")) {
				banqueMetier.virement(codeCompte, codeCompte2, montant);
			}
		} catch (Exception e) {
			//On stocke l'exception dans le model
			model.addAttribute("error", e);
			//Message d'erreur afficher dans URL -> "&error="+e.getMessage();
			return "redirect:/consulterCompte?codeCpte=" + codeCompte + "&error="+e.getMessage();
		}
		//je redirige vers le methode 'consulterCompte' 
		//mais je dois renvoyer le code parce que c'est
		//une operation qui concerne le meme compte
		return "redirect:/consulterCompte?codeCpte=" + codeCompte;
	}
	
			//Gere la page par default - On redirige par defaut sur operation
			@RequestMapping(value="/")
			public String home() {
				return "redirect:/operation";
			}
}
