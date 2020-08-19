package fr.cda.librairie.service;

import java.util.List;

import fr.cda.librairie.dto.UtilisateurDto;
<<<<<<< HEAD
import fr.cda.librairie.exception.*;
=======
import fr.cda.librairie.entity.User;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;
>>>>>>> Dev

public interface IUserService {

    UtilisateurDto create(UtilisateurDto pUser) throws NomVilleIncorrect, NomPaysException, NomRueException, RoleException;

    UtilisateurDto conection(UtilisateurDto pUser);

	UtilisateurDto checkMail(UtilisateurDto user);

<<<<<<< HEAD
=======
	List<UtilisateurDto> getAll(int pageEnCours);

	long count();
    
   
>>>>>>> Dev
}
