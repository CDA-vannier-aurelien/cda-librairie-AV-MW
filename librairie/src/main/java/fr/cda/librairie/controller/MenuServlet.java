package fr.cda.librairie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import fr.cda.librairie.dto.UserDto;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu.do")
@Controller
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération de la session du client.
		HttpSession session = request.getSession();

		// test si la session a expirée --> renvoie à  la page d'acceuil pour log
		if (session.getAttribute("user") == null) {
			request.setAttribute("error", "session expirée veuillez vous reconnecter");
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);

		} else {

			UserDto u = ((UserDto) session.getAttribute("user"));

			request.setAttribute("user", u);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(request, response);
			// Cette Jsp est Ã  modifier en fonction du nom donnÃ©.
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
