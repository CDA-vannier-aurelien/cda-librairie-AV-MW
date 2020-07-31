package fr.cda.librairie.service;

import org.springframework.stereotype.Service;

import fr.cda.librairie.dto.EditeurDto;

@Service
public interface IEditeurService {

	public EditeurDto addEditeur(EditeurDto editeur);

	public void deleteEditeur(int id);

	public EditeurDto getEditeur(int id);

	public EditeurDto getEditeurByNom(String nom);

	public int getMaxId();

	public boolean existByName(String nom);
}
