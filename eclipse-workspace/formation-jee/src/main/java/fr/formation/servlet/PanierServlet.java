package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/panier")
public class PanierServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.getServletContext() //On récupère le contexte de Servlet
		.getRequestDispatcher("/WEB-INF/views/panier.jsp") //On récupère le dispatcher
		.forward(req, resp); // On transfert avec request et response
		
	}

}
