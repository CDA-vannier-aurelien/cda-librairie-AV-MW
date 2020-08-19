package fr.cda.librairie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cda.librairie.controller.config.AbstractController;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.service.ILivreService;
import fr.cda.librairie.utils.Constantes;

/**
 * Servlet implementation class listUtilisateur Permet de renvoyer les
 * informations nécessaires à l'affichage des différents livres disponibles
 * dans la librairie.
 */
@WebServlet("/listeLivre")
public class ListLivreServlet extends AbstractController {
	private static final long serialVersionUID = 1L;
	@Autowired
	ILivreService livreService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pageParam = request.getParameter("page");
		int pageEnCours = 1;

		if (pageParam != null) {
			try {
				pageEnCours = Integer.parseInt(pageParam);
				if (pageEnCours < 1) {
					pageEnCours = 1;
				}
			} catch (NumberFormatException e) {
				System.err.println("attention : " + e.getMessage());
			}
		}

		List<LivreDto> listLivre = livreService.getAllLivre(pageEnCours);
		request.setAttribute("liste", listLivre);
		request.setAttribute("nbElementsParPage", Constantes.ELEMENTS_PAGE);
		request.setAttribute("count", this.livreService.count());
		request.setAttribute("pageEnCours", pageEnCours);
		request.getRequestDispatcher("WEB-INF/jsp/product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
