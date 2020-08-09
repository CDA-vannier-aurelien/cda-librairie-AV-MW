package fr.cda.librairie.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cda.librairie.controller.config.AbstractController;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.cda.librairie.service.IUserService;

/**
 * Servlet implementation class AddUserServlet
 * Fait suite aux informations recueillies dans la jsp d'accueil et le fait de créer un nouveau compte utilisateur.
 * 
 */
@Controller
@WebServlet("/addUser.do")
public class AddUserServlet extends AbstractController {
	private static final long serialVersionUID = 1L;
@Autowired
IUserService iUserService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UtilisateurDto user = UtilisateurDto.builder().dateNaissance(new Date())
				.nom("benseddik")
				.prenom("Fethi")
				.login("fethi")
				.password("fethi")
				.nomRue("rue du nord prolongee")
				.numeroPorte(63)
				.nomVille("Anzin")
				.nomPays("France")
				.isActivated(true)
				.dateConnection(new Date())
				.labelRole("Libraire").build();
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

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
