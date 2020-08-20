package fr.cda.librairie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;



/**
 * Servlet permettant d'appeler les différentes choix offerts à 'lutilisateur une fois connecté à son compte.
 */
@WebServlet("/menu.do")
@Controller
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}