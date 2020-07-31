package fr.cda.librairie.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.exeption.NomPaysException;
import fr.cda.librairie.exeption.NomRueExecption;
import fr.cda.librairie.exeption.NomVilleIncorrect;
import fr.cda.librairie.exeption.RoleExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
		} catch (NomRueExecption nomRueExecption) {
			nomRueExecption.printStackTrace();
		} catch (NomPaysException e) {
			e.printStackTrace();
		} catch (RoleExecption roleExecption) {
			roleExecption.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
