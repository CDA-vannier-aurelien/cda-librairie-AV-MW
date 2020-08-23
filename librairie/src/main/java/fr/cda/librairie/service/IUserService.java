package fr.cda.librairie.service;

import fr.cda.librairie.dto.CommandeDto;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.dto.UtilisateurDto;

import java.util.HashMap;
import java.util.List;

public interface IUserService {

	UtilisateurDto create(UtilisateurDto pUser);

	UtilisateurDto conection(UtilisateurDto pUser);

	UtilisateurDto checkMail(UtilisateurDto user);

	List<UtilisateurDto> getAll(int pageEnCours, boolean verif);

	void deleteUtilisateur(String email);

	long count();

	long countCommandeByMail(String mail);

	UtilisateurDto update(UtilisateurDto user);

	void passerCommande(UtilisateurDto user, HashMap<LivreDto, Integer> maCmd);

	UtilisateurDto getByMail(UtilisateurDto pUser);

	void activeCompte(String mail);

	List<CommandeDto> getCommandeById(int id, int pageEncours);

	void deleteCommandeByIdCommande(int idCommande, String mail);
}
