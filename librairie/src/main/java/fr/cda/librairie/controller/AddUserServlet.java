package fr.cda.librairie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import fr.cda.librairie.controller.config.AbstractController;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;
import fr.cda.librairie.service.IUserService;
import lombok.extern.slf4j.Slf4j;



/**
 * Servlet implementation class AddUserServlet Fait suite aux informations
 * recueillies dans la jsp d'accueil et le fait de créer un nouveau compte
 * utilisateur.
 * 
 */
@Controller
@WebServlet("/addUser.do")
@Slf4j
public class AddUserServlet extends AbstractController {
	private static final long serialVersionUID = 1L;
	@Autowired
	IUserService iUserService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dateNaiss = req.getParameter("dateNaissance");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaiss);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		UtilisateurDto user = UtilisateurDto.builder().nom(req.getParameter("nom"))

				.dateConnection(new Date()).dateNaissance(date).prenom(req.getParameter("prenom"))
				.nomRue(req.getParameter("nomRue")).numeroPorte(Integer.parseInt(req.getParameter("numeroPorte")))
				.complementAdresse(req.getParameter("complementAdresse")).mail(req.getParameter("mail"))
				.password(req.getParameter("password")).pays(req.getParameter("pays")).ville(req.getParameter("ville"))
				.codePostal(req.getParameter("codePostal")).build();
		log.debug("ajout de nom: {} et prenom: {}",req.getParameter("nom"),req.getParameter("prenom"));

		try {
			iUserService.create(user);
		} catch (NomVilleIncorrect nomVilleIncorrect) {
			nomVilleIncorrect.printStackTrace();
		} catch (NomRueException nomRueException) {
			nomRueException.printStackTrace();
		} catch (NomPaysException e) {
			e.printStackTrace();
		} catch (RoleException roleException) {
			roleException.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}

}
