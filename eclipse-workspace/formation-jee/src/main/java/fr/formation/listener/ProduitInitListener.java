package fr.formation.listener;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

@WebListener
public class ProduitInitListener implements ServletContextListener{

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {

//		ArrayList<Fournisseur> listeFournisseurRecuperee = new ArrayList<Fournisseur>();
//		listeFournisseurRecuperee=(ArrayList<Fournisseur>) this.getServletContext().getAttribute("listeFournisseursInit");
		
		Fournisseur auchan = new Fournisseur("Auchan");
		
		
		ArrayList<Produit> maListedeProduitsInit = new ArrayList<Produit>();
		
		
		Produit parachute = new Produit("Parachute (APP listener)",auchan);
		Produit voile = new Produit("Voile (APP listener)", auchan);
		
		maListedeProduitsInit.add(parachute);
		maListedeProduitsInit.add(voile);
		
		sce.getServletContext().setAttribute("listeProduitsInit", maListedeProduitsInit);
	}
	
}
