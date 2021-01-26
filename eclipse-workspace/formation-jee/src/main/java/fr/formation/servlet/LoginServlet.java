package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/login" , loadOnStartup=1)
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String errorMessage="";

		if(req.getParameter("error")!=null) {
			errorMessage="Le login ou le password est incorrect!!";
		}
		
		req.setAttribute("errorMessage", errorMessage);
		
		this.getServletContext() //On récupère le contexte de Servlet
		.getRequestDispatcher("/WEB-INF/views/login.jsp") //On récupère le dispatcher
		.forward(req, resp); // On transfert avec request et response
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String monUsername=req.getParameter("username");
		String monPassword=req.getParameter("password");
		
		
		if(monUsername.equals("toto") && monPassword.equals("123")) {
			
			req.getSession().setAttribute("usrSession", monUsername);
			resp.sendRedirect("home");
		} else {
			resp.sendRedirect("login?error=true");
		}
	}
	
	

}
