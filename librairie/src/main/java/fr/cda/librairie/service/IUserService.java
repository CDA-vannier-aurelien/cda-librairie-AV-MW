package fr.cda.librairie.service;

import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.exception.*;

public interface IUserService {

    UtilisateurDto create(UtilisateurDto pUser) throws NomVilleIncorrect, NomPaysException, NomRueException, RoleException;

    UtilisateurDto conection(UtilisateurDto pUser);

	UtilisateurDto checkMail(UtilisateurDto user);

}
