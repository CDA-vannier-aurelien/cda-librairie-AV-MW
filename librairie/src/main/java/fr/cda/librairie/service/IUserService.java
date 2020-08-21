package fr.cda.librairie.service;

import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface IUserService {

    UtilisateurDto create(UtilisateurDto pUser) throws NomVilleIncorrect, NomPaysException, NomRueException, RoleException;

    UtilisateurDto conection(UtilisateurDto pUser);

	UtilisateurDto checkMail(UtilisateurDto user);

	List<UtilisateurDto> getAll(int pageEnCours);

	UtilisateurDto commander(UtilisateurDto pUser, HashMap<LivreDto, Integer> commande);

	long count();
    
   
}
