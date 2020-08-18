package fr.cda.librairie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cda.librairie.controller.config.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.cda.librairie.service.IUserService;

/**
 * La servlet accueil est appelée au lancement. Elle permet de s'inscrire ou de
 * se connecter à son compte.
 * 
 * @author Aurélien
 * @version 1.0 Servlet
 */
@Controller
@WebServlet(urlPatterns = { "/accueil" })
public class AccueilServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	IUserService userService;

	/**
	 * Permet l'affichage de la jsp d'accueil et ainsi de s'inscrire ou se connecter
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
	}

	/**
	 * cette méthode  récupère les informations de la jsp accueil et permet soit de
	 * se connecter soit de s'inscrire et donc créer un nouveau client.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			}
}
