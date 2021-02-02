package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.dao.ICategorieDao;
import fr.formation.dao.IProduitDao;
import fr.formation.dao.jpa.CategorieDaoJpa;
import fr.formation.dao.sql.CategorieDaoSql;
import fr.formation.dao.sql.ProduitDaoSql;


@WebServlet(value = "/categories")
public class CategorieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ICategorieDao daoCategorie = new CategorieDaoJpa();
		
		
		req.setAttribute("categories", daoCategorie.findAll());
		
		
		
		this.getServletContext() //On récupère le contexte de Servlet
		.getRequestDispatcher("/WEB-INF/views/categories.jsp") //On récupère le dispatcher
		.forward(req, resp); // On transfert avec request et response
	
		
	
	}
	
	
	
	
	

}
