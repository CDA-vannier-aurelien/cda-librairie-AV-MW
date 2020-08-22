package fr.cda.librairie.controller;

import com.google.gson.Gson;
import fr.cda.librairie.dto.AuteurDto;
import fr.cda.librairie.dto.EditeurDto;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.service.IAuteurService;
import fr.cda.librairie.service.IEditeurService;
import fr.cda.librairie.service.ILivreService;
import fr.cda.librairie.utils.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class LivreController {

    @Autowired
    ILivreService serviceLivre;

    @Autowired
    IAuteurService serviceAuteur;

    @Autowired
    IEditeurService serviceEditeur;

    @RequestMapping(value = {"/listeLivre"}, method = {RequestMethod.GET, RequestMethod.POST})
    protected ModelAndView listerLivre(@RequestParam(value = "page", defaultValue = "1") int pageEnCours) {
        log.debug("list livre");

        ModelAndView model = new ModelAndView();

        List<LivreDto> vList = this.serviceLivre.getAllLivre(pageEnCours);

        model.addObject("liste", vList);
        model.addObject("nbElementsParPage", Constantes.ELEMENTS_PAR_PAGE);
        model.addObject("count", this.serviceLivre.count());
        model.addObject("pageEnCours", pageEnCours);

        model.setViewName("product");
        return model;
    }

    @RequestMapping(value = {"/addLivre"}, method = RequestMethod.POST)
    protected ModelAndView addLivre(@RequestParam(value = "prix") int prix,
                                    @RequestParam(value = "reference") int reference, @RequestParam(value = "quantitee") int quantitee,
                                    @RequestParam(value = "titre") String titre, @RequestParam(value = "nbPage") int nbPage,
                                    @RequestParam(value = "auteur") String auteur, @RequestParam(value = "editeur") String editeur,
                                    @RequestParam(value = "description") String description) {
        log.debug("YOUHOU");

        LivreDto livre = new LivreDto(reference, prix, quantitee, titre, nbPage, auteur, description, editeur);

        livre = serviceLivre.addLivre(livre);

        ModelAndView model = new ModelAndView();

        model.setViewName("dashboard");
        return model;
    }

    @RequestMapping(value = {"/checkRef"}, method = RequestMethod.POST)
    protected @ResponseBody
    String checkRef(@RequestParam(value = "reference") int reference) {

        String message = "";

        if (!serviceLivre.existByReference(reference)) {
            message = "exists";
        }
        return message;
    }

	@RequestMapping(value = { "/checkAuteur" }, method = RequestMethod.POST)
	protected @ResponseBody String checkAuteur(@RequestParam(value = "nomUsage") String nomUsageAuteur) {

		String message = "";

		if (serviceAuteur.existByName(nomUsageAuteur)) {
			message = "exists";
		}
		return message;
	}

	@RequestMapping(value = { "/checkEditeur" }, method = RequestMethod.POST)
	protected @ResponseBody String checkEditeur(@RequestParam(value = "nom") String nomEditeur) {

		String message = "";

		if (serviceEditeur.existByName(nomEditeur)) {
			message = "exists";
		}
		return message;
	}

	@RequestMapping(value = { "/addOptionAuteur" }, method = RequestMethod.POST)
	protected @ResponseBody String addOptionAuteur(@RequestParam(value = "nomUsage") String nomUsage) {

		List<AuteurDto> listAuteur = this.serviceAuteur.getAll(nomUsage);

        String[] tabNom = new String[listAuteur.size()];

        for (int i = 0; i < listAuteur.size(); i++) {
            tabNom[i] = listAuteur.get(i).getNomUsage();
        }
        String json = new Gson().toJson(tabNom);

        return json;
    }

	@RequestMapping(value = { "/addOptionEditeur" }, method = RequestMethod.POST)
	protected @ResponseBody String addOptionEditeur(@RequestParam(value = "nom") String nomEditeur) {

        List<EditeurDto> listEditeur = this.serviceEditeur.getAll(nomEditeur);

        String[] tabNom = new String[listEditeur.size()];

        for (int i = 0; i < listEditeur.size(); i++) {
            tabNom[i] = listEditeur.get(i).getNom();
        }
        String json = new Gson().toJson(tabNom);

        return json;

    }

	@RequestMapping(value = { "/addAuteur" }, method = RequestMethod.POST)
	protected ModelAndView addAuteur(@RequestParam(value = "nomAuteur") String nom,
			@RequestParam(value = "prenomAuteur") String prenom, @RequestParam(value = "nomUsage") String nomUsage) {
		log.debug("add auteur");

		AuteurDto auteur = new AuteurDto();
		auteur.setNom(nom);
		auteur.setNomUsage(nomUsage);
		auteur.setPrenom(prenom);
		auteur = serviceAuteur.addAuteur(auteur);

		ModelAndView model = new ModelAndView();

		model.setViewName("dashboard");
		return model;
	}

	@RequestMapping(value = { "/addEditeur" }, method = RequestMethod.POST)
	protected ModelAndView addEditeur(@RequestParam(value = "nomEditeur") String nomEditeur) {
		log.debug("add editeur");

		EditeurDto editeur = new EditeurDto();
		editeur.setNom(nomEditeur);
		editeur = serviceEditeur.addEditeur(editeur);

		ModelAndView model = new ModelAndView();

		model.setViewName("dashboard");
		return model;
	}

}
