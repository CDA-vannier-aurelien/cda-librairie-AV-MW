package fr.cda.librairie.service;

import org.springframework.stereotype.Service;

import fr.cda.librairie.entity.Editeur;

@Service
public interface IEditeurService {

	public void addEditeur(Editeur editeur);

	public void deleteEditeur(int id);

	public Editeur getEditeur(int id);

	public Editeur getEditeurByNom(String nom);
}
