package fr.formation;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.formation.dao.ICategorieDao;
import fr.formation.dao.ICommentaireDao;
import fr.formation.dao.IFournisseurDao;
import fr.formation.dao.IPaiementDao;
import fr.formation.dao.jpa.CategorieDaoJpa;
import fr.formation.dao.jpa.CommentaireDaoJpa;
import fr.formation.dao.jpa.FournisseurDaoJpa;
import fr.formation.dao.jpa.PaiementDaoJpa;
import fr.formation.model.Categorie;
import fr.formation.model.Commentaire;
import fr.formation.model.Fournisseur;
import fr.formation.model.Paiement;
import fr.formation.model.Produit;

public class ApplicationHibernate {

	public static void main(String[] args) {
//		EntityManagerFactory emf= Persistence.createEntityManagerFactory("EShopUnit");
//		EntityManager em =emf.createEntityManager();
		
		
		//Ajouter une nouvelle catégorie et lister toutes les catégories
		
//		Categorie nouvelCat=new Categorie();
//		
//		nouvelCat.setLibelle("tshirts moulants");
//		
//		EntityTransaction tx = em.getTransaction();
		
//		tx.begin();
//		em.persist(nouvelCat);
//		tx.commit();
		
//		List <Categorie> categories = em.createQuery("select c from Categorie c",Categorie.class).getResultList();
		
		
//		ICategorieDao daoCategorie = new CategorieDaoJpa();
//		
//		List <Categorie> categories = daoCategorie.findAll();
//		 for(Categorie c:categories) {
//			 System.out.println(c.getLibelle());
//		 }
		
		 
		 
		 //Lister les fournisseurs 
		 
		 
		IFournisseurDao daoFournisseur = new FournisseurDaoJpa();
//		List <Fournisseur> fournisseurs = daoFournisseur.findAll();
//		 for(Fournisseur f:fournisseurs) {
//			 System.out.println(f.getNom());
//			 System.out.println("- LISTE DE SES PRODUITS -");
//			 for(Produit p:f.getProduits()) {
//				 System.out.println("- " + p.getLibelle());
//			 }
//		 }
		 System.out.println(daoFournisseur.findById(4).getNom());
		 
		 System.out.println(daoFournisseur.count());
		 
		 System.out.println(daoFournisseur.findAllFetchingProduits());
//		 
//		 daoFournisseur.deleteById(3);
		 
//		 for (Fournisseur f:daoFournisseur.findAll()) {
//			 System.out.println(f.getNom());
//		 }
//		
//		 
//		 IPaiementDao daoPaiement = new PaiementDaoJpa();
//		 List<Paiement> paiements = daoPaiement.findAll();
//		 for(Paiement p:paiements) {
//			 System.out.println(p.getType());
//		 }
//		 
//		 ICommentaireDao daoCommentaire = new CommentaireDaoJpa();
//		 List<Commentaire> commentaires = daoCommentaire.findAll();
//		 for(Commentaire co:commentaires) {
//			 System.out.println(co.getTexte());
//		 }
		
		
		
		
//		Fournisseur fournisseur = new Fournisseur();
//		
//		fournisseur.setNom("F1");
//		fournisseur.setPrenom("PF1");
//		fournisseur.setMail("email@gg.com");
//		fournisseur.setTelephone("0300000000");
//		fournisseur.setAdresse("12, rue des champs, 59000, LILLE");
//		fournisseur.setSiret("12345678912345");
//		
//		daoFournisseur.add(fournisseur);
		
//		//On a besoin d'une transaction lorsque l'on applique un changement (donc pas pour le find)
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
////		em.getTransaction().begin(); //Autre manière de faire
//		
//		em.persist(fournisseur);
//		tx.commit(); //On applique les changements SQL (l'insert se fait)
////		tx.rollback(); //On annule les changement SQL (l'insert ne se fera pas)
//		
////		em.getTransaction().commit(); //Autre manière de faire
		
		
		
		
		
		
		
//		List <Fournisseur> fournisseurs = em.createQuery("select f from Fournisseur f",Fournisseur.class).getResultList();
//		
//		 for(Fournisseur f:fournisseurs) {
//			 System.out.println(f.getNom());
//		 }
	}

}
