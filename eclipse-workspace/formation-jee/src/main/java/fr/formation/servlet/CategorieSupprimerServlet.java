package fr.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.dao.ICategorieDao;
import fr.formation.dao.IProduitDao;
import fr.formation.dao.sql.CategorieDaoSql;
import fr.formation.dao.sql.ProduitDaoSql;
import fr.formation.model.Produit;

@WebServlet(value = "/categorie-retrait")
public class CategorieSupprimerServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int categorieARetirerId=Integer.parseInt(req.getParameter("id"));
		
		ICategorieDao daoCategorie=new CategorieDaoSql();
		req.setAttribute("categories", daoCategorie.deleteById(categorieARetirerId));
		
		
		resp.sendRedirect("categories");
	}

}
