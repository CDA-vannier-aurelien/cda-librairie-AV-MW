package fr.cda.librairie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cda.librairie.controller.config.AbstractController;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.Constantes;
import lombok.extern.slf4j.Slf4j;


/**
 * Servlet implementation class DashBoardServlet
 */
@WebServlet("/dashboard")
@Slf4j
public class DashBoardServlet extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IUserService userService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
log.debug("list d'utilisateur");
		
		String pageParam = request.getParameter("page");
		int pageEnCours = 1;
		
	
		
		if(pageParam != null) {
			try {
				pageEnCours = Integer.parseInt(pageParam);
				if(pageEnCours < 1) {
					pageEnCours = 1;
				}
			} catch (NumberFormatException e) {
				System.err.println("attention : " + e.getMessage());
			}
		}
		
		List<UtilisateurDto> vUser= this.userService.getAll(pageEnCours);
		
		request.setAttribute("utilisateur", vUser);
		request.setAttribute("nbElementsParPage", Constantes.ELEMENTS_PAR_PAGE);
		request.setAttribute("count", this.userService.count());
		request.setAttribute("pageEnCours", pageEnCours);
		
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
