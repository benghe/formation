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

@WebServlet(value = "/categorie-modifier")
public class CategorieModifierServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int categorieAModifierId=Integer.parseInt(req.getParameter("id"));
		
		ICategorieDao daoCategorie = new CategorieDaoSql();
		
		req.getSession().setAttribute("textModifyOrAdd", "Nouveau nom de la catégorie " + daoCategorie.findById(categorieAModifierId).getLibelle());
		req.getSession().setAttribute("categorieAModifier", daoCategorie.findById(categorieAModifierId));
		
		
		
//		resp.sendRedirect("categorie-ajout");
		
		

		this.getServletContext() //On récupère le contexte de Servlet
		.getRequestDispatcher("/WEB-INF/views/categorie-ajout.jsp") //On récupère le dispatcher
		.forward(req, resp); // On transfert avec request et response
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomDeLaCategorieAModifier=req.getParameter("addorModifyCategorieName");
		int categorieAModifierId=Integer.parseInt(req.getParameter("id"));
		
		Categorie categorieAEnvoyer=new Categorie(categorieAModifierId,nomDeLaCategorieAModifier);
		
		ICategorieDao daoCategorie = new CategorieDaoSql();
		req.setAttribute("categories", daoCategorie.save(categorieAEnvoyer));
		
		resp.sendRedirect("categories");
		
	}
	
	
	
	

}
