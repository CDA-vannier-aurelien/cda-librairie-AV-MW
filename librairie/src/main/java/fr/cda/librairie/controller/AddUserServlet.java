package fr.cda.librairie.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cda.librairie.controller.config.AbstractServletController;
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
 */
@Controller
@WebServlet("/addUser.do")
public class AddUserServlet extends AbstractServletController {
	private static final long serialVersionUID = 1L;
@Autowired
IUserService iUserService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		int numeroPorte = Integer.parseInt(req.getParameter("numPorte"));
		String rue = req.getParameter("rue");
		String ville = req.getParameter("ville");
		int codePostal = Integer.parseInt(req.getParameter("codepostal"));
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		LocalDateTime datenais = LocalDateTime.parse(req.getParameter("datenais"));
		System.out.println(nom + password + login +password+rue+ville+numeroPorte);
		UtilisateurDto user = UtilisateurDto.builder()
				.dateNaissance(datenais)
				.nom(nom)
				.prenom(prenom)
				.login(login)
				.password(password)
				.nomRue(rue)
				.numeroPorte(numeroPorte)
				.nomVille(ville)
				.codePostal(codePostal)
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
