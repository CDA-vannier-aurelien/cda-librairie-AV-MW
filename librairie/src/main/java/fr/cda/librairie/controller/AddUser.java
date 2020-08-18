package fr.cda.librairie.controller;

import java.io.IOException;
<<<<<<< HEAD:librairie/src/main/java/fr/cda/librairie/controller/AddUser.java
import java.time.LocalDateTime;
=======
import java.text.ParseException;
import java.text.SimpleDateFormat;
>>>>>>> Dev:librairie/src/main/java/fr/cda/librairie/controller/AddUserServlet.java
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

/**
<<<<<<< HEAD:librairie/src/main/java/fr/cda/librairie/controller/AddUser.java
 * Servlet implementation class AddUserServlet
=======
 * Servlet implementation class AddUserServlet Fait suite aux informations
 * recueillies dans la jsp d'accueil et le fait de créer un nouveau compte
 * utilisateur.
 * 
>>>>>>> Dev:librairie/src/main/java/fr/cda/librairie/controller/AddUserServlet.java
 */
@Controller
@WebServlet("/addUser.do")
public class AddUser extends AbstractController {
	private static final long serialVersionUID = 1L;
	@Autowired
	IUserService iUserService;

	@Override
<<<<<<< HEAD:librairie/src/main/java/fr/cda/librairie/controller/AddUser.java
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
=======
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

>>>>>>> Dev:librairie/src/main/java/fr/cda/librairie/controller/AddUserServlet.java
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

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(req, resp);
	}

<<<<<<< HEAD:librairie/src/main/java/fr/cda/librairie/controller/AddUser.java
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
=======
>>>>>>> Dev:librairie/src/main/java/fr/cda/librairie/controller/AddUserServlet.java
}
