package fr.cda.librairie.controller;

import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;
import fr.cda.librairie.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "addUser.do", method = RequestMethod.POST)
    public ModelAndView ajoutUser(@RequestParam(value = "dateNaissance") String date,
                                  @RequestParam(value = "nom") String nom,
                                  @RequestParam(value = "prenom") String prenom,
                                  @RequestParam(value = "numeroPorte") int numPorte,
                                  @RequestParam(value = "complementAdresse") String complement,
                                  @RequestParam(value = "nomRue") String rue,
                                  @RequestParam(value = "mail") String mail,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value = "pays") String pays,
                                  @RequestParam(value = "ville") String ville,
                                  @RequestParam(value = "codePostal") String codePostal){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        Date dateNaiss = null;
        try {
            dateNaiss = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        UtilisateurDto user = UtilisateurDto.builder().nom(nom)
                .dateConnection(new Date())
                .dateNaissance(dateNaiss)
                .prenom(prenom)
                .nomRue(rue)
                .numeroPorte(numPorte)
                .complementAdresse(complement)
                .mail(mail)
                .password(password)
                .pays(pays).ville(ville)
                .codePostal(codePostal).build();
        log.debug("ajout de nom: {} et prenom: {}",nom,prenom);

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

}
