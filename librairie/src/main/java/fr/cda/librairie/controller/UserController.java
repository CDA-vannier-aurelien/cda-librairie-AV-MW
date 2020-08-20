package fr.cda.librairie.controller;

import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;
import fr.cda.librairie.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "addUser.do", method = RequestMethod.POST)
    public ModelAndView ajoutUser(@RequestParam("dateNaissance")
                                  @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                  @RequestParam(value = "nom") String nom,
                                  @RequestParam(value = "prenom") String prenom,
                                  @RequestParam(value = "numeroPorte") int numPorte,
                                  @RequestParam(value = "complementAdresse") String complement,
                                  @RequestParam(value = "nomRue") String rue,
                                  @RequestParam(value = "mail") String mail,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value = "pays") String pays,
                                  @RequestParam(value = "ville") String ville,
                                  @RequestParam(value = "codePostal") String codePostal) {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        UtilisateurDto user = UtilisateurDto.builder().nom(nom)
                .dateConnection(new Date())
                .dateNaissance(date)
                .prenom(prenom)
                .nomRue(rue)
                .numeroPorte(numPorte)
                .complementAdresse(complement)
                .mail(mail)
                .password(password)
                .pays(pays).ville(ville)
                .codePostal(codePostal).build();
        log.debug("ajout de nom: {} et prenom: {}", nom, prenom);

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
        return model;
    }

    @RequestMapping(value = "connection", method = RequestMethod.POST)
    public ModelAndView connection(@RequestParam(value = "login") String login,
                                   @RequestParam(value = "password") String password,
                                   HttpSession httpSession) {
        ModelAndView model = new ModelAndView();
        UtilisateurDto utilisateurDto = UtilisateurDto.builder()
                .password(password)
                .mail(login).build();
        utilisateurDto = iUserService.conection(utilisateurDto);
        if (utilisateurDto == null) {
            HttpSession vSession = null;
            model.addObject("error", "Login/password incorrect");
            model.setViewName("index");
        } else {
            httpSession.setAttribute("user", utilisateurDto);
            model.addObject("user", utilisateurDto);
            model.setViewName("index");
        }
        return model;
    }

}
