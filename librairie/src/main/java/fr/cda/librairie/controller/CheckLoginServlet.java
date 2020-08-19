package fr.cda.librairie.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cda.librairie.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cda.librairie.controller.config.AbstractController;
import fr.cda.librairie.dto.UtilisateurDto;

import lombok.extern.slf4j.Slf4j;

@WebServlet("/checkmail")
@Slf4j
public class CheckLoginServlet extends AbstractController {

    @Autowired
    IUserService iUserService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilisateurDto user = UtilisateurDto.builder().mail(request.getParameter("mail")).build();
        user = iUserService.checkMail(user);
        if (user == null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Adresse Mail valide.");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Adresse mail deja utilisé");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
