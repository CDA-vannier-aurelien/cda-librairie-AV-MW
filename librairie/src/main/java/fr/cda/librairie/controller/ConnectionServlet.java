package fr.cda.librairie.controller;

import fr.cda.librairie.controller.config.AbstractController;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.Constantes;


import java.io.IOException;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;


@WebServlet("/connection")

public class ConnectionServlet extends AbstractController implements Servlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	IUserService iUser;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

HttpSession vSession = request.getSession();
		
		if(vSession.getAttribute(Constantes.USER_EN_COURS) != null) {
			this.getServletContext().getRequestDispatcher("/menu.do").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
		}
	}


//Méthode faite par Loreen la bosse
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		HttpSession vSession = request.getSession();
		
		UtilisateurDto vUser = UtilisateurDto.builder().mail(login).password(password).build();
		vUser= iUser.conection(vUser);
		if(vUser==null) {
			request.setAttribute("error", "Login/password incorrect");
			request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp").forward(request, response);
		}else {
				

			if(vSession.getAttribute(Constantes.USER_EN_COURS) != null) {
				this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
				

			} else  {
				request.setAttribute("infos", "connexion réussie");
				
				vSession.setAttribute(Constantes.USER_EN_COURS, UtilisateurDto.builder().mail(login).dateConnection(new Date()).build());
				
				this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
			} 
		}
		
	
	}

}
