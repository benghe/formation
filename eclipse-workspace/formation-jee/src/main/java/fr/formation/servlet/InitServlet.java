//package fr.formation.servlet;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import fr.formation.model.Produit;
//
//@WebServlet(value="/init",loadOnStartup=1)
//public class InitServlet extends HttpServlet{
//
//	
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		ArrayList<Produit> maListedeProduitsInit = new ArrayList<Produit>();
//		
//		Produit parachute = new Produit("Parachute (APP)");
//		Produit voile = new Produit("Voile (APP)");
//		
//		maListedeProduitsInit.add(parachute);
//		maListedeProduitsInit.add(voile);
//		
//		this.getServletContext().setAttribute("listeProduitsInit", maListedeProduitsInit);
//		
//		resp.sendRedirect("produits");
//		
////		this.getServletContext() //On r�cup�re le contexte de Servlet
////		.getRequestDispatcher("/WEB-INF/views/init.jsp") //On r�cup�re le dispatcher
////		.forward(req, resp); // On transfert avec request et response
////		
//		
//	}
//
//	
//	
//	
//}
