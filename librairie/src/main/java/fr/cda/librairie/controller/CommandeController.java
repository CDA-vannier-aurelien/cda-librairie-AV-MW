package fr.cda.librairie.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.cda.librairie.dto.CommandeDto;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.entity.Livre;
import fr.cda.librairie.service.ICommandeLineService;
import fr.cda.librairie.service.ICommandeService;
import fr.cda.librairie.service.ILivreService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping
public class CommandeController {

	@Autowired
	private ILivreService iLivreService;
	
	@Autowired
	private ICommandeService iCommandeService;

	@Autowired
	private ICommandeLineService iCommandeLineService;

	 @RequestMapping(value = "products", method = RequestMethod.POST)
	    public ModelAndView ajoutCommande(@RequestParam(value = "dateCommande") String date,
	 									  @RequestParam(value = "reference") int reference){
		 
	        ModelAndView model = new ModelAndView();	        
	        model.setViewName("panier");
	        
	        
	        List<Livre> listeLivre = new ArrayList<>();        
	        LivreDto livre = iLivreService.getLivre(reference);	    
	        
	        Date dateCommande = new Date();
	        
	        
	        try {
	        	dateCommande = new SimpleDateFormat("yyyy-MM-dd").parse(date);
	        } catch (ParseException e1) {
	            e1.printStackTrace();
	        }
	        
	        CommandeDto commande = CommandeDto.builder().dateCommande(new Date()).build();
	        
	        log.debug("ajout de commande: {} à la date: {}",commande.getNumeroCommande(), dateCommande);

	        
	        return model;
	    }
}
