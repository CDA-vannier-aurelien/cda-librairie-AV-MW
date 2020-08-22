package fr.cda.librairie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.service.IAuteurService;
import fr.cda.librairie.service.IEditeurService;
import fr.cda.librairie.service.ILivreService;
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.Constantes;
import lombok.extern.slf4j.Slf4j;

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

	@Autowired
	ModelAndView modelAndView;

	@RequestMapping(value = { "/dashboard" }, method = { RequestMethod.GET, RequestMethod.POST })
	protected ModelAndView listerLivresDash(@RequestParam(value = "pageLivre", defaultValue = "1") int pageEnCoursLivre,
			@RequestParam(value = "page", defaultValue = "1") int pageEnCours) {
		log.debug("list livre dash");

		List<LivreDto> vList = this.serviceLivre.getAllLivre(pageEnCoursLivre);
		List<UtilisateurDto> vListUser = this.userService.getAll(pageEnCours, Boolean.FALSE);

		modelAndView.addObject("listeUser", vListUser);
		modelAndView.addObject("nbElementsParPage", Constantes.ELEMENTS_PAR_PAGE);
		modelAndView.addObject("count", this.userService.count());
		modelAndView.addObject("pageEnCours", pageEnCours);

		modelAndView.addObject("listeLivre", vList);
		modelAndView.addObject("nbElementsParPageLivre", Constantes.ELEMENTS_PAR_PAGE);
		modelAndView.addObject("countLivre", this.serviceLivre.count());
		modelAndView.addObject("pageEnCoursLivre", pageEnCoursLivre);

		modelAndView.setViewName("dashboard");
		return modelAndView;
	}

}
