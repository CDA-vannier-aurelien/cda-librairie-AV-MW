package fr.cda.librairie.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.cda.librairie.dto.CommandeDto;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.entity.Livre;
import fr.cda.librairie.service.ILivreService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping
public class CommandeController {

	@Autowired
	private ILivreService iLivreService;

	private HashMap<LivreDto, Integer> listeLivre = new HashMap<>();

	@RequestMapping(value = "ajouter", method = RequestMethod.GET)
	public ModelAndView ajoutCommande(@RequestParam(value = "reference") int reference, HttpSession session,
			@RequestParam(value = "quantiteCommandee") int vQuantite) {

		ModelAndView model = new ModelAndView();

		LivreDto livre = iLivreService.getLivre(reference);

		Date dateCommande = new Date();

		listeLivre.put(livre, vQuantite);

		for (Map.Entry<LivreDto, Integer> map : listeLivre.entrySet()) {
			if (map.getKey().getReference() == reference) {
				map.setValue(vQuantite);
			} else {
				listeLivre.put(livre, vQuantite);
			}
		}

		session.setAttribute("panier", listeLivre);

		CommandeDto commande = CommandeDto.builder().dateCommande(new Date()).build();

		log.debug("ajout de commande: {} à la date: {}", commande.getNumeroCommande(), dateCommande);

		model.setViewName("forward:/listeLivre");

		return model;
	}

	@RequestMapping(value = "commander", method = RequestMethod.POST)
	public ModelAndView validerCommande(HttpSession httpSession) {
		HashMap<LivreDto, Integer> maCmd = (HashMap<LivreDto, Integer>) httpSession.getAttribute("panier");
		for (Map.Entry<LivreDto, Integer> livreDtoIntegerEntry : maCmd.entrySet()) {
			Map.Entry pair = (Map.Entry) livreDtoIntegerEntry;
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}

		return null;
	}

	@RequestMapping(value = "supprimerLigne", method = RequestMethod.POST)
	public ModelAndView supprimerLigneCommande(@RequestParam(value = "referenceSupprimee") int reference,
			HttpSession httpSession) {

		HashMap<LivreDto, Integer> maCmd = (HashMap<LivreDto, Integer>) httpSession.getAttribute("panier");
		Set<Entry<LivreDto, Integer>> entrySet = maCmd.entrySet();
		Iterator<Entry<LivreDto, Integer>> it = entrySet.iterator();

		while (it.hasNext()) {
			Entry<LivreDto, Integer> maLigneCommande = it.next();
			if (maLigneCommande.getKey().getReference() == reference) {

				it.remove();
			}
		}
		ModelAndView model = new ModelAndView();

		model.setViewName("panier");
		return model;
	}

}
