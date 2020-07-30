package fr.cda.librairie.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.cda.librairie.entity.Editeur;

@Repository
public interface IEditeurDao extends CrudRepository<Editeur, Integer> {
	public Editeur findByNom(String nom);

}
