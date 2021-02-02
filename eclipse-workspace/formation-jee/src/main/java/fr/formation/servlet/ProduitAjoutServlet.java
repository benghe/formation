package fr.formation.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.dao.IProduitDao;
import fr.formation.dao.jpa.ProduitDaoJpa;
import fr.formation.dao.sql.ProduitDaoSql;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

@WebServlet(value = "/produit-ajout")
public class ProduitAjoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		this.getServletContext() //On récupère le contexte de Servlet
		.getRequestDispatcher("/WEB-INF/views/produit-ajout.jsp") //On récupère le dispatcher
		.forward(req, resp); // On transfert avec request et response
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nomDuProduit=req.getParameter("addProductName");	
		String nomDuFournisseur=req.getParameter("fournisseurName");
		int prixDuProduit= Integer.parseInt(req.getParameter("addProductPrice"));
		int stockDuProduit=Integer.parseInt(req.getParameter("addProductStock"));
		
		
		
		//Récupérer le vrai fournisseur avec ce nom dans la liste des fournisseurs??
//		Fournisseur nouveauFournisseur = new Fournisseur(nomDuFournisseur);
		Fournisseur nouveauFournisseur = new Fournisseur();
		nouveauFournisseur.setId(1);
		
		
		Produit nouveauProduit = new Produit(nomDuProduit,prixDuProduit, stockDuProduit,nouveauFournisseur);
		
		

		
		
//		ArrayList<Produit> ListeAugmentee = new ArrayList<Produit>();
//
//		
//		ListeAugmentee=(ArrayList<Produit>) this.getServletContext().getAttribute("listeProduitsInit");
//		
//		ListeAugmentee.add(nouveauProduit);
		
		
		
		
		IProduitDao daoProduit=new ProduitDaoJpa();
		req.setAttribute("produits", daoProduit.add(nouveauProduit));
		
		
		//Pas utile car on récupère une référence à listeProduitsInit
		//this.getServletContext().setAttribute("listeProduitsInit", ListeAugmentee);
		
		resp.sendRedirect("produits");
		
	}
	
	

}
