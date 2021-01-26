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

@WebServlet(value = "/fournisseur-retrait")
public class FournisseurSupprimerServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idFournisseurARetirer=Integer.parseInt(req.getParameter("id"));
		
		ArrayList<Fournisseur> listeFournisseurRecuperee = new ArrayList<Fournisseur>();
		
		listeFournisseurRecuperee=(ArrayList<Fournisseur>) this.getServletContext().getAttribute("listeFournisseursInit");
		
		listeFournisseurRecuperee.remove(idFournisseurARetirer);
		
		resp.sendRedirect("fournisseurs");
	}

}
