package fr.cda.librairie.controller;

import fr.cda.librairie.controller.config.AbstractServletController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * Permet la dÃ©connection de la session du client.
 * 
 * @author Aurélien
 * @version 1.0
 * 
 *          Servlet implementation class LogoutServlet
 */
@WebServlet("/deconnexion")
public class LogOutServlet extends AbstractServletController {
	private static final long serialVersionUID = 1L;

	public LogOutServlet() {
		super();
	}

	// Cloture de la session.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
	}

}
