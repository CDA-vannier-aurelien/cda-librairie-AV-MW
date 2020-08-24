package fr.cda.librairie.service;

import fr.cda.librairie.dto.EditeurDto;

import java.util.List;

public interface IEditeurService {

    public EditeurDto addEditeur(EditeurDto editeur);

    public void deleteEditeur(int id);

    public EditeurDto getEditeur(int id);

    public EditeurDto getEditeurByNom(String nom);

    public List<EditeurDto> getAll(String nom);

    public int getMaxId();

    public boolean existByName(String nom);
}
