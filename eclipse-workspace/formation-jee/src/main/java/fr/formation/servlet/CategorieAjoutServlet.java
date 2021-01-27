package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.dao.ICategorieDao;
import fr.formation.dao.sql.CategorieDaoSql;
import fr.formation.model.Categorie;

@WebServlet(value = "/categorie-ajout")
public class CategorieAjoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Ajout de cette ligne pour vider si ajout
		Categorie categorieVide = new Categorie();
		
		req.getSession().setAttribute("categorieAModifier", categorieVide);
		req.getSession().setAttribute("textModifyOrAdd", "Nom de la cat�gorie � ajouter");
		
		this.getServletContext() //On r�cup�re le contexte de Servlet
		.getRequestDispatcher("/WEB-INF/views/categorie-ajout.jsp") //On r�cup�re le dispatcher
		.forward(req, resp); // On transfert avec request et response
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nomDeLaCategorie=req.getParameter("addorModifyCategorieName");	
		
		
		Categorie nouvelleCategorie = new Categorie(nomDeLaCategorie);

		
		ICategorieDao daoCategorie = new CategorieDaoSql();
		req.setAttribute("categories", daoCategorie.add(nouvelleCategorie));
		

		
		resp.sendRedirect("categories");
		
	}
	
	

}
