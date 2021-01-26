package fr.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Produit;

@WebServlet(value = "/panier-retrait")
public class PanierRetraitServlet extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idProduitARetirer=Integer.parseInt(req.getParameter("id"));
		
		ArrayList<Produit> panierRecupere = new ArrayList<Produit>();
		panierRecupere=(ArrayList<Produit>) req.getSession().getAttribute("panier");
		
		panierRecupere.remove(idProduitARetirer);
		
		resp.sendRedirect("panier");
	}
	

}
