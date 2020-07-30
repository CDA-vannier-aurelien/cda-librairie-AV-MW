package fr.cda.librairie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.cda.librairie.dto.UserDto;
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.BCrypt;

/**
 * La servlet accueil est appelée au lancement. Elle permet de s'inscrire ou de
 * se connecter à son compte.
 * 
 * @author Aurélien
 * @version 1.0 Servlet
 */
@Controller
@WebServlet(urlPatterns = { "/accueil" })
public class AccueilServlet extends AbstractServletController {
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
	 * cette méthode récupère les informations de la jsp accueil et permet soit de
	 * se connecter soit de s'inscrire et donc créer un nouveau client.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récup infos + création session + association
		UserDto u = null;

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		// Check si les champs ne sont pas null
		if (login == null || password == null || login.length() == 0 || password.length() == 0) {
			request.setAttribute("error", "login et password obligatoires");
		} else {

//			 Check si Login est présent en bdd ,error first
			if (!userService.exists(login, password) == true) {
				request.setAttribute("error", "Login/password invalide");
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			} else {
				u = userService.findByLogin(login);
			}

//			 Login ok, Check si le password correspond au login ,error first
			if (!BCrypt.checkpw(password, u.getPassword())) {
				request.setAttribute("error", "Login/password invalide");
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("client", u);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/clientAjoute.jsp").forward(request,
						response);
			}
		}
	}

}
