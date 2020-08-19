package fr.cda.librairie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cda.librairie.controller.config.AbstractController;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet("/panier")
public class PanierServlet extends AbstractController {
	private static final long serialVersionUID = 1L;
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/panier.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		doGet(request, response);
	}

}