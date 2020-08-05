package fr.cda.librairie.controller;

import fr.cda.librairie.controller.config.AbstractServletController;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "testServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends AbstractServletController {
    @Autowired
    IUserService iUserService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilisateurDto user = UtilisateurDto.builder().login(request.getParameter("login")).build();

        user = iUserService.checkLogin(user);
        if (user == null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Nom d'utilisateur valide");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Nom d'utilisateur deja utilisé");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/testAjax.jsp").forward(request, response);

    }
}
