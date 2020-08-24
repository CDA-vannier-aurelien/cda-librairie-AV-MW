package fr.cda.librairie.service;

import fr.cda.librairie.dto.AuteurDto;

import java.util.List;

public interface IAuteurService {
	public AuteurDto addAuteur(AuteurDto auteur);

    public void deleteAuteur(int id);

    public AuteurDto getAuteur(int id);

    public AuteurDto getAuteurByNom(String nom);

    public List<AuteurDto> getAll(String nom);

    public int getMaxId();

    public boolean existByName(String nom);

}
