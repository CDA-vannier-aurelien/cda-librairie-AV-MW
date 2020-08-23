package fr.cda.librairie.controller;

import com.google.gson.Gson;
import fr.cda.librairie.dto.CommandeDto;
import fr.cda.librairie.dto.CommandeLineDto;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.service.ICommandeLineService;
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private ICommandeLineService iCommandeLineService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ModelAndView modelAndView;

    @RequestMapping(value = "addUser.do", method = RequestMethod.POST)
    public ModelAndView ajoutUser(@RequestParam("dateNaissance") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                  @RequestParam(value = "nom") String nom, @RequestParam(value = "prenom") String prenom,
                                  @RequestParam(value = "numeroPorte") int numPorte,
                                  @RequestParam(value = "complementAdresse") String complement, @RequestParam(value = "nomRue") String rue,
                                  @RequestParam(value = "mail") String mail, @RequestParam(value = "password") String password,
                                  @RequestParam(value = "pays") String pays, @RequestParam(value = "ville") String ville,
                                  @RequestParam(value = "codePostal") int codePostal) {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        UtilisateurDto user = UtilisateurDto.builder().nom(nom).dateConnection(new Date()).dateNaissance(date)
                .prenom(prenom).nomRue(rue).numeroPorte(numPorte).complementAdresse(complement).mail(mail)
                .password(password).pays(pays).ville(ville).codePostal(codePostal).build();
        log.debug("ajout de nom: {} et prenom: {}", nom, prenom);

        iUserService.create(user);

        return model;
    }

    @RequestMapping(value = "connection", method = RequestMethod.POST)
    public ModelAndView connection(@RequestParam(value = "login") String login,
                                   @RequestParam(value = "password") String password, HttpSession httpSession) {
        ModelAndView model = new ModelAndView();
        UtilisateurDto utilisateurDto = UtilisateurDto.builder().password(password).mail(login).build();
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

    @RequestMapping(value = "listCommandeLine", method = RequestMethod.POST)
    public @ResponseBody String listCommandeLine(@RequestParam(value = "numeroCommande") int numeroCommande){
        List<CommandeLineDto> maListeDto = iCommandeLineService.findCommandeLineByCommande_NumeroCommande(numeroCommande);
        String json = new Gson().toJson(maListeDto);
        log.debug(json);
        return json;
    }

    @RequestMapping(value = "monCompte", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView afficher(@RequestParam(value = "page", defaultValue = "1") int pageEnCours , HttpSession httpSession) {
        ModelAndView model = new ModelAndView();
        model.setViewName("monCompte");

        UtilisateurDto utilisateurDto = (UtilisateurDto) httpSession.getAttribute("user");
        utilisateurDto = iUserService.getByMail(utilisateurDto);
        List<CommandeDto> listcom = iUserService.getCommandeById(utilisateurDto.getId(), pageEnCours);
        model.addObject("nbElementsParPage", Constantes.ELEMENTS_PAR_PAGE);
        model.addObject("count", this.iUserService.countCommandeByMail(utilisateurDto.getMail()));
        model.addObject("pageEnCours", pageEnCours);
        model.addObject("user", utilisateurDto);
        model.addObject("listeCommande", listcom);

        return model;
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam(value = "nom") String nom,
                                   @RequestParam(value = "prenom") String prenom, @RequestParam(value = "numeroPorte") int numPorte,
                                   @RequestParam(value = "complementAdresse") String complement, @RequestParam(value = "nomRue") String rue,
                                   @RequestParam(value = "ville") String ville, @RequestParam(value = "codePostal") int codePostal,
                                   @RequestParam(value = "pays") String pays, @RequestParam(value = "password") String password,
                                   HttpSession session) {
        ModelAndView model = new ModelAndView();
        model.setViewName("forward:/monCompte");
        UtilisateurDto userTemp = (UtilisateurDto) session.getAttribute("user");

        UtilisateurDto user = UtilisateurDto.builder().nom(nom).pays(pays).prenom(prenom).nomRue(rue)
                .numeroPorte(numPorte).complementAdresse(complement).password(password).codePostal(codePostal)
                .mail(userTemp.getMail()).ville(ville).build();
        log.debug("modificatin de nom: {} et prenom: {}", nom, prenom);

        iUserService.update(user);

        return model;
    }

    @RequestMapping(value = {"/checkmail"}, method = RequestMethod.POST)
    protected @ResponseBody
    String checkMail(@RequestParam(value = "mail") String mail) {
        UtilisateurDto user = UtilisateurDto.builder().mail(mail).build();
        user = iUserService.checkMail(user);
        String message = "";
        if (user == null) {
            message = "Adresse mail valide";
            return message;
        } else {
            message = "Adresse invalide";
            return message;
        }
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    protected ModelAndView deleteUser(@RequestParam(value = "mail") String mail) {
        modelAndView.setViewName("forward:/dashboard");
        iUserService.deleteUtilisateur(mail);
        return modelAndView;
    }

    @RequestMapping(value = "/validerMail", method = RequestMethod.POST)
    protected ModelAndView validerUser(@RequestParam(value = "mail") String mail) {
        modelAndView.setViewName("forward:/dashboard");
        iUserService.activeCompte(mail);
        return modelAndView;
    }

    @RequestMapping(value = "/deconnexion")
    private ModelAndView deconnexion(HttpSession httpSession) {
        ModelAndView model = new ModelAndView();
        httpSession.invalidate();
        model.setViewName("index");
        return model;
    }
}
