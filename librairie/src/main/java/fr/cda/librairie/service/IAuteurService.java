package fr.cda.librairie.service;

import org.springframework.stereotype.Service;

import fr.cda.librairie.entity.Auteur;

@Service
public interface IAuteurService {
	public void addAuteur(Auteur auteur);

	public void deleteAuteur(int id);

	public Auteur getAuteur(int id);

	public Auteur getAuteurByNom(String nom);
}
