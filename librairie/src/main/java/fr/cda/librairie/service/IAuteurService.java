package fr.cda.librairie.service;

import fr.cda.librairie.dto.AuteurDto;
import fr.cda.librairie.exception.AuteurPresentException;

public interface IAuteurService {
	public AuteurDto addAuteur(AuteurDto auteur) throws AuteurPresentException;

	public void deleteAuteur(int id);

	public AuteurDto getAuteur(int id);

	public AuteurDto getAuteurByNom(String nom);

	public int getMaxId();

	public boolean existByName(String nom);

}
