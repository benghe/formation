package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.dao.IProduitDao;
import fr.formation.dao.sql.ProduitDaoSql;


@WebServlet(value = "/produits" , loadOnStartup=3)
public class ProduitServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		ArrayList<Produit> maListedeProduits = new ArrayList<Produit>();
//		
//		Produit voiture = new Produit("Voiture");
//		Produit camion = new Produit("Camion");
//		Produit avion = new Produit("Avion");
//		Produit bateau = new Produit("Bateau");
//		
//		maListedeProduits.add(voiture);
//		maListedeProduits.add(camion);
//		maListedeProduits.add(avion);
//		maListedeProduits.add(bateau);
//	
//		
//		req.setAttribute("mesProduits", maListedeProduits);
		
		IProduitDao daoProduit=new ProduitDaoSql();
		
		
		req.setAttribute("produits", daoProduit.findAll());
		
		
		
		this.getServletContext() //On r�cup�re le contexte de Servlet
		.getRequestDispatcher("/WEB-INF/views/produits.jsp") //On r�cup�re le dispatcher
		.forward(req, resp); // On transfert avec request et response
	
		
	
	}
	
	
	
	
	

}
