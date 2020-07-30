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
 * Servlet implementation class AddUserServlet
 */
@Controller
@WebServlet("/addUser.do")
public class AddUserServlet extends AbstractServletController {
	private static final long serialVersionUID = 1L;

	@Autowired
	IUserService userService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDto u;
		String error = "";

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");

		// Hashage du password
		String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());

//		// Check si login est dÃ©jÃ  pris, error first
//		if (userService.exists(login, password) == true) {
//			error = "Login déjà  utilisé !";
//			request.setAttribute("error", error);
//			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
//		} else {
		// Ok pour construction
		u = new UserDto(login, passwordHash, prenom, nom);

		// On ajoute en bdd et on construit la session
		try {
			userService.save(u);
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
		} catch (Exception e) {
			error = "Erreur lors de l'ajout";
			request.setAttribute("message", error);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
//		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/addUser.jsp").forward(request, response);
	}

}
