package fr.cda.librairie.service;

import java.util.List;

import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.entity.User;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;

public interface IUserService {

    UtilisateurDto create(UtilisateurDto pUser) throws NomVilleIncorrect, NomPaysException, NomRueException, RoleException;

    UtilisateurDto conection(UtilisateurDto pUser);

	UtilisateurDto checkMail(UtilisateurDto user);

	List<UtilisateurDto> getAll(int pageEnCours);

	long count();
    

}
