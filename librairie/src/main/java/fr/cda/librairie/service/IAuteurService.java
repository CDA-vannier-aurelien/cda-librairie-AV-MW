package fr.cda.librairie.service;

import java.util.List;

import fr.cda.librairie.dto.AuteurDto;

public interface IAuteurService {
	public AuteurDto addAuteur(AuteurDto auteur);

	public void deleteAuteur(int id);

	public AuteurDto getAuteur(int id);

	public AuteurDto getAuteurByNom(String nom);

	public List<AuteurDto> getAll(String nom);

	public int getMaxId();

	public boolean existByName(String nom);

}
