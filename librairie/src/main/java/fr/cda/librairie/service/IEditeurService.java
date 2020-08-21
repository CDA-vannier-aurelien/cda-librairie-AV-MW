package fr.cda.librairie.service;

import java.util.List;

import fr.cda.librairie.dto.EditeurDto;

public interface IEditeurService {

	public EditeurDto addEditeur(EditeurDto editeur);

	public void deleteEditeur(int id);

	public EditeurDto getEditeur(int id);

	public EditeurDto getEditeurByNom(String nom);

	public List<EditeurDto> getAll();

	public int getMaxId();

	public boolean existByName(String nom);
}
