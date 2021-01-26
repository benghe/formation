package fr.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Produit;

@WebServlet(value = "/panier-ajout")
public class PanierAjoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Récupération de l'id du produit
		int idProduitAAjouter=Integer.parseInt(req.getParameter("id"));		
		
	
		//Récupération de la liste des produits
		ArrayList<Produit> listeRecuperee = new ArrayList<Produit>();
		
		listeRecuperee=(ArrayList<Produit>) this.getServletContext().getAttribute("listeProduitsInit");
		
		//Récupération du produit correspondant avec l'id
		Produit produitAjoutePanier=listeRecuperee.get(idProduitAAjouter);
		
		//Récupération de la liste des produits du panier
		ArrayList<Produit> panierRecupere = new ArrayList<Produit>();
		panierRecupere=(ArrayList<Produit>) req.getSession().getAttribute("panier");
		
		//Ajout du produit au panier
		if(panierRecupere!=null) {
			panierRecupere.add(produitAjoutePanier);
		}else {
			ArrayList<Produit> panier = new ArrayList<Produit>();
			panier.add(produitAjoutePanier);
			req.getSession().setAttribute("panier", panier);
		}
		
		//Redirection vers la page panier
		resp.sendRedirect("panier");
		
		
		
	}
	
	

}
