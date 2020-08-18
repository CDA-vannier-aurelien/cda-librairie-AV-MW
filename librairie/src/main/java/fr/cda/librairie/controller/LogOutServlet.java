package fr.cda.librairie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cda.librairie.controller.config.AbstractController;

/**
 * 
 * Permet la déconnection de la session du client.
 * 
 * @author Aurélien
 * @version 1.0
 * 
 *          Servlet implementation class LogoutServlet
 */
@WebServlet("/deconnexion")
public class LogOutServlet extends AbstractController {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

}
