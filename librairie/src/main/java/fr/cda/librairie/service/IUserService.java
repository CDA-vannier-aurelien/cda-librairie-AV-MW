package fr.cda.librairie.service;

import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.exeption.NomPaysException;
import fr.cda.librairie.exeption.NomRueExecption;
import fr.cda.librairie.exeption.NomVilleIncorrect;
import fr.cda.librairie.exeption.RoleExecption;

public interface IUserService {

    UtilisateurDto create(UtilisateurDto pUser) throws NomVilleIncorrect, NomPaysException, NomRueExecption, RoleExecption;

}
