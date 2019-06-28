package com.ProjetMaBanque;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import com.ProjetMaBanque.dao.ClientRepository;
import com.ProjetMaBanque.dao.CompteRepository;
import com.ProjetMaBanque.dao.OperationRepository;
import com.ProjetMaBanque.dao.RoleRepository;
import com.ProjetMaBanque.dao.User_RoleRepository;
import com.ProjetMaBanque.dao.UsersRepository;

import com.ProjetMaBanque.entity.Client;
import com.ProjetMaBanque.entity.Compte;
import com.ProjetMaBanque.entity.CompteCourant;
import com.ProjetMaBanque.entity.CompteEpargne;
import com.ProjetMaBanque.entity.Retrait;
import com.ProjetMaBanque.entity.Role;
import com.ProjetMaBanque.entity.User_Role;
import com.ProjetMaBanque.entity.Users;

import com.ProjetMaBanque.entity.Versement;
import com.ProjetMaBanque.metier.IbanqueMetier;

@SpringBootApplication
public class ProjetMaBanqueApplication implements CommandLineRunner {

	// Obtenir un logger
	static final Log log = LogFactory.getLog(ProjetMaBanqueApplication.class);

//------------------*************************************************************----------------------------
//----------------------------------Test de la couche DAO ---------------------------------------------------

	// @Autowired est basé sur SpringData
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	User_RoleRepository user_RoleRepository;

//------------------*************************************************************----------------------------
//----------------------------------Test de la couche Metier ---------------------------------------------------
	@Autowired
	private IbanqueMetier banqueMetier;

	/**
	 * Les DEUX versions sont identiques ->> elles servent à tester l'application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("Debut de l'application");
		SpringApplication.run(ProjetMaBanqueApplication.class, args);
	}

//------------------*************************************************************----------------------------
//----------------------------------Test de la couche DAO ---------------------------------------------------

	// Version SANS IMPLEMENTER UNE INTERFACE CommandLineRunner
	// ApplicationContext ctx -> Acceder aux objets fournit par Spring
	// ApplicationContext ctx =
	// SpringApplication.run(ProjetMaBanqueApplication.class, args);
	//// Demande a Sring de me donner un objet de type ClientRepository
	//// Avec l'objet clientRepository on pourra AJOUTER des clients
	// ClientRepository clientRepository = ctx.getBean(ClientRepository.class);
	// log.info("Objet de type ClientRepository : " + clientRepository);
	//// Permet d'inserer des Clients
	// clientRepository.save(new Client("Mersch","mersch.henri@icloud.com"));
	// log.info(" Insertion table Client : " + new
	// Client("Mersch","mersch.henri@icloud.com"));

	/**
	 * Version AVEC INTERFACE CommandLineRunner On creer un attribut private
	 * ClientRepository clientRepository; On l'injecte avec @Autowired On peut creer
	 * des Clients
	 * 
	 * On creer un attribut private CompteRepository CompteRepository; On l'injecte
	 * avec @Autowired On peut creer des Comptes
	 * 
	 * On creer un attribut private OperationRepository operationRepository;; On
	 * l'injecte avec @Autowired On peut creer des Operations
	 * 
	 * @SuppressWarnings("unused") Suppression des warning sur les variables non
	 * utilise
	 */
	@SuppressWarnings("unused")
	@Override
	public void run(String... args) throws Exception {

		// Test Creation de clients -> Client(String nom, String email)
		Client jean = clientRepository.save(new Client("Jean", "jean.jean@icloud.com"));
		log.info("Client creer : " + jean);

		Client bob = clientRepository.save(new Client("Bob", "bob.bob@icloud.com"));
		log.info("Client creer : " + bob);

		Client jack = clientRepository.save(new Client("Jack", "jack.jack@icloud.com"));
		log.info("Client creer : " + jack);

		Client boby = clientRepository.save(new Client("Boby", "boby.boby@icloud.com"));
		log.info("Client creer : " + boby);

		// Test Creation de compte ->
		// CompteCourant(String codeCompte, Date dateCreation, double solde, Client
		// client, double decouvert)
		// CompteEpargne(String codeCompte, Date dateCreation, double solde, Client
		// client, double taux)
		// Jean
		Compte compteCourant_Jean = compteRepository
				.save(new CompteCourant("compteCourant_Jean", new Date(), 10000, jean, 800));
		log.info("Compte 'compteCourant_Jean' creer : " + compteCourant_Jean);
		Compte compteEpargne_Jean = compteRepository
				.save(new CompteEpargne("compteEpargne_Jean", new Date(), 80000, jean, 1));
		log.info("Compte 'compteEpargne_Jean' creer : " + compteEpargne_Jean);

		// Bob
		Compte compteCourant_Bob = compteRepository
				.save(new CompteCourant("compteCourant_Bob", new Date(), 8000, bob, 900));
		log.info("Compte 'compteCourant_Bob' creer : " + compteCourant_Bob);
		Compte compteEpargne_Bob = compteRepository
				.save(new CompteEpargne("compteEpargne_Bob", new Date(), 10000, bob, 1));
		log.info("Compte 'compteEpargne_Bob' creer : " + compteEpargne_Bob);

		// Jack
		Compte compteCourant_Jack = compteRepository
				.save(new CompteCourant("compteCourant_Jack", new Date(), 200, jack, 100));
		log.info("Compte 'compteCourant_Jack' creer : " + compteCourant_Jack);

		// Boby
		Compte compteEpargne_Boby = compteRepository
				.save(new CompteEpargne("compteEpargne_Boby", new Date(), 300, boby, 3));
		log.info("Compte 'compteEpargne_Boby' creer : " + compteEpargne_Boby);

		// Test Operation
		// Retrait(Date dateOperation, double montant, Compte compte)
		// Versement(Date dateOperation, double montant, Compte compte)
		// Jean --> Versement + Retrait
		Versement versementCourant_Jean = operationRepository.save(new Versement(new Date(), 100, compteCourant_Jean));
		Retrait retraitCourant_Jean = operationRepository.save(new Retrait(new Date(), 200, compteCourant_Jean));
		Versement versementEpargne_Jean = operationRepository.save(new Versement(new Date(), 300, compteEpargne_Jean));
		Retrait retraitEpargne_Jean = operationRepository.save(new Retrait(new Date(), 400, compteEpargne_Jean));

		// Bob --> Versement + Retrait
		Versement versementCourant_Bob = operationRepository.save(new Versement(new Date(), 100, compteCourant_Bob));
		Retrait retraitCourant_Bob = operationRepository.save(new Retrait(new Date(), 200, compteCourant_Bob));
		Versement versementEpargne_Bob = operationRepository.save(new Versement(new Date(), 300, compteEpargne_Bob));
		Retrait retraitEpargne_Bob = operationRepository.save(new Retrait(new Date(), 400, compteEpargne_Bob));

		// Jack --> Versement + Retrait
		Versement versementCourant_Jack = operationRepository.save(new Versement(new Date(), 100, compteCourant_Jack));
		Retrait retraitCourant_Jack = operationRepository.save(new Retrait(new Date(), 200, compteCourant_Jack));

		// Boby --> Versement + Retrait
		Versement versementEpargne_Boby = operationRepository.save(new Versement(new Date(), 100, compteEpargne_Boby));
		Retrait retraitEpargne_Boby = operationRepository.save(new Retrait(new Date(), 200, compteEpargne_Boby));

		// Test Users
		// public Users(String username, String password, boolean active)

		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		Users userAdmin = usersRepository.save(new Users("admin", passwordEncoder.encode("admin"), true));
		Users userUser = usersRepository.save(new Users("user", passwordEncoder.encode("user"), true));

		// Test ROLE
		// public Role(String role)
		Role RoleAdmin = roleRepository.save(new Role("admin"));
		Role RoleUser = roleRepository.save(new Role("user"));

		// Insertion User_Role

		// Utilisateur admin a pour role Admin et User
		User_Role h_userRole1 = new User_Role();
		h_userRole1.setUsers(userAdmin);
		h_userRole1.setRole(RoleAdmin);
		user_RoleRepository.save(h_userRole1);

		User_Role h_userRole2 = new User_Role();
		h_userRole2.setUsers(userAdmin);
		h_userRole2.setRole(RoleUser);
		user_RoleRepository.save(h_userRole2);

		// L'utilisateur User a pour role User
		User_Role h_userRole3 = new User_Role();
		h_userRole3.setUsers(userUser);
		h_userRole3.setRole(RoleUser);
		user_RoleRepository.save(h_userRole3);

//------------------*************************************************************----------------------------
//----------------------------------Test de la couche Metier ------------------------------------------------

		// Test Versement -> banqueMetier.verser(String codeCompte, double montant);
		// Jean
		banqueMetier.verser("compteCourant_Jean", 111);
		banqueMetier.verser("compteEpargne_Jean", 222);
		// Bob
		banqueMetier.verser("compteCourant_Bob", 333);
		banqueMetier.verser("compteEpargne_Bob", 444);
		// Jack
		banqueMetier.verser("compteCourant_Jack", 555);
		// Boby
		banqueMetier.verser("compteEpargne_Boby", 666);

		// Test ConsulterCompte -> consulterCompte(String codeCpte)
		// Jean
		banqueMetier.consulterCompte("compteCourant_Jean");
		banqueMetier.consulterCompte("compteEpargne_Jean");
		// Bob
		banqueMetier.consulterCompte("compteCourant_Bob");
		banqueMetier.consulterCompte("compteEpargne_Bob");
		// Jack
		banqueMetier.consulterCompte("compteCourant_Jack");
		// Boby
		banqueMetier.consulterCompte("compteEpargne_Boby");

		// Test Retirer -> retirer(String codeCpte, double montant)
		// Jean
		banqueMetier.retirer("compteCourant_Jean", 666);
		banqueMetier.retirer("compteEpargne_Jean", 555);
		// bob
		banqueMetier.retirer("compteCourant_Bob", 444);
		banqueMetier.retirer("compteEpargne_Bob", 333);
		// Jack
		banqueMetier.retirer("compteCourant_Jack", 222);
		// Boby
		banqueMetier.retirer("compteEpargne_Boby", 100);

		// Test Virement -> virement(String codeCpte1, String codeCpte2, double montant)
		// Jean
		banqueMetier.virement("compteCourant_Jean", "compteEpargne_Jean", 100);
		banqueMetier.virement("compteCourant_Jean", "compteCourant_Bob", 100);
		banqueMetier.virement("compteCourant_Jean", "compteEpargne_Bob", 100);
		banqueMetier.virement("compteCourant_Jean", "compteCourant_Jack", 100);
		banqueMetier.virement("compteCourant_Jean", "compteEpargne_Boby", 100);

		banqueMetier.virement("compteEpargne_Jean", "compteCourant_Jean", 100);
		banqueMetier.virement("compteEpargne_Jean", "compteCourant_Bob", 100);
		banqueMetier.virement("compteEpargne_Jean", "compteEpargne_Bob", 100);
		banqueMetier.virement("compteEpargne_Jean", "compteCourant_Jack", 100);
		banqueMetier.virement("compteEpargne_Jean", "compteEpargne_Boby", 100);

		// Bob
		banqueMetier.virement("compteCourant_Bob", "compteEpargne_Jean", 100);
		banqueMetier.virement("compteCourant_Bob", "compteCourant_Jean", 100);
		banqueMetier.virement("compteCourant_Bob", "compteEpargne_Bob", 100);
		banqueMetier.virement("compteCourant_Bob", "compteCourant_Jack", 100);
		banqueMetier.virement("compteCourant_Bob", "compteEpargne_Boby", 100);

		banqueMetier.virement("compteEpargne_Bob", "compteCourant_Jean", 100);
		banqueMetier.virement("compteEpargne_Bob", "compteCourant_Bob", 100);
		banqueMetier.virement("compteEpargne_Bob", "compteCourant_Jean", 100);
		banqueMetier.virement("compteEpargne_Bob", "compteCourant_Jack", 100);
		banqueMetier.virement("compteEpargne_Bob", "compteEpargne_Boby", 100);

		// Jack
		banqueMetier.virement("compteCourant_Jack", "compteEpargne_Jean", 100);
		banqueMetier.virement("compteCourant_Jack", "compteCourant_Jean", 100);
		banqueMetier.virement("compteCourant_Jack", "compteEpargne_Bob", 100);
		banqueMetier.virement("compteCourant_Jack", "compteCourant_Bob", 100);
		banqueMetier.virement("compteCourant_Jack", "compteEpargne_Boby", 100);

		// Boby
		banqueMetier.virement("compteEpargne_Boby", "compteEpargne_Jean", 100);
		banqueMetier.virement("compteEpargne_Boby", "compteCourant_Jean", 100);
		banqueMetier.virement("compteEpargne_Boby", "compteEpargne_Bob", 100);
		banqueMetier.virement("compteEpargne_Boby", "compteCourant_Bob", 100);
		banqueMetier.virement("compteEpargne_Boby", "compteCourant_Jack", 100);

	}

}
