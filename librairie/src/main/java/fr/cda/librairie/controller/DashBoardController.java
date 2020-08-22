package fr.cda.librairie.controller;

import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.service.IAuteurService;
import fr.cda.librairie.service.IEditeurService;
import fr.cda.librairie.service.ILivreService;
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class DashBoardController {

    @Autowired
    ILivreService serviceLivre;

    @Autowired
    IAuteurService serviceAuteur;

    @Autowired
    IEditeurService serviceEditeur;

    @Autowired
    IUserService userService;

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    protected ModelAndView listerLivresDash(@RequestParam(value = "pageLivre", defaultValue = "1") int pageEnCoursLivre,
                                            @RequestParam(value = "page", defaultValue = "1") int pageEnCours) {
        log.debug("list livre dash");

        ModelAndView model = new ModelAndView();

        List<LivreDto> vList = this.serviceLivre.getAllLivre(pageEnCoursLivre);
        List<UtilisateurDto> vListUser = this.userService.getAll(pageEnCours);

        model.addObject("listeUser", vListUser);
        model.addObject("nbElementsParPage", Constantes.ELEMENTS_PAR_PAGE);
        model.addObject("count", this.userService.count());
        model.addObject("pageEnCours", pageEnCours);

        model.addObject("listeLivre", vList);
        model.addObject("nbElementsParPageLivre", Constantes.ELEMENTS_PAR_PAGE);
        model.addObject("countLivre", this.serviceLivre.count());
        model.addObject("pageEnCoursLivre", pageEnCoursLivre);

        model.setViewName("dashboard");
        return model;
    }

}
