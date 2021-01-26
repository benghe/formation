package fr.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

@WebServlet(value = "/produit-ajout")
public class ProduitAjoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		this.getServletContext() //On r�cup�re le contexte de Servlet
		.getRequestDispatcher("/WEB-INF/views/produit-ajout.jsp") //On r�cup�re le dispatcher
		.forward(req, resp); // On transfert avec request et response
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nomDuProduit=req.getParameter("addProductName");	
		String nomDuFournisseur=req.getParameter("fournisseurName");
		
		//R�cup�rer le vrai fournisseur avec ce nom dans la liste des fournisseurs??
		Fournisseur nouveauFournisseur = new Fournisseur(nomDuFournisseur);
		
		
		Produit nouveauProduit = new Produit(nomDuProduit,nouveauFournisseur);
		
		ArrayList<Produit> ListeAugmentee = new ArrayList<Produit>();

		
		ListeAugmentee=(ArrayList<Produit>) this.getServletContext().getAttribute("listeProduitsInit");
		
		ListeAugmentee.add(nouveauProduit);
		
		
		//Pas utile car on r�cup�re une r�f�rence � listeProduitsInit
		//this.getServletContext().setAttribute("listeProduitsInit", ListeAugmentee);
		
		resp.sendRedirect("produits");
		
	}
	
	

}
