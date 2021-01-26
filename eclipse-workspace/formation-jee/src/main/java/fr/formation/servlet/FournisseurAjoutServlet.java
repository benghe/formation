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

@WebServlet(value = "/fournisseur-ajout")
public class FournisseurAjoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		this.getServletContext() //On récupère le contexte de Servlet
		.getRequestDispatcher("/WEB-INF/views/fournisseur-ajout.jsp") //On récupère le dispatcher
		.forward(req, resp); // On transfert avec request et response
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nomDuFournisseur=req.getParameter("addFournisseurName");		
		
		if(nomDuFournisseur.equals("")) {
			
			this.getServletContext() //On récupère le contexte de Servlet
			.getRequestDispatcher("/WEB-INF/views/fournisseur-ajout.jsp") //On récupère le dispatcher
			.forward(req, resp); // On transfert avec request et response
		}
		
		Fournisseur nouveau = new Fournisseur(nomDuFournisseur);

		
		ArrayList<Fournisseur> ListeAugmentee = new ArrayList<Fournisseur>();

		
		ListeAugmentee=(ArrayList<Fournisseur>) this.getServletContext().getAttribute("listeFournisseursInit");
		
		ListeAugmentee.add(nouveau);
		
		
		//Pas utile car on récupère une référence à listeProduitsInit
		//this.getServletContext().setAttribute("listeProduitsInit", ListeAugmentee);
		
		resp.sendRedirect("fournisseurs");
		
	}

}
