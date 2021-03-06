package fr.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.dao.IProduitDao;
import fr.formation.dao.sql.ProduitDaoSql;
import fr.formation.model.Produit;

@WebServlet(value = "/produit-retrait")
public class ProduitSupprimerServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idProduitARetirer=Integer.parseInt(req.getParameter("id"));
		
		IProduitDao daoProduit=new ProduitDaoSql();
		req.setAttribute("produits", daoProduit.deleteById(idProduitARetirer));
		
		
		
//		ArrayList<Produit> listeProduitRecuperee = new ArrayList<Produit>();
//		
//		listeProduitRecuperee=(ArrayList<Produit>) this.getServletContext().getAttribute("listeProduitsInit");
//		
//		listeProduitRecuperee.remove(idProduitARetirer);
		
		resp.sendRedirect("produits");
	}

}
